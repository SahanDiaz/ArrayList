package com.newProject;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("71424535435");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();

        while (!quit) {
            System.out.println(">>>");
            mobilePhone.menu();
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("quiting...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContact();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                    case 4:
                        removeContact();break;
                    case 5:
                        searchContact();break;
                default:
                    System.out.println("enter number between 0-5 ");
            }
        }
    }

    private static void startPhone() {
        System.out.println("starting phone...."); 
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("enter new number : ");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createContact(phone, name);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("new contact added " + name + " , phone : " + phone);
        } else {
            System.out.println("cant add " + phone);
        }
    }

    public static void updateContact() {
        System.out.println("Enter old contact name : ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("contact not found");
            return;
        }
        ;
        System.out.println("Enter new contact name : ");
        String updateName = scanner.nextLine();
        System.out.println("Enter new contact number : ");
        String number = scanner.nextLine();
        Contacts newContact = Contacts.createContact(number, name);
        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("update contact");
        } else {
            System.out.println("error in update contact");
        }
    }

    public static void removeContact() {
        System.out.println("Enter old contact name : ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingContact)) {
            System.out.println("successfully deleted");
        } else {
            System.out.println("error deleting record");
        }
    }
    public static void searchContact() {
        System.out.println("Enter old contact name : ");
        String name = scanner.nextLine();
        Contacts existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("contact not found");
            return;
        }
        System.out.println("name : "+existingContact.getName()+ " phone : "+existingContact.getNumber());

    }
}
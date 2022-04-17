package com.newProject;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private String myNumber;
    private static ArrayList<Contacts> arrayList = new ArrayList<Contacts>();

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.arrayList = new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public static ArrayList<Contacts> getArrayList() {
        return arrayList;
    }

    boolean addNewContact(Contacts contacts){
        if(findContact(contacts.getName())>=0){
            System.out.println("contact is already on file");
            return false;
        }
        arrayList.add(contacts);
        return true;
    }
    public int findContact(Contacts contacts){
        return this.arrayList.indexOf(contacts);
    }
    public int findContact(String contactName){
         for (int i=0;i<this.arrayList.size();i++){
             Contacts contacts = this.arrayList.get(i);
             if(contacts.getName().equals(contactName)){
                 return i;
             }
         }
         return -1;
    }
    public String queryContact(Contacts contacts){
        if(findContact(contacts)>=0){
            return  contacts.getName();
        }
        return null;
    }
    public Contacts queryContact(String name){
        int position = findContact(name);
        if(position>=0){
            return this.arrayList.get(position);
        }
        return null;
    }
    public boolean updateContact(Contacts oldContact,Contacts newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition<0){
            System.out.println(oldContact.getName() + " not found");
            return false;
        }
        this.arrayList.set(foundPosition,newContact);
        System.out.println(oldContact.getName()+" , was not found." );
        return true;
    }
    public boolean removeContact(Contacts contacts){
        int foundPosition = findContact(contacts);
        if(foundPosition>=0){
            this.arrayList.remove(foundPosition);
            System.out.println(contacts.getName()+" deleted");
            return true;
        }
        return false;
    }
    public static boolean Quit(){
        boolean quit = true;
        return quit;
    }
    public  void printContact(){
        for(int x =0;x<arrayList.size();x++){
            System.out.println(x+1+" - "+
                    this.arrayList.get(x).getName() + " -> "+
                    this.arrayList.get(x).getNumber());
        }
    }

    static void menu(){
        System.out.println("--------------Contact Menu-------------");
        System.out.println("1 - print");
        System.out.println("2 - add new");
        System.out.println("3 - update");
        System.out.println("4 - remove ");
        System.out.println("5 - search");
        System.out.println("0 - quit");
        System.out.println("Choose your action : ");
    }


}

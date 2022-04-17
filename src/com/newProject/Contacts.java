package com.newProject;

public class Contacts  {
    private String number;
    private String name;

    public Contacts(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    static Contacts createContact( String number,String name){
        return new Contacts( number,name );
    }
}

package com.ayesha.judicial_provision.Lawyers_Portal;

public class lawyer {
    private String  n,ph,sp;

    public lawyer(String name, String phNo, String specialty) {
        this.n=name;
        this.ph=phNo;
        this.sp=specialty;
    }
    public String getName(){return n;}
    public  String getNumber(){return ph;}
    public  String getSpeciality(){return sp;}
}

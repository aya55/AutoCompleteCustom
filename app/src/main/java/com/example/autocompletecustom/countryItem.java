package com.example.autocompletecustom;

public class countryItem {
    private String countryName;
    private  int  flagImage;
    public  countryItem(String countryName,int flagImage){

        this.countryName=countryName;
        this .flagImage=flagImage;


    }
    public String getCountryName (){

        return countryName;

    } public int getFlageImage(){

        return flagImage;

    }
}

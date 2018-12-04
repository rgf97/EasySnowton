package com.example.c50.easysnowton;

public class SnowtanItem {

    private String snowtanName;
    private int countryFlag;

    public SnowtanItem(String snowtanName, int countryFlag){

        this.snowtanName = snowtanName;
        this.countryFlag = countryFlag;
    }

    public String getSnowtanName() {
        return snowtanName;
    }

    public int getCountryFlag(){
        return countryFlag;
    }

}

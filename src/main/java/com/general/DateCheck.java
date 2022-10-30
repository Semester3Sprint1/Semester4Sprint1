package com.general;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCheck implements  DateValidator{

    private String dateFormat;
    private  Date date1;
    private Date date2;

    public DateCheck(Date date1, Date date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    public DateCheck(String dateFormat) {
        this.dateFormat = dateFormat;
    }


    @Override
    public int dateCheck(){

        if(date1.before(date2))
            return 1;
        else if(date1.after(date2))
            return -1;
        else return 0;

    }

    @Override
    public boolean isValid(String dateString) {
        DateFormat stringFormat = new SimpleDateFormat(this.dateFormat);
        stringFormat.setLenient(false);
        try{
            stringFormat.parse(dateString);
        }catch(ParseException e){
            System.out.println("Invalid Entry. Use the format mm/dd/yyyy");
            return false;
        }

        return true;
    }
}

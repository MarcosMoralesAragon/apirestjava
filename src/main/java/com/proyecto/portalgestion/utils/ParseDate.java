package com.proyecto.portalgestion.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseDate {

    private static DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public String dateToString(Date fecha){
        if (fecha != null){
            return format.format(fecha);
        } else {
            return null;
        }
    }
    public Date stringToDate(String date){
        if (date != null) {
            try {
                return format.parse(date);
            } catch (ParseException e) {return null;}
        } else {
            return null;
        }
    }
}

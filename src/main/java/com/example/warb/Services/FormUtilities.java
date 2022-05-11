package com.example.warb.Services;

public class FormUtilities {

    //Y for Year, T for Term
    public boolean validateAttendanceForm(String Y1T1,String Y1T2, String Y1T3,
                                          String Y2T1,String Y2T2, String Y2T3,
                                          String Y3T1,String Y3T2, String Y3T3,
                                          String Y4T1,String Y4T2, String Y4T3,
                                          String Y5T1,String Y5T2, String Y5T3,
                                          String Y6T1,String Y6T2, String Y6T3){
        //Returns a True or False value if any of the strings are empty
        return    !Y1T1.equals("") ||  !Y1T2.equals("") ||   !Y1T3.equals("")
                || !Y2T1.equals("")||  !Y2T2.equals("") ||   !Y2T3.equals("")
                || !Y3T1.equals("")||  !Y3T2.equals("") ||   !Y3T3.equals("")
                || !Y4T1.equals("")||  !Y4T2.equals("") ||   !Y4T3.equals("")
                || !Y5T1.equals("")||  !Y5T2.equals("") ||   !Y5T3.equals("")
                || !Y6T1.equals("")||  !Y6T2.equals("") ||   !Y6T3.equals("");

    }

}

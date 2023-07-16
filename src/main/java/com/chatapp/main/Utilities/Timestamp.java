package com.chatapp.main.Utilities;

import java.time.LocalDate;

public class Timestamp {
	public static String getTodayDate() {
		LocalDate currentDate = LocalDate.now();
        //System.out.println("Today's date: " + currentDate);
        return currentDate+"";
    }
}

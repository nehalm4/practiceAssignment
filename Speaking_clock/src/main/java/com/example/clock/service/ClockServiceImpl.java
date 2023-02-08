package com.example.clock.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ClockServiceImpl implements ClockService{

	@Override
	public String convertCurrentTime(Date currentDate) {
		SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm a");
        String[] single_digits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        String input = null;
        String finalString = "";
        
        try {
        	input = formatDate.format(currentDate).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
    
        if(input == null || input == "") {
        	finalString = "Please provide input Date in format:- (hh:mm a)";
        } else {
        
        boolean isAmPm = input.contains("am");
        String str = input.substring(0, 5);
        input = str.replace(":", "");

        char[] ch = input.toCharArray();
        for (int i = 0; i < ch.length; i++) {
        	if(single_digits[ch[i] - '0'] == "zero" && i == 0) {
        	} else {
        		finalString = finalString + " " + single_digits[ch[i] - '0'];
        	}
        }

        if (isAmPm) {
            finalString = finalString + " " + " Midday";
        } else{
            finalString = finalString + " " + " Midnight";
        }
		return finalString;
	}
        return finalString;
	}
	
}

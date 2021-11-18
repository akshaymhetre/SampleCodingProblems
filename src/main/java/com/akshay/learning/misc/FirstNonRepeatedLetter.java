package com.akshay.learning.misc;

public class FirstNonRepeatedLetter {
    public String firstNonRepeatingLetter(String str) {
        if(str == null) return "";
        String lowerStr = str.toLowerCase();
        for(int i = 0; i < str.trim().length(); i++){
            if(lowerStr.indexOf(lowerStr.charAt(i)) == lowerStr.lastIndexOf(lowerStr.charAt(i))){
                return Character.toString(str.charAt(i));
            }
        }
        return "";
    }
}

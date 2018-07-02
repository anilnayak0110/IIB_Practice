package com.anilnayak.test;

import java.util.Random;

public class GenerateRandomTest {

    public static Long generateRandom(){
    	 Random randomGenerator = new Random();
    	 long randomInt = randomGenerator.nextInt(10);
    	 return randomInt;
    }
    public static String getAlphanumericRandomNumber(){
    	 char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    	    StringBuilder sb = new StringBuilder(3);
    	    Random random = new Random();
    	    for (int i = 0; i < 3; i++) {
    	        char c = chars[random.nextInt(chars.length)];
    	        sb.append(c);
    	    }
    	    String output = sb.toString();
    	   
			return output;
    }
   
    public static void main(String[] args) {
    	System.out.println(generateRandom());
    	System.out.println(getAlphanumericRandomNumber());
	}

}

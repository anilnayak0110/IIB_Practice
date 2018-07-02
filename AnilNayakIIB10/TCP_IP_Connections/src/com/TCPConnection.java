package com;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPConnection {
	
	
	 public static void main(String argv[]) throws Exception {
		  String sentence;
		  String modifiedSentence;
		  Socket clientSocket = new Socket("192.168.3.42", 1228);
		  int i =0;
		  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		  PrintWriter output = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		  File inputF = new File("C:/Users/bandaru/Documents/a0100.txt");

	      InputStream inputFS = new FileInputStream(inputF);

	      BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
	      String line1 ="";
	      String line ="";
	      while ((line =  br.readLine()) != null){
	    	  line1 = line1+line;
	      }
	    	  System.out.println(line1);
		while(i<10){ 
		
			//String s = "Â0100ò>FÔ)à‘ ";

            //Sending Client Hello
			System.out.println("Sending" +line1);
			
            output.print(line1);                
            output.flush();

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
            
            int ch;
            StringBuilder sb = new StringBuilder();
            System.out.println("recieving");
            while((ch = input.read()) != -1){
                sb.append((char)ch);
            }
            
            System.out.println(sb);
            System.out.println("done");
          
		 }
		 
		 clientSocket.close();
		 }

}

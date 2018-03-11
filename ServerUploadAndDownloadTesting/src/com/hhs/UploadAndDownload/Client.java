package com.hhs.UploadAndDownload;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
	public static void main(String[] args) throws Exception{
		Socket s=new Socket("localhost", 8888);
		PrintWriter pw=new PrintWriter(s.getOutputStream());
		Scanner kbs=new Scanner(System.in);
		System.out.print("Please input the filename you want to upload:");
		File file=new File(kbs.next());
		if(file.exists()==false){
			System.out.println("The file doesn't exist!");
			System.exit(2);
		}
		if(file.isDirectory()){
			System.out.println("I need a file,not a directory!!!");
			System.exit(3);
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String filedetail="";
		String temp="";
		while((temp=br.readLine())!=null){
			filedetail+="\n"+temp;
		}
		pw.println(file.getName());
		pw.println(filedetail);
		
		
		
		BufferedReader brs=new BufferedReader(new InputStreamReader(s.getInputStream()));
		brs.readLine();
		System.out.println("[Client@"+System.currentTimeMillis()+"]Uploaded!");
	}
}

package com.hhs.UploadAndDownload;


import java.net.*;

public class Server {

	
	public static void main(String[] args) throws Exception{

		
		ServerSocket ss=new ServerSocket(8888);
		System.out.println("[Server@"+System.currentTimeMillis()+"]Server ready");
		while(true){
			Socket s=ss.accept();
			ServerThread st=new ServerThread(s);
			st.start();
			
		}
	}
}

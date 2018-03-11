package com.hhs.UploadAndDownload;
import java.net.*;
import java.io.*;
public class ServerThread extends Thread {
	Socket socket=null;
	public ServerThread(Socket socket){
		System.out.println("[Server@"+System.currentTimeMillis()+"]Thread Ready");
		this.socket=socket;
	}
	
	public void run(){
		try {
			BufferedReader ois=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String filename=ois.readLine();
			String filedetail=ois.readLine();
			System.out.println("[Server@"+System.currentTimeMillis()+"]Filename:"+filename+",Filedetail:"+filedetail);
			PrintWriter pw=new PrintWriter(new FileWriter("/uploads/"+filename));
			pw.print(filedetail);
			PrintWriter pw2=new PrintWriter(socket.getOutputStream());
			pw2.println("Finish!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[Server@"+System.currentTimeMillis()+"]Connect lost");
			e.printStackTrace();
			System.exit(2);
		}
	}
}

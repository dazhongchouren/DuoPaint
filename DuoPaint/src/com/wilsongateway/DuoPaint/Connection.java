package com.wilsongateway.DuoPaint;
import java.awt.Color;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {
	
	private Socket recipient;
	private ObjectOutputStream out;
	
	public Connection(Socket temp){
		recipient = temp;
		try {
			out = new ObjectOutputStream(recipient.getOutputStream());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void close(){
		try {
			recipient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendStroke(int x, int y, int oldX, int oldY, Color c) {
		try {
			out.writeObject(new int[]{x, y, oldX, oldY});
			out.writeObject(c);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendClear(){
		try{
			out.writeObject(new int[]{1});
			out.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

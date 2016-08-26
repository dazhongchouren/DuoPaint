package com.wilsongateway.DuoPaint;
import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client implements Runnable{
	
	private ObjectInputStream in;
	
	private static boolean clientRunning;
	private Socket connection;
	
	@Override
	public void run() {
		clientRunning = true;
		try {
			connection = new Socket(MainFrame.getIP(), MainFrame.getPort());
			in = new ObjectInputStream(connection.getInputStream());
			MainFrame.setPaintMode(false);
			Server.stopServer();
			
			while(clientRunning){
				int[] data = (int[]) in.readObject();
				
				if(data.length == 4){
					Color colorData = (Color) in.readObject();
					MainFrame.setColor(colorData);
					MainFrame.paintStroke(data[0], data[1], data[2], data[3]);
				}else{
					MainFrame.clearCanvas();
				}
			}
			connection.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Could not connect to that PC!");
			MainFrame.setPaintMode(true);
		}
		
	}
	public static void stopClient(){
		clientRunning = false;
	}
}

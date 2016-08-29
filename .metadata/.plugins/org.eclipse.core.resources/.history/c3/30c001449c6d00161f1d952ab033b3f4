package com.wilsongateway.DuoPaint;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Server implements Runnable{

	private static boolean serverRunning;
	private static String ip;
	private static int port;
	
	private static ArrayList<Connection> connections;
	
	@Override
	public void run(){
		connections = new ArrayList<Connection>();
		System.out.println("thread started");
		serverRunning = true;
		try {
			ServerSocket server = new ServerSocket(0);
			Socket socket;
			server.getInetAddress();
			ip = InetAddress.getLocalHost().getHostAddress();
			port = server.getLocalPort();
			
			MainFrame.setPaintMode(true);
			while(serverRunning){
				if((socket = server.accept()) != null){
					Connection c = new Connection(socket);
					connections.add(c);
					System.out.print("Accepted Connection");
				}
			}
			System.out.println("server loop ended!");
			for(Connection c : getConnections()){
				c.close();
			}
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "There was an error when trying to start the server! Try a different port.");
		}
	}
	public static String getServerIP(){
		return ip;
	}
	public static int getServerPort(){
		return port;
	}
	public static void stopServer(){
		serverRunning = false;
	}
	public static void addConnection(Connection conn){
		connections.add(conn);
	}
	public static ArrayList<Connection> getConnections(){
		return connections;
	}
}

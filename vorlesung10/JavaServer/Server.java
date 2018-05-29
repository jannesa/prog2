package JavaServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
	
	private HashMap<Socket, ReceiveMsgThread> connections = new HashMap<>();
	
	public Server() {

		//port über den der Client und der Server reden
		int port = 4444;
		
		try {
			//Das ServerSocket wird an den Port gebunden
			//Über das ServerSocket können sich 100 Clients verbinden
			ServerSocket serverSocket = new ServerSocket(port, 100);
			
			//wenn sich 100 Clients mit dem Server verbunden haben, 
			//soll der Server beendet werden
			for (int i = 0; i < 100; i++) {
				
				System.out.println("Waiting for Client to connect");
				//warte darauf, bis sich ein Client verbindet
				//wenn sich ein Client verbunden hat, kann der Server mit Hilfe des Sockets
				//mit dem Client kommunizieren
				Socket socket = serverSocket.accept();
	
				System.out.println("Client is connected: " + socket.getInetAddress().getHostAddress());
				
				//erstelle für jeden verbundenen Client einen Thread, 
				//der darauf horcht, ob der jeweilige Client eine Nachricht schickt.
				//wird eine Nachricht empfangen, 
				//wird die Nachricht an alle anderen User weiter geschickt
				ReceiveMsgThread thread = new ReceiveMsgThread(socket, connections);
				//alle Verbindungen werden in einer HashMap gespeichert
				connections.put(socket, thread);
				thread.start();
			
			}			

			//beende das Serversocket
			serverSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		
	public static void main(String[] args) {
		new Server();
	}
}

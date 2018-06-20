package JavaServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class ReceiveMsgThread extends Thread {
	
	//boolean wert um den Thread sp�ter zu beenden
	private boolean isRunning = false;
	
	//�ber den Scanner liest der Thread alle Nachrichten eines Clients
	private Scanner in;
	
	//Referenz auf die HashMap in der Serverklasse
	private HashMap<Socket, ReceiveMsgThread> connections;
	
	//Socket des zu dem Thread geh�rigen Clients
	private Socket ownSocket;
	
	public ReceiveMsgThread(Socket socket, HashMap<Socket, ReceiveMsgThread> connections) {
		this.connections = connections;
		this.ownSocket = socket;
		System.out.println("ich bin mit dem Client " + socket.getInetAddress().getHostAddress() + " verbunden");
		
		try {
			//erstell einen Scanner, um �ber diesen alle Nachrichten des Clients zu lesen
			in = new Scanner(socket.getInputStream());
			isRunning = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		super.run();
		
		while (isRunning) {
			//warte auf eine Nachricht des Clients

			
			try {
				
				String msg = in.nextLine();
				System.out.println(msg);
				//schicke die Nachricht an alle anderen Clients
				//iteriere daf�r �ber die HashMap und 
				//hol die keys (sockets) als Set
				Set<Socket> keys = connections.keySet();
				for(Socket socket : keys) {
					if(socket != ownSocket) {
//						//schick die Nachricht �ber die Sockets der Clients
						PrintWriter pw = new PrintWriter(socket.getOutputStream());
						pw.println(msg);
						pw.flush();
//						//TODO Testen, ob es funktioniert, 
//						//wenn man ohne Verz�gerung den PrintWriter schlie�t
//						pw.close();
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}catch (NoSuchElementException e) {
				System.err.println("Die Verbindung zum Client wurde auf Grund eines Fehlers beendet");
				
				if(ownSocket.isClosed())
					System.out.println("Socket is closed");
				else
					System.out.println("Socket not closed");
				//wenn ein Fehler beim lesen auftaucht,
				//wird die Verbindung zum Client beendet
				connections.remove(ownSocket);
				stopThread();
			}
			
		}
		
	}
	
	public void stopThread() 
	{
		isRunning = false;
		in.close();
		try {
			ownSocket.close();
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}

}

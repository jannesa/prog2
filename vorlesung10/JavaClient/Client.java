package JavaClient;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	boolean scanning = true ;
	
	public Client() {
		//port über den der Client und der Server reden
		int port = 12345;
		//ip addresse vom server
//		String serverIP = "127.0.0.1";
//		String serverIP = "141.22.51.69";
		String serverIP = "141.22.51.76";
		
		
		while(scanning){
			try {

				System.out.println("Try to connect to server");
				//baue Verbindung zum Server mit der serverIP und dem port auf
				Socket socket = new Socket(serverIP, port);
				scanning = false ;
				
				System.out.println("Connected: " + socket.getInetAddress().getHostAddress());

				//erstelle und starte einen Thread, der dauerhaft horcht,
				//ob Nachrichten vom Server ankommen (anderen Clients)
				ReceiveMsgThread inputThread = new ReceiveMsgThread(socket);
				inputThread.start();

				//erstelle einen PrintWriter und 
				//schreibe zukünftig die Nachrichten über das Socket
				//schreibe eine Nachricht an den Server/an alle anderen Clients
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				Scanner in = new Scanner(System.in);
				String msg = in.nextLine();
				//Schreibt der User Quit, wird das Programm beendet
				while(!msg.equals("Quit")) {
					out.println(msg);
					out.flush();
					System.out.println("Die Nachricht wurde gesendet");
					msg = in.nextLine();
				}

				//wenn das Programm beendet wird, soll der Thread beendet werden
				inputThread.stopThread();

				//Es müssen immer alle Reader/Writer/Sockets geschlossen werden
				in.close();
				out.close();
				socket.close();
			} catch (Exception e) {
//				e.printStackTrace();
				
				System.out.println("Port: " + port);
//				port ++ ;
				
				
			}
		}
		try {

			System.out.println("Try to connect to server");
			//baue Verbindung zum Server mit der serverIP und dem port auf
			Socket socket = new Socket(serverIP, port);
			
			System.out.println("Connected: " + socket.getInetAddress().getHostAddress());

			//erstelle und starte einen Thread, der dauerhaft horcht,
			//ob Nachrichten vom Server ankommen (anderen Clients)
			ReceiveMsgThread inputThread = new ReceiveMsgThread(socket);
			inputThread.start();

			//erstelle einen PrintWriter und 
			//schreibe zukünftig die Nachrichten über das Socket
			//schreibe eine Nachricht an den Server/an alle anderen Clients
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			Scanner in = new Scanner(System.in);
			String msg = in.nextLine();
			//Schreibt der User Quit, wird das Programm beendet
			while(!msg.equals("Quit")) {
				out.println(msg);
				out.flush();
				System.out.println("Die Nachricht wurde gesendet");
				msg = in.nextLine();
			}

			//wenn das Programm beendet wird, soll der Thread beendet werden
			inputThread.stopThread();

			//Es müssen immer alle Reader/Writer/Sockets geschlossen werden
			in.close();
			out.close();
			socket.close();
		} catch (Exception e) {
//			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		new Client();
	}
}

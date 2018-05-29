package JavaClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ReceiveMsgThread extends Thread {
	
	private boolean isRunning = false;
	private Scanner in;
	private Socket socket;
	
	public ReceiveMsgThread(Socket socket) {
		this.socket = socket;
		try {
			//erstell ein Scanner, der Nachrichten über das Socket empfängt
			in = new Scanner(socket.getInputStream());
			isRunning = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		super.run();
		
		//warte auf Nachrichten und geb sie in der Konsole aus
		while (isRunning) {
			try {
				System.out.println(in.nextLine());
				
			} catch (Exception e) {
				System.err.println("NoSuchAElement ex");
				if(socket.isClosed()) 
					System.out.println("Socket is closed");
				else
					System.out.println("Socket not closed");
				// TODO: handle exception
			}
			
		}
		
	}
	
	public void stopThread() 
	{
		//beende den Thread und schliesse den Scanner
		isRunning = false;
		in.close();
	}

}

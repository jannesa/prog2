package Sync;

public class Starter {

	
	public static void main(String[] args) {
		DecrementThread [] decreThreads = new DecrementThread [5];
		InkrementThread [] inkreThreads = new InkrementThread [5];
		ValueClass valueClass = new ValueClass();
		
		for (int i = 0; i < decreThreads.length; i++) {
			decreThreads[i] = new DecrementThread(valueClass);
			inkreThreads[i] = new InkrementThread(valueClass);
			decreThreads[i].start();
			inkreThreads[i].start();
		}
		
		try {
			Thread.sleep(30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < decreThreads.length; i++) {
			decreThreads[i].stopThread();
			inkreThreads[i].stopThread();
		}
	}
}

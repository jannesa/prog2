package StringToHashSet;

import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		String formen[] = {"viereck","quadrat","kreis","viereck"} ;
		HashSet<String> hset = new HashSet<String>() ;
		
		
		//Daten vom Array in das Set schreiben.
		for(int i= 0; i< formen.length;i++){
			System.out.println("Normal Array: " + formen[i]);
			hset.add(formen[i]);
		}
		
		
		
		//Set iterieren und ausgeben bzw. auslesen:
		Iterator<String> ite = hset.iterator() ;
		while(ite.hasNext()){
			System.out.println("HashSet: " + ite.next());
		}

	}

}

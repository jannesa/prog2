package TxtToHashMap;

import java.io.*;
import java.util.ArrayList;
public class Main {


	  public static void main(String[] args) throws IOException {
		  
	    
		  File file = new File("files/names.txt");
		  BufferedReader br = new BufferedReader(new FileReader(file));
		  ArrayList<Object> list = new ArrayList<>() ;
	    
		  
		  
		  
		  
		  
		  
		  
		  
		  String tmpt = "Platzhalter" ;
		  
		  while (tmpt!= null){
			  tmpt = br.readLine();
	    	
			  if (list.contains(tmpt)){
				  System.out.println(tmpt +": Name schon vorhanden!");
			  }
			  else if(tmpt!= null) {
				  list.add(tmpt) ;
				  System.out.println("Saved: " + tmpt);
			  }
		  }
	   
		  System.out.println("Und nochmal die ganze Liste: "+ list);
		  br.close();
	    
	    
	  }
}
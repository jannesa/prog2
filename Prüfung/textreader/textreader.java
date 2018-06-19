package textreader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class textreader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dokument = new File("file/words.txt");
		File newdokument = new File("file/newwords.txt");
		BufferedReader reader = new BufferedReader(new FileReader(dokument));
		BufferedWriter writer = new BufferedWriter(new FileWriter(newdokument));
		
		String readed = "";
		System.out.println("Start....");
		while(readed != null) {
			readed = reader.readLine();
			if(readed != null &&readed.contains("#")) {
				writer.write(readed + "\n");
				writer.flush();
			}
			System.out.println("....");
			
		}
		reader.close();
		writer.close();
		System.out.println("Done....");
		
		
		
	}

}

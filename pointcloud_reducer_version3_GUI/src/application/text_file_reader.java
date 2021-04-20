package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class text_file_reader {
	
	private volatile LinkedList<String> data = new LinkedList<String>();
	private double count =0;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	public text_file_reader(File directory) throws FileNotFoundException, IOException {				
		@SuppressWarnings("unused")
		String line = null;
		this.fileReader = new FileReader(directory.getAbsoluteFile());	
		this.bufferedReader = new BufferedReader(fileReader);	
	}
	
	public LinkedList<String> read(int lines) throws NumberFormatException, IOException, OutOfMemoryError {				
		@SuppressWarnings("unused")
		String line = "";
		data.add(bufferedReader.readLine());
		
		while((line = bufferedReader.readLine()) != null) {
			if(count % lines == 0) {
				bufferedReader.readLine();		
			}
			else {
				data.add(bufferedReader.readLine());
			}
			count++;
		}   
		
		bufferedReader.close();
		
		return data; 
	}
	
	public LinkedList<String> getData() {
		return data;
	}
	
	public double getCount() {
		return count;
	}
}



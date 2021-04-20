
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Algorithim_controller {

	public String path="";
	public String newfile="";
	public File file = null;
	public int lines;
	
	public Algorithim_controller(String path, String newfile, int lines) throws FileNotFoundException, IOException {
		this.path = path;
		this.lines = lines;
		this.file = new File(path);
		this.newfile = newfile;
	}
	
	public void run() throws FileNotFoundException, IOException,OutOfMemoryError {
		text_file_reader reader = new text_file_reader(file);
		LinkedList<String> points = null;
		points = reader.read(lines);

		String [] new_path = path.split("\\\\");
		String new_file ="";

		for(int i=0; i < new_path.length-1; i++) {
			new_file = new_file + new_path[i] + "\\";
		}

		new_file= new_file + "\\"+ newfile+".pts";
		file = new File(new_file);
		
		text_file_writer writer = new text_file_writer(file);
		writer.write(points);
	}
}

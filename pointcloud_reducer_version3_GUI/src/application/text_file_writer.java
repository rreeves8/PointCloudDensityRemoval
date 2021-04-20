package application;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class text_file_writer {	
	
	private BufferedWriter bw = null;
	private FileWriter fw = null;
	
	public text_file_writer(File file) { 	
		try {
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);	
		}	
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	public void write_from_bottom(LinkedList<String> points,double count){
		Iterator<String> itr = points.iterator();
		
		try {
			
			for(int i = 0; i<=count;i++) {
				bw.newLine();
			}
			while(itr.hasNext()) {
				bw.write(itr.next());
				bw.newLine();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		close();
	}
	
	public void write(LinkedList<String> points){
		Iterator<String> itr = points.iterator();
		try {
			while(itr.hasNext()) {
				bw.write(itr.next());
				bw.newLine();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		close();
	}
		
	private void close() {
		try{
			if(bw!=null)
				bw.close();
		}
		catch(Exception ex){
			System.out.println("Error in closing the BufferedWriter"+ex);
		}
	}
}
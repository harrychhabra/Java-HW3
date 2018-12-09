// import required packages 
import java.io.*; 
public class readFile {

	// objects for handling file buffers and stream
	File file = null;
	FileInputStream fileStream=null;
	InputStreamReader fileRead = null;
	BufferedReader readBuffer = null;
	
	// open the fileName file
	// returns the BufferedReader object for the fileName
	public BufferedReader openFile(String fileName) {
		file = new File(fileName);
		try {
			fileStream = new FileInputStream(file);
			fileRead = new InputStreamReader(fileStream);
			readBuffer = new BufferedReader(fileRead);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return readBuffer;
	}

	// to close the I/O objects
	public void closeFile() {
		try {
			readBuffer.close();
			fileRead.close();
			fileStream.close();
		}
		catch(IOException e) {
			e.printStackTrace();
			System.exit(-1);
	    }
	}

	// To reset the position to first line
	public void resetPosition() {
		try {
			// updaeting FileInputStream object
			fileStream.getChannel().position(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot reset position");
		}
		return;
	}
}

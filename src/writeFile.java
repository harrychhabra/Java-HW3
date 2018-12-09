import java.io.*;
public class writeFile {

	// objects for output handling
	File file=null;
	FileOutputStream outputStream=null;
	OutputStreamWriter outputWrite=null;
	BufferedWriter bufferWrite =null;

	// open name file to write
	public void openFile(String name) {
		file = new File(name);
		try {
			outputStream = new FileOutputStream(file);
			outputWrite = new OutputStreamWriter(outputStream);
			bufferWrite = new BufferedWriter(outputWrite);
		}
		catch(IOException e) {
			System.exit(-1);
		}
	}

	// closes output buffers
	public void closeFile()
	{
		try {
			bufferWrite.close();
			outputWrite.close();
			outputStream.close();
		}
		catch(IOException e) {
			System.exit(-1);
		}
	}

	// write the string to file
	public void writeToFile(String st)
	{
		try {
			bufferWrite.write(st);
		}
		catch(IOException e) {
			System.exit(-1);
		}
				
	}

	// inserts a new line
	public void newLine()
	{
		try {
			bufferWrite.newLine();
		}
		catch(IOException e) {
			System.exit(-1);
		}
				
	}
}

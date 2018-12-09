import java.io.*;
public class MAIN {
	public static void main(String []args) {

		// Read unSorted_keywords.txt
		readFile bufferRead = new readFile(); // object for reading a file
		BufferedReader buffer = null; 
		buffer =bufferRead.openFile("HW3-unsorted-keywords.txt");
		
		// count the number of words
		int cnt = 0;
		String st;
		
		// increment till buffer is not null
		try {
			while((st=buffer.readLine()) != null) {
				cnt ++;
			}
		}
		catch(IOException e) {
			System.out.println("Error reading the keyword file");
		}
		
		// Make a string dynamically
		String keywords[] = new String[cnt];
		
		// reset buffer position to start
		bufferRead.resetPosition();
		
		// store into the array
		// by reading the keywords again
		for(int i=0;i<cnt;i++)
		{
			try {
				keywords[i] = buffer.readLine();
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
		
		// closing the keywords file
		bufferRead.closeFile();
		
		// sort the keyword arrays
		SortingString sortObj = new SortingString();
		sortObj.sort(keywords);
		
		// opening the input-code.cpp file
		buffer = bufferRead.openFile("HW3-input-code.cpp");
		
		// ProcessString class will process each line
		// to determine the present keywords
		ProcessString obj = new ProcessString();
		
		// method present in ProcessString to
		// open and write into the output file
		obj.openFile("Output.txt");
		
		// copying the sorted keyword array
		obj.copyKeyword(keywords);
		
		// counter for line number being processed
		int lineNum = 1;
		
		try {
			while((st = buffer.readLine()) != null) {
				obj.Process(st, lineNum);
				lineNum++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// update the summary of the program
		obj.updateFooter();
		
		// closing file
		obj.closeFile();
		
		System.out.println("Completed");
	}
}

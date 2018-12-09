
public class ProcessString {
	// opening file for writing
	writeFile obj = null;
	// String array to replicate the keywords array
	String keywords[] = null;
	// count to no of keywords found
	int cnt = 0;

	// opens the file to write
	public void openFile(String s) {
		// Make object of writeFIle class
		obj = new writeFile();
		obj.openFile(s);
	}

	// to close the opened bufferes
	public void closeFile() {
		obj.closeFile();
		obj = null;
	}

	// to replicate the string keywords
	// to compensate for search
	public void copyKeyword(String keyword[]) {
		keywords = keyword;
	}

	// binary search for checking presence of keyword
	private int is_present(String st)
	{
		if(st == "") return -1;
		int low = 0;
		int high = keywords.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(compare(keywords[mid],st)== 0) {
				return mid;
			}
			else
				if(compare(keywords[mid],st) == -1)
					high = mid-1;
				else
					low = mid+1;
		}
		return -1;
	}

	// Processes the line for the keywords
	public void Process(String st,int lineNum) {
		if(st == "") return;

		st = st + " ";
		// auxillary variable
		String temp="";
		// lineFlag will write the line number
		// if keyword is found
		int lineFlag=0,i;

		for(i=0; i<st.length();i++)
		{
			char a = st.charAt(i);
			// Handles comment
			if( a == '/')
			{
				if(i == 0)
				continue;
				if(st.charAt(i-1) == '/')
				{
					// it is a comment
					// ignore rest
					temp="";
					break;
				}
			}
			// append in allowed charcter set case
			if( (a >= 'a' && a <= 'z') || a == '_' || (a >= '0' && a <= '9'))
			{
				temp = temp + a;
				
			}
			else
			{
				if(is_present(temp) != -1)
				{
					if(lineFlag == 0)
					{
						lineFlag = 1;
						// Write Line number
						obj.writeToFile("Line "+lineNum+": ");
					}

					obj.writeToFile(temp+"("+(i-temp.length())+") ");
					cnt++;
				}
				// After writing, making variable free for next keyword 
				temp="";
			}
		}

		if(lineFlag == 1) {
			// to handle the keyword at last of line
			if(is_present(temp) != -1) {
				obj.writeToFile(temp+"("+(i-temp.length())+") ");
				cnt++;
			}
			// point buffer to next line
			obj.newLine();
		}
	}

	// user defined function to compare two strings
	private int compare(String s1,String s2) {
		// 0 if s1 == s2
		// 1 if s1 < s2
		// -1 if s1 > s2
		int n1 = s1.length();
		int n2 = s2.length();
		int i;
		for(i=0; i < n1 && i < n2; i++) {
			if(s1.charAt(i) > s2.charAt(i) )
				return -1;
			else
				if(s1.charAt(i) < s2.charAt(i))
					return 1;
		}
		if( i < n2)
			return 1;
		if(i < n1) return -1;
		return 0;
	}

	// To update keywords count
	public void updateFooter() {
		obj.writeToFile("Number of keywords: "+cnt);
		System.out.println("Number of keywords: "+cnt);
	}
}

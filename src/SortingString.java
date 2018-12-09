
public class SortingString {

	// 0 if s1 == s2
	// 1 if s1 < s2
	// -1 if s1 > s2
	private int compare(String s1,String s2) {
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

	// bubble sort
	// sorted output
	public void sort(String []s) {
		String st;
		int n = s.length;
		for(int i=0 ;i < n; i++)
		{
			for(int j= i+1;j < n; j++) {
				int cmp = compare(s[i],s[j]);
				if(cmp == -1)
				{
					st = s[i];
					s[i] = s[j];
					s[j] = st;
				}
			}
		}
	}
	
}

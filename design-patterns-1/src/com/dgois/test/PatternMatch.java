package com.dgois.test;

public class PatternMatch {
	
	public static void main(String[] args) {
		String p = "abc";
		String t = "defghijjjj";
		
		int i, j, m, n;
		
		m = p.length();
		n = t.length();
		
		for (i=0; i<=(n-m); i++) {
			j=0;
			while ((j<m) && (t.charAt(i+j)==p.charAt(j))) {
				j = j+1;
			}
			if (j == m) System.out.println(i);
		}
	}

}

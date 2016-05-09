package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Stdio {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		
		while((s=stdin.readLine()) != null && s.length() != 0){
			
			System.out.println(s);
		}
		
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("hello world");
	}
}

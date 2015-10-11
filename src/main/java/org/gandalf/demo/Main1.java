package org.gandalf.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main1 implements Runnable {
	
	private String line;
	
	private int index;
	
	public static Map<Integer,String> result = Collections.synchronizedMap(new HashMap<Integer, String>());
	
	public Main1(String line, int index){
		
		this.line = line;
		this.index = index;
	}
	
	public void run() {
		
		String[] a = line.split(" ");

		Map<String, Integer> map = new LinkedHashMap<String, Integer>();

		for (int i = 0; i < a.length; i++) {

			if (map.get(a[i]) == null || map.get(a[i]) != -1) {
				map.put(a[i], map.get(a[i]) == null ? i : -1);
			}
		}

		for (String one : map.keySet()) {

			int c = map.get(one);

			if (c != -1) {

				result.put(index, one);
				
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

		String line = null;
		
		int index = 0;

		while ((line = s.readLine()) != null) {
			
			Thread t = new Thread(new Main1(line, index++));
			t.start();
		}
		
		while(true){
			
			if(result.containsKey(index-1)){
				
				for(int i = 0; i< index; i++){
					
					System.out.println(result.get(i));
				}
				
				break;
			}
		}
	}
}
package org.gandalf.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main implements Runnable{
	
	public static String[] arr;
	
	public static Map<String, Integer> map = new HashMap<String, Integer>();
	
	public static int cnt = 0;
	
	private static int l = 0;
	
	private int start;
	
	private int end;
	
	private int flag;
	
	public Main(int start, int end, int flag){
		
		this.start = start;
		this.end = end;
		this.flag = flag;
	}
	
	public void run() {
		
		if(flag == 0){
			
			for(; start < end; start++){
				
				put(arr[start], start + 1);
			}
		}else{
			
			while (true) {
				
				System.out.println(cnt);
				
				if (l == cnt) {
					
					for (int i = 0; i < l; i++) {

						if (map.get(arr[i]) != 0) {

							System.out.println(arr[i]);
							break;
						}
					}
					break;
				}
			}
		}
	}
	
	public static synchronized void put(String key, int val){
		
		cnt++;
		
		Integer value = map.get(key);
		
		if(value != null){
			
			val = 0;
		}
		
		map.put(key, val);
	}
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder bui = new StringBuilder();
		
		bui.append("G K F O Q");
		
		for(int i = 0;i< 90000; i++){
			
			bui.append(" A D B M L");
		}
		
		bui.append(" G K 8 S Q");
		
		arr = bui.toString().split(" ");
		
		l = arr.length;
    	
		new Thread(new Main(0, l / 2, 0)).start();
		new Thread(new Main(l / 2, l, 0)).start();
		new Thread(new Main(0, 0, 1)).start();
	}
}
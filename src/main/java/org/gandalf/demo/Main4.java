

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main implements Runnable {
	
	private String line;
	
	private int index;
	
	public static Map<Integer,String> result = Collections.synchronizedMap(new HashMap<Integer, String>());
	
	public Main(String line, int index){
		
		this.line = line + " ";
		this.index = index;
	}
	
	public void run() {
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		for (int i = 0,p = 0; ; i = p+1) {
			
			p = line.indexOf(" ", i);
			
			if(line.length() > i){
				
				String text = line.substring(i, p);
				
				if (map.get(text) == null || map.get(text) != -1) {
					map.put(text, map.get(text) == null ? i : -1);
				}
				
			}else{
				
				break;
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
			
			Thread t = new Thread(new Main(line, index++));
			t.start();
		}
		
		Thread.yield();
		
		while(true){
			
			if(result.keySet().size() == index){
				
				for(int i = 0; i< index; i++){
					
					System.out.println(result.get(i));
				}
				
				break;
			}
		}
	}
}

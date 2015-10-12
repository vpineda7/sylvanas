import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main5 implements Runnable {
	
	private String line;
	
	private int index;
	
	public static Map<Integer,String> result = Collections.synchronizedMap(new HashMap<Integer, String>());
	
	public Main5(String line, int index){
		
		this.line = line;
		this.index = index;
	}
	
	public void run() {
		
		Date s1 = new Date();
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		for (int i = 0,p = 0; ; i = p+1) {
			
			p = line.indexOf(" ", i);
			
			if(line.length() > i){
				
				String text = line.substring(i, p);
				Integer value = map.get("text");
				
				if (value == null) {
					map.put(text, 0);
				} else if(value != -1){
					map.put(text, -1);
				}
				
			}else{
				
				break;
			}
		}
		
		Date s2 = new Date();
		
		System.out.println(index +":"+ (s2.getTime() - s1.getTime()));

		for (String one : map.keySet()) {

			int c = map.get(one);

			if (c != -1) {

				result.put(index, one);
				
				break;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		Date s = new Date();

		String line = null;
		
		StringBuilder builder = new StringBuilder();
		
		for(int i=0;i<8000000;i++){
			
			builder.append((int)(Math.random() * 100000)+" ");
		}
		
		int index = 0;
		
		line = builder.toString();
		
		Date e1 = new Date();
		
		System.out.println(e1.getTime() - s.getTime());
		
		//while ((line = s.readLine()) != null) {
		while (true) {
			
			Thread t = new Thread(new Main5(line, index++));
			t.start();
			
			if(index == 1){
				break;
			}
		}
		
		Thread.yield();
		
		while(true){
			
			if(result.keySet().size() == index){
				
				for(int i = 0; i< index; i++){
					
					System.out.println(result.get(i));
				}
				
				Date e = new Date();
				
				System.out.println(result.toString() +" : "+ (e.getTime() - s.getTime()));
				
				break;
			}
		}
	}
}

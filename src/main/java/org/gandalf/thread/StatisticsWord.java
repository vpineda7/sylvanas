package org.gandalf.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

public class StatisticsWord implements Callable<Map<String, Integer>>{
	
	private String line;
	
	public StatisticsWord(String line){
		
		this.line = line;
	}

	public Map<String, Integer> call() throws Exception {
		
		StringTokenizer st = new StringTokenizer(line);
		
		Map<String, Integer> statMap = new HashMap<String, Integer>();
		
		while(st.hasMoreTokens()){
			
			String word = st.nextToken();
			
			Integer repeatNum = statMap.get(word);
			
			statMap.put(word,  repeatNum== null ? 1 : repeatNum + 1);
		}
		
		return statMap;
	}
}
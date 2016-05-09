package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.regex.Pattern;


public class DirList {
	
	public static void main(String[] args) {
		
		String regex = "";
		String filePath = ".";
		
		File path = new File(filePath);
		
		String[] list = path.list(new FilenameFilter(){

			private Pattern pattern = Pattern.compile(regex);
			
			public boolean accept(File dir, String name) {
				
				return pattern.matcher(name).matches();
			}
			
		});
		
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		
		for(String dirItem: list){
			
			System.out.println(dirItem);
		}
	}
}

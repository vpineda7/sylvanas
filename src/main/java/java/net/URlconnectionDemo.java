package java.net;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URlconnectionDemo {
	
	public static void main(String[] args) throws Exception {
		
		String url = "http://www.mzitu.com/share/comment-page-";
        String out = "E:/Downloads/New folder/";
        int page = 41;
        
        Pattern reg = Pattern.compile("<img src=\"(.*?)\"");
        
        for(int i=1; i <= page; i++){
        	
            @SuppressWarnings("resource")
			Matcher m = reg.matcher(new Scanner(new URL(url+i).openStream()).useDelimiter("\\A").next());
            
            while(m.find()){
            	
                Files.copy(new URL(m.group(1)).openStream(), Paths.get(out + UUID.randomUUID() + ".jpg"));
            }
        }
    }
}

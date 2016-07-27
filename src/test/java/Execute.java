

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Execute {
	
	public static void command(String command) throws IOException{
		
		Process process = new ProcessBuilder(command.split(" ")).start();
		
		// 标准输出
		BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		String s;
		
		while((s=results.readLine()) != null){
			
			System.out.println(s);
		}
		
		// 标准错误
		BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		
		while((s=errors.readLine()) != null){
			
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		Execute.command("ls -al");
	}
}
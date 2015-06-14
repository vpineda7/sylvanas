package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SimpleFile {
	
	/**
	 * 创建文件
	 * 
	 */
	public boolean createFile(String path) throws Exception{
		
		//new FileDemo().createFile("E:\\Project\\Winter\\Java\\dafd\\create.txt");
		
		//跨平台 File.separator //正则表达式
		//path = path.replaceAll("//", File.separator);
		
		File file = new File(path);
		
		//判断目录是否存在
		
		return file.createNewFile();
	}
	
	public void inputStream() throws Exception{
		
		//输入流
		InputStream is = System.in;
		
		//读取
		InputStreamReader reader = new InputStreamReader(is);
		
		reader.read();
	}
	
	/**
	 * 输出文本文件 out put 
	 * 
	 */
	public void writerTextFile() throws Exception{
		
		String file = "E:\\Project\\Winter\\Java\\fileoutput.txt";
		
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		PrintWriter out = new PrintWriter(file);
		
		out.println("hello buffered writer!");
		out.println("hello buffered writer!");
		out.println("hello buffered writer!");
		
		out.close();
	}
	
	
	/**
	 * 输入文本文件 in put
	 * 
	 */
	public String readTextFile(String fileName) throws Exception{
		
		//new FileDemo().readTextFile("E:\\Project\\Winter\\Java\\HelloWorld.java");
		
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		
		StringBuilder builder = new StringBuilder();
		
		String str = "";
		
		while((str = in.readLine()) != null){
			
			builder.append(str + "\n");
		}
		
		in.close();
		
		return builder.toString();
	}
	
	/**
	 * 递归循环目录结构
	 * 
	 */
	public void directoryStructure(File file, String space) throws Exception {
		
		/*FileDemo demo = new FileDemo();
		
		File file = new File(path);
		
		demo.fileEach(file, "");*/
		
		if(file.exists()){
			
			if(file.isDirectory()){
				
				System.out.println(space+"Folder: "+file.getAbsolutePath());
				
				File[] next = file.listFiles();
				
				StringBuffer buffer = new StringBuffer();
				buffer.append("    ").append(space);
				
				if(next != null){
					
					for(File one : next ){
						
						this.directoryStructure(one, buffer.toString());
					}
				}
				
			} else {
				
				System.out.println(space+"File: "+file.getAbsolutePath());
			}
			
		} else {
			
			System.out.println("File is not exists!");
		}
	}
}

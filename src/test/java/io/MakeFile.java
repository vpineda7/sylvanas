package io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PushbackInputStream;
import java.io.Serializable;

public class MakeFile implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public MakeFile(String name){
		this.name = name;
	}
	
	// 自定义输出对象
	private String name;
	
	public String toString(){
		
		return this.name;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// 创建文件
		String filePath = "."+File.separator+"test.txt";
		
		File file = new File(filePath);
		
		file.createNewFile();
		
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		System.out.println(file.getName());
		
		// 读取文件字节大小
		int byteCount = 0;
		
		InputStream input = new FileInputStream(filePath);
		
		// 复制文件
		byte[] buffer = new byte[512];
		int number = 0;
		
		FileOutputStream out = new FileOutputStream("."+File.separator+"test1.txt");
		
		while((number = input.read(buffer)) != -1){
			
			byteCount += number;
			
			out.write(buffer, 0, number);
		}
		
		System.out.println(byteCount);
		
		input.close();
		out.close();
		
		// 输出对象信息
		ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(filePath));
		
		obj.writeObject(new MakeFile("hello"));
		obj.writeObject(new MakeFile("world"));
		
		obj.close();
		
		ObjectInputStream objin = new ObjectInputStream(new FileInputStream(filePath));
		
		MakeFile a = (MakeFile) objin.readObject();
		
		System.out.println(a.name);
		System.out.println(objin.readObject());
		
		objin.close();
		
		// 回退读取
		String str = "hello , world";
		
		PushbackInputStream push = new PushbackInputStream(new ByteArrayInputStream(str.getBytes()));
		
		int temp = 0;
		
		while((temp = push.read()) != -1){
			
			if(temp == ','){
				push.unread(temp);
				
				temp = push.read();
				
				System.out.println("回退" +(char)temp);
			}else{
				
				System.out.println((char)temp);
			}
		}
	}
}

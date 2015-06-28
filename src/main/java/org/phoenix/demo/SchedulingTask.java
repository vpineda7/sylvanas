package org.phoenix.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Spring Projects Demo
 * 
 * @author subin
 * @version 1.0
 */
//@Component
//@Configuration
public class SchedulingTask {
	
	/**
	 * Scheduling Tasks
	 * 
	 * <p>This demo walks you through the steps for scheduling tasks with Spring.
	 * 
	 */
	@Scheduled(fixedRate = 5000)
    public void schedulingTasks() throws Exception {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
	
	/**
	 * Uploading Files
	 * 
	 * <p>This demo walks you through the process of creating a server application that can receive multi-part file uploads.
	 * 
	 */
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String handleFileUpload(@RequestParam("name") String name,@RequestParam("file") MultipartFile file){
       
		if (!file.isEmpty()) {
        	
            try {
                byte[] bytes = file.getBytes();
                
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
                
                stream.write(bytes);
                stream.close();
               
                return "You successfully uploaded " + name + "!";
                
            } catch (Exception e) {
            	
                return "You failed to upload " + name + " => " + e.getMessage();
            }
            
        } else {
        	
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
}

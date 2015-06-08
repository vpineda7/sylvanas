package demo.spring;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.mobile.device.Device;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.summer.user.bean.User;

/**
 * Spring Projects Demo
 * 
 * @author subin
 * @version 1.0
 */
//@Component
//@Configuration
public class SimpleSchedulingTask {
	
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
	 * Consuming a RESTful Web Service
	 * 
	 * <p>This demo walks you through the process of creating an application that consumes a RESTful web service.
	 * 
	 */
	public void restTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		User user = restTemplate.getForObject("http://localhost/summer/user/1", User.class);
		
		System.out.println(user.getId());
	}
	
	/**
	 * Detecting a Device
	 * 
	 * <p>This demo walks you through the process of using Spring to detect the type of device that is accessing your web site.
	 * 
	 */
	@RequestMapping("/detect-device")
    public String detectDevice(Device device) {
    	
        String deviceType = "unknown";
        
        if (device.isNormal()) {
        	
            deviceType = "normal";
            
        } else if (device.isMobile()) {
        	
            deviceType = "mobile";
            
        } else if (device.isTablet()) {
        	
            deviceType = "tablet";
        }
        
        return "Hello " + deviceType + " browser!";
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

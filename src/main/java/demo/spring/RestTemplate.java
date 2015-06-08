package demo.spring;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.mobile.device.Device;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
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
@Component
public class RestTemplate {
	
	/**
	 * Consuming a RESTful Web Service
	 * 
	 * <p>This demo walks you through the process of creating an application that consumes a RESTful web service.
	 * 
	 */
	public void restTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		User user = restTemplate.getForObject("http://localhost/summer/user/1", User.class);
		
	}
}

package demo.spring;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Spring Projects Demo
 * 
 * @author subin
 * @version 1.0
 */
@Component
public class SimpleRestTemplate {
	
	/**
	 * Consuming a RESTful Web Service
	 * 
	 * <p>This demo walks you through the process of creating an application that consumes a RESTful web service.
	 * 
	 */
	public void restTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		User user = restTemplate.getForObject("http://localhost/summer/user/1", User.class);
		
		System.out.println(user);
	}
}

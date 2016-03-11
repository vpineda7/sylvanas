package org.gandalf.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Spring Projects Demo
 * 
 * @author subin
 * @version 1.0
 */
//@Controller
public class SpringMVC {
	
	@RequestMapping(value="/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		
        model.addAttribute("name", name);
        
        //指向greeting.html thymeleaf模板
        
        return "greeting";
    }
}

package org.phoenix.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Java反射示例
 * 
 */
public class SimpleReflect {
	
	public static void main(String[] args) throws Exception {
		
		/**
		 * 使用ArrayList作为示例
		 * 
		 */
		
		//Get Class
		Class<?> rclass = new ArrayList<>().getClass();
		rclass = Class.forName("java.util.ArrayList");
		rclass = java.util.ArrayList.class;

		//Instance Class
		List<?> list = new ArrayList<>();
		list = (List<?>) rclass.newInstance();
		
		//Get Package Name
		System.out.println("Package : "+list.getClass().getPackage().getName());
		
		//Get Class Name
		System.out.println("Class : "+list.getClass().getName());
		
		//Get Field Name
		Field[] field = rclass.getDeclaredFields();
		
		System.out.println("-------------------- Get Field --------------------");
		for(Field result : field){
			
			System.out.println(result);
		}
		
		//Get Method Name
		Method[] method = rclass.getDeclaredMethods();
		
		System.out.println("-------------------- Get Method --------------------");
		for(Method result: method){
			
			System.out.println(result);
		}
		
		//Get Constructor Name
		Constructor<?>[] constructors = rclass.getConstructors();
		
		System.out.println("-------------------- Get Constructor --------------------");
		for(Constructor<?> result : constructors){
			
			System.out.println(result);
			
			//Use Constructor Instance Class
			/*if(result.getParameterCount() == 0){
				
				list = (List<?>) result.newInstance();
			}*/
		}
		
		Class<?> interfaces[] = rclass.getInterfaces();
		
		System.out.println("-------------------- Get Interfaces --------------------");
		for(Class<?> result: interfaces){
			
			System.out.println(result);
		}
		
		System.out.println("-------------------- Get Superclass --------------------");
		System.out.println("Superclass :"+rclass.getSuperclass().getName());
		
		Annotation[] annotation = rclass.getAnnotations();
		
		System.out.println("-------------------- Get Annotation --------------------");
		for(Annotation result: annotation){
			
			System.out.println(result);
		}
		
		System.out.println("-------------------- Set Field --------------------");
		Field sizeField = rclass.getDeclaredField("size");
		//sizeField.set(list, "10");
		System.out.println(sizeField);
		
		System.out.println("-------------------- Call Method --------------------");
		Method sizeMethod = rclass.getMethod("add", Object.class);
		sizeMethod.invoke(list,"10");
		System.out.println(list.get(0));
	}
}

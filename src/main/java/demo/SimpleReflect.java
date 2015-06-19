package demo;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * java 反射机制
 * 
 * 说白了就是java创建了一组可以动态的操作类的类
 * 
 */
public class SimpleReflect implements Filter{
	
	private long id;
	
	private String name;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		
		System.out.println(name);
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws Exception {
		
		/**one*/
		SimpleReflect reflect = new SimpleReflect();
		
		System.out.println(reflect.getClass().getPackage().getName());
		System.out.println(reflect.getClass().getName());
		System.out.println(reflect.getClass().getPackage().getName());
		
		//two
		Class<?> class1 = new SimpleReflect().getClass();
		//使用ClassName获取Class
		Class<?> class2 = Class.forName("demo.SimpleReflect");
		Class<?> class3 = SimpleReflect.class;
		
		System.out.println(class1);
		System.out.println(class2);
		System.out.println(class3);
		
		//three
		//实例化Class
		SimpleReflect reflect1 = (SimpleReflect)class1.newInstance();
		System.out.println(reflect1);
		
		//four
		Constructor<?>[] constructors = class1.getConstructors();
		//使用构造函数创建对象
		reflect1 = (SimpleReflect)constructors[0].newInstance();
		
		//five
		Field field = class1.getDeclaredField("name");
		
		Object obj = class1.newInstance();
		field.set(obj, "hello");
		
		System.out.println(field.get(obj));
		
		//six
		System.out.println(class1.getSuperclass().getName());
		
		Field[] cl = class1.getDeclaredFields();
		
		for(Field one: cl){
			
			System.out.println(one);
		}
		
		Method[] method = class1.getDeclaredMethods();
		
		for(Method one: method){
			
			System.out.println(one);
		}
		
		Class<?> interfaces[] = class1.getInterfaces();
		
		for(Class<?> one: interfaces){
			
			System.out.println(one);
		}
		
		//seven
		Method method1 = class1.getMethod("getName");
		//你不知道方法名 调用反转
		method1.invoke(obj);
		
		//eight
		System.out.println(class1.getClassLoader().getClass().getName());
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}

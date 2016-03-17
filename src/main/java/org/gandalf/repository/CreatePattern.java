package org.gandalf.repository;

public class CreatePattern {
	
	/**
	 * 工厂模式
	 * 
	 * 制造工厂
	 */
	class FactoryPattern{
		
	}
	
	/**
	 * 抽象工厂模式
	 * 
	 * 分工厂
	 */
	class AbstractFactoryPattern{
		
	}
	
	/**
	 * 单例模式
	 * 
	 * 电话号码，邮箱
	 */
	static class SingletonPattern{
		
		private static class SingletonHolder {
			
			private static final SingletonPattern INSTANCE = new SingletonPattern();  
	    }
		
	    private SingletonPattern (){}
	    
	    public static final SingletonPattern getInstance() {  
	    	
	    	return SingletonHolder.INSTANCE;
	    }  
	}
	
	/**
	 * 建造者模式
	 * 
	 * 
	 */
	class BuilderPattern{
		
	}
	
	/**
	 * 原型模式
	 * 
	 * 
	 */
	class PrototypePattern{
		
	}
}
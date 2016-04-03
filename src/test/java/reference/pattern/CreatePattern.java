package reference.pattern;

/**
 * 设计模式
 * 
 * 设计模式如同太极拳，只重其意不重其招。
 */
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
	 * 保证一个类只有一个实例并且这个实例易于被访问
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
	 * KFC套餐
	 */
	class BuilderPattern{
		
	}
	
	/**
	 * 原型模式
	 * 
	 */
	class PrototypePattern{
		
		
	}
}
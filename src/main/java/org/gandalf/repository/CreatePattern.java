package org.gandalf.repository;

/**
 * 以创建汽车为例
 */
public class CreatePattern {
	
	/**
	 * 工厂模式
	 * 
	 * 实例: 1、您需要一辆汽车，可以直接从工厂里面提货，而不用去管这辆汽车是怎么做出来的，以及这个汽车里面的具体实现。 
	 * 		2、Hibernate 换数据库只需换方言和驱动就可以
	 * 缺点: 每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加
	 * 		在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。
	 */
	class FactoryPattern{
		
		public PorscheCar getCar(String type){
			
			PorscheCar car = null;
			
			if(type != null && type.equals("")){
				
				switch(type.toLowerCase()){
				
					case "boxster" : car = new Boxster(); break;
					case "cayman" : car = new Cayman(); break;
					case "panamera" : car = new Panamera(); break;
				}
			}
			
			return car;
		}
	}
	
	/**
	 * 抽象工厂模式
	 * 
	 * 实例: 
	 * 缺点: 
	 */
	class AbstractFactoryPattern{
		
	}
	
	/**
	 * 单例模式
	 * 
	 * 实例: 1、一个党只能有一个主席。 
	 * 		2、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。 
	 * 		3、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印机打印同一个文件。
	 * 缺点: 没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
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
	 * 意图: 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
	 * 实例: 1、去肯德基，汉堡、可乐、薯条、炸鸡翅等是不变的，而其组合是经常变化的，生成出所谓的"套餐"。
	 * 		2、JAVA 中的 StringBuilder
	 * 缺点: 1、产品必须有共同点，范围有限制。 
	 * 		2、如内部变化复杂，会有很多的建造类。
	 */
	class BuilderPattern{
		
		//汉堡包
		
		//可乐
		
		//薯条
		
		//套餐1: 汉堡包 可乐
		
		//套餐2: 汉堡包 可乐 薯条
	}
	
	/**
	 * 原型模式
	 * 
	 */
}

/**
 * 定义汽车接口
 * 发动机 车身 底盘 轮胎
 */
interface PorscheCar{
	
	void engine();
	
	void body();
	
	void chassis();
	
	void tyre();
}

/**
 * 实际车型对象
 * Boxster
 */
class Boxster implements PorscheCar{
	
	public void engine() {
		
	}
	
	public void body() {
		
	}
	
	public void chassis() {
		
	}

	public void tyre() {
		
	}
}

/**
 * 实际车型对象
 * Cayman
 */
class Cayman implements PorscheCar{
	
	public void engine() {
		
	}
	
	public void body() {
		
	}
	
	public void chassis() {
		
	}

	public void tyre() {
		
	}
}

/**
 * 实际车型对象
 * Panamera
 */
class Panamera implements PorscheCar{

	public void engine() {
		
	}
	
	public void body() {
		
	}
	
	public void chassis() {
		
	}

	public void tyre() {
		
	}
}
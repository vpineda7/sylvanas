package reference.string;

/**
 * 
 */

public class Demo {
	
	public static void main(String[] args) {
		
		String str = " Hello World ! ";
		
		System.out.println(str.length());
		
		try{
			
			System.out.println(str.charAt(90));
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		System.out.println(str.trim());
		
		System.out.println(str.concat(" hi "));
	}
}

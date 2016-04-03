package example;

public enum SimpleEnumeration {
	
	RED(1), ORANGE(2);
	
	private int index;
	
	SimpleEnumeration(int idx){
		
		this.index = idx;
	}
	
	public int getIndex(){
		
		return index;
	}
}



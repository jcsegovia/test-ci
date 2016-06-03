package machine.types;

public class Discount {
	private int numItems;
	private int discountValue;
	private int counter;
	
	public Discount(){
		
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	public int getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}
	
	public void updateCounter(){
		counter++;
	}
	
	public boolean shouldApplyDiscount(){
		if(counter == numItems){
			counter = 0;
			return true;
		}else{
			return false;
		}
	}
	
}

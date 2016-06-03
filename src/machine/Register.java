package machine;

import java.util.List;
import java.util.Map;

import machine.types.Discount;
import machine.types.ProductType;
import machine.types.Type;

public class Register implements IRegister {
	
	private Map<Type, ProductType> products;
	private int total;
	
	public Register(){
	}
	
	//Apples 100
	//Cherries 175
	//Cherries 230
	
	public String process(String msg){
		Type t = getType(msg);
		if(t != null){
			ProductType pt = products.get(t);
			Discount d = pt.getDiscount();
			total += pt.getValue();
			if(d != null){
				d.updateDiscount();
				total -= d.getDiscountValue();
			}
		}
		return msg + ": " + total;
	}
	
	private Type getType(String msg){
		for(Type t: Type.values()){
			if(msg.equalsIgnoreCase(t.name())){
				return t;
			}
		}
		return null;
	}

	@Override
	public void setProducts(Map<Type,ProductType> products) {
		this.products = products;
	}

	@Override
	public int getNumProducts() {
		if(products == null){
			return 0;
		} else {
			return products.size();
		}
	}

	@Override
	public int getTotal() {
		return total;
	}
	
}

package machine;

import java.util.List;

import machine.types.ProductType;

public class Register implements IRegister {
	
	private List<ProductType> products;
	
	public Register(){
	}
	
	public String process(String msg){
		return msg;
	}

	@Override
	public void setProducts(List<ProductType> products) {
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
	
}

package machine;

import java.util.Map;

import machine.types.ProductType;
import machine.types.Type;

public class DummyRegister implements IRegister {

	@Override
	public void setProducts(Map<Type, ProductType> products) {
	}

	@Override
	public int getNumProducts() {
		return 0;
	}

	@Override
	public String process(String msg) {
		return msg;
	}

	@Override
	public int getTotal() {
		return 0;
	}

}

package machine;

import java.util.Map;

import machine.types.ProductType;
import machine.types.Type;

public interface IRegister {
	public void setProducts(Map<Type,ProductType> products);
	public int getNumProducts();
	public String process(String msg);
	public int getTotal();
}

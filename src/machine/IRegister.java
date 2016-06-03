package machine;

import java.util.List;

import machine.types.ProductType;

public interface IRegister {
	public void setProducts(List<ProductType> products);
	public int getNumProducts();
}

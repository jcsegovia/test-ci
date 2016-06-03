package machine;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import machine.types.ProductType;
import machine.types.Type;

public class RegisterTest {

	@Test
	public void testRegister1(){
		Register r = new Register();
		String out = r.process("Hola");
		Assert.assertEquals("Hola", out);
	}

	@Test
	public void testRegisterProductsWithItems(){
		Register r = new Register();
		List<ProductType> products = new ArrayList<>();
		products.add(new ProductType(Type.Apples, 100));
		products.add(new ProductType(Type.Bananas, 150));
		products.add(new ProductType(Type.Cherries, 75));
		r.setProducts(products);
		Assert.assertEquals(3, r.getNumProducts());
	}
	
	@Test
	public void testRegisterProductsEmpty(){
		Register r = new Register();
		Assert.assertEquals(0, r.getNumProducts());
	}
}

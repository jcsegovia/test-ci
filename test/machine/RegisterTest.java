package machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import machine.types.Discount;
import machine.types.ProductType;
import machine.types.Type;

public class RegisterTest {

	@Test
	public void testRegister1(){
		Register r = new Register();
		String out = r.process("Hola");
		Assert.assertEquals("Hola: 0", out);
	}

	@Test
	public void testRegisterProductsWithItems(){
		Register r = new Register();
		Map<Type,ProductType> products = new HashMap<>();
		products.put(Type.Apples, new ProductType(Type.Apples, 100));
		products.put(Type.Bananas, new ProductType(Type.Bananas, 150));
		products.put(Type.Cherries, new ProductType(Type.Cherries, 75));
		r.setProducts(products);
		Assert.assertEquals(3, r.getNumProducts());
	}
	
	@Test
	public void testRegisterProduct1(){
		Register r = new Register();
		Map<Type,ProductType> products = new HashMap<>();
		products.put(Type.Apples, new ProductType(Type.Apples, 100));
		products.put(Type.Bananas, new ProductType(Type.Bananas, 150));
		products.put(Type.Cherries, new ProductType(Type.Cherries, 75));
		r.setProducts(products);
		r.process("Apples");
		r.process("Bananas");
		r.process("Cherries");
		Assert.assertEquals(325, r.getTotal());
	}
	
	@Test
	public void testRegisterProduct2(){
		//Apples 100
		//Cherries 175
		//Cherries 230
		Register r = new Register();
		Map<Type,ProductType> products = new HashMap<>();
		products.put(Type.Apples, new ProductType(Type.Apples, 100));
		products.put(Type.Bananas, new ProductType(Type.Bananas, 150));
		ProductType cherries = new ProductType(Type.Cherries, 75);
		Discount d = new Discount();
		d.setNumItems(2);
		d.setDiscountValue(20);
		cherries.setDiscount(d);
		products.put(Type.Cherries, cherries);
		r.setProducts(products);
		r.process("Apples");
		r.process("Cherries");
		r.process("Cherries");
		Assert.assertEquals(230, r.getTotal());
	}
	
	@Test
	public void testRegisterProductsEmpty(){
		Register r = new Register();
		Assert.assertEquals(0, r.getNumProducts());
	}
}

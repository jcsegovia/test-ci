package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import machine.types.Discount;
import machine.types.ProductType;
import machine.types.Type;

public class Echo {

	private InputStream input;
	private OutputStream output;
	private IRegister register;
	
	public Echo(InputStream input, OutputStream output, IRegister register){
		this.input = input;
		this.output = output;
		this.register = register;
		
	}
	
	public void process() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String line;
			String msg;
			while ((line = br.readLine()) != null) {
				msg = register.process(line);
				println(msg);
			}

		} catch (IOException io) {
			io.printStackTrace();
		}

	}
	
	private void println(String msg) throws IOException {
		output.write(msg.getBytes());
		output.write('\n');
	}

	public static void main(String[] args){
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
		Echo e = new Echo(System.in, System.out, r);
		e.process();
	}

}

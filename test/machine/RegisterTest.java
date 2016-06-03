package machine;

import org.junit.Assert;
import org.junit.Test;

public class RegisterTest {

	@Test
	public void testRegister1(){
		Register r = new Register();
		String out = r.process("Hola");
		Assert.assertEquals("Hola", out);
	}
}

package machine;
import org.junit.Assert;
import org.junit.Test;

import machine.Echo;

public class EchoTest {
	
	@Test
	public void testReadWrite(){
		OutputStreamHandler out = new OutputStreamHandler();
		InputStreamHandler in = new InputStreamHandler();
		in.setData("Hola\n");
		Echo echo = new Echo(in, out, null);
		echo.process();
		Assert.assertEquals("Hola", out.getData());
		
	}

}

package machine;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Assert;
import org.junit.Test;

import machine.Echo;

public class EchoTest {
	
	@Test
	public void testReadWrite(){
		OutputStreamHandler out = new OutputStreamHandler();
		InputStream in = new ByteArrayInputStream("Hola".getBytes(StandardCharsets.UTF_8));
		DummyRegister dummyRegister = new DummyRegister();
		Echo echo = new Echo(in, out, dummyRegister);
		echo.process();
		Assert.assertEquals("Hola\n", out.getData());
	}

}

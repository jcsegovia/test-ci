package machine;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class InputStreamHandler extends InputStream {

	private String data;
	private int index;
	private InputStream stream;
	
	public void setData(String data){
		this.data = data;
		index = 0;
		stream = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
	}
	
	@Override
	public int read() throws IOException {
		return stream.read();
	}
	
	

}

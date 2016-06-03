package machine;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamHandler extends InputStream {

	private String data;
	private int index;
	
	public void setData(String data){
		this.data = data;
		index = 0;
	}
	
	@Override
	public int read() throws IOException {
		while (index >= data.length());
		int c = data.getBytes()[index];
		index++;
		return c;
	}
	
	

}

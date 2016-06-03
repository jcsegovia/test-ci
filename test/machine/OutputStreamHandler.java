package machine;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamHandler extends OutputStream {
	
	StringBuilder sb = new StringBuilder();
	
	public void clear(){
		sb.setLength(0);
	}
	
	public String getData(){
		return sb.toString();
	}

	@Override
	public void write(int b) throws IOException {
		sb.append(""+b);
	}

}

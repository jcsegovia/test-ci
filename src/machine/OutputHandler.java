package machine;

import java.io.IOException;
import java.io.OutputStream;

public class OutputHandler implements OutputConsole {

	public OutputStream output;
	
	public OutputHandler(OutputStream os) {
		output = os;
	}
	
	
	@Override
	public void println(String msg) throws IOException {
		output.write(msg.getBytes());
		output.write('\n');
	}

}

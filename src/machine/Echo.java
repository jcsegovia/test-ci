package machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

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


}

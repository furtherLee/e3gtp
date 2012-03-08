package e3gtp.connection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import e3gtp.exception.ConnectionNotWorkingException;

public class Connection {

	BufferedReader in;
	
	BufferedWriter out;
	
	boolean working;
	
	public Connection(){}
	
	public void send(String str) throws IOException{
		if(!working)
			throw new ConnectionNotWorkingException();
		out.write(str);
		out.flush();
	}
	
	public String read() throws IOException{

		return in.readLine();
	}
	
	public void abort(){
		working = false;
		this.in = null;
		this.out = null;
	}
	
	public void stop(){
		working = false;
	}
	
	public void start(){
		working = true;
	}
	
	public boolean getWorking(){
		return working;
	}
	
	public void setUp(InputStream in, OutputStream out){
		this.in = new BufferedReader(new InputStreamReader(in));
		this.out = new BufferedWriter(new OutputStreamWriter(out));
		working = true;
	}
	
	
}

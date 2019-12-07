package com.lynda;

import java.io.File;
import java.io.IOException;

public class SchubsArc
{
    public static void main(String[] args) throws IOException {
	File in1 = null;
	BinaryIn bin1 = null;
	BinaryOut out = null;
	
	char separator =  (char) 255;  	
	
	try {
		
		for (int i = 1; i < args.length; i++){
		
			in1 = new File(args[i]);
			if (!in1.exists() || !in1.isFile()) return;

			long filesize = in1.length();
			int filenamesize = args[i].length();

			if( out == null){
				out = new BinaryOut(args[0] + ".zh");
			}
			
			out.write(filenamesize);
			out.write(separator);

			out.write(args[i]);
			out.write(separator);
			
			out.write(filesize);
			out.write(separator);
	
			bin1 = new BinaryIn(args[i]);

			while (!bin1.isEmpty())
				out.write(bin1.readChar());
		
			schubsH.compress();
		}

	} finally {
	    if (out != null)
		    out.close();
		}
	}
	
	

}

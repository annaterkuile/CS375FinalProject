import java.io.File;
import java.io.IOException;

public class SchubsArc
{
	public static void main(String[] args) throws IOException {

		String extenstion = args[0].substring(args[0].length()-3);
		BinaryOut writer = new BinaryOut(args[0]);

		try {
			for(int i = 0; i < args.length; i++) {
				schubsH.compress(args[i]);	
				tarsn(args[i]);
					
			}

		} finally {
			if (writer != null)
				writer.close();
		}
	}


	public static void tarsn(String file) throws IOException {
		File in1 = null;
		BinaryIn bin1 = null;
		BinaryOut out = null;
		
		char separator =  (char) 255; 
		
		try {
			out = new BinaryOut(file);
			
			// for (int i = 1; i < args.length; i++){
			
				in1 = new File(file);
				if (!in1.exists() || !in1.isFile()) return;
				System.out.println(file);

				long filesize = in1.length();
				int filenamesize = file.length();

				if( out == null){
					out = new BinaryOut(file);
				}
				
				out.write(filenamesize);
				out.write(separator);

				out.write(file);
				out.write(separator);
				
				out.write(filesize);
				out.write(separator);
		
				bin1 = new BinaryIn(file);

				while (!bin1.isEmpty())
					out.write(bin1.readChar());
			//}

		} finally {
			if (out != null)
				out.close();
			}


	}
}



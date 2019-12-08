import java.io.*;

public class DeschubsArc
{
    public static void main(String[] args) throws IOException {
	BinaryIn in = null;
	BinaryOut out = null;
	
	char sep =  (char) 255;  
	
	in = new BinaryIn( args[0] );	
	
	while(!in.isEmpty()){
			
			try {
				int filenamesize = in.readInt();
				sep = in.readChar();
				String filename="";
				for (int i=0; i<filenamesize; i++)
					filename += in.readChar();
				
				sep = in.readChar();
				long filesize = in.readLong();
				sep = in.readChar();
				System.out.println("Extracting file: " + filename + " ("+ filesize +").");
				out = new BinaryOut( filename );
				for (int i=0; i<filesize; i++)
					out.write(in.readChar());

			} finally {
				if (out != null)
				out.close();
			}
		}
		in.close();	
    }
}
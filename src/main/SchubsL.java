
public class SchubsL {
    private static final int R = 256;        
    private static final int L = 4096;       
    private static final int W = 12;         

    // private static BinaryIn in;
    // private static BinaryOut out;

    public static void compress(String filename) { 
        BinaryIn reader = new BinaryIn(filename);
        BinaryOut writer = new BinaryOut(filename + ".ll");
        
        String input = reader.readString();
        TST<Integer> st = new TST<Integer>();
        for (int i = 0; i < R; i++)
            st.put("" + (char) i, i);
        int code = R+1;  

        while (input.length() > 0) {
            String s = st.longestPrefixOf(input); 
            writer.write(st.get(s), W);      
            int t = s.length();
            if (t < input.length() && code < L)    
                st.put(input.substring(0, t + 1), code++);
            input = input.substring(t);            
        }
        writer.write(R, W);
        writer.close();
    } 

    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++) 
        {
			compress(args[i]);
		}
    }
}



package com.lynda;

public class SchubsL {
    private static final int R = 256;        
    private static final int L = 4096;       
    private static final int W = 12;         

    private static BinaryIn in;
    private static BinaryOut out;

    public static void compress() { 
        
        
        String input = in.readString();
        TST<Integer> st = new TST<Integer>();
        for (int i = 0; i < R; i++)
            st.put("" + (char) i, i);
        int code = R+1;  

        while (input.length() > 0) {
            String s = st.longestPrefixOf(input); 
            out.write(st.get(s), W);      
            int t = s.length();
            if (t < input.length() && code < L)    
                st.put(input.substring(0, t + 1), code++);
            input = input.substring(t);            
        }
        out.write(R, W);
        out.close();
    } 

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            in = new BinaryIn(args[i]);
            out = new BinaryOut(args[i] + ".ll");
            compress();
        }
    }

}

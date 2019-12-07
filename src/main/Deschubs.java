package com.lynda;

import java.io.IOException;

public class Deschubs {
    private static final int R = 256;        
    private static final int L = 4096;       
    private static final int W = 12;         

    private static BinaryIn in;
    private static BinaryOut out;

    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        private boolean isLeaf() {
            assert (left == null && right == null) || (left != null && right != null);
            return (left == null && right == null);
        }

        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    private static Node readTrie(BinaryIn reader) {
        boolean isLeaf = reader.readBoolean();
        if (isLeaf) {
	    char x = reader.readChar();
            return new Node(x, -1, null, null);}
        else {
            return new Node('\0', -1, readTrie(reader), readTrie(reader));
        }
    }
    

    public static void expandH(String filename, String filename2) {
        BinaryIn reader = new BinaryIn(filename);
        BinaryOut writer = new BinaryOut(filename2);

        Node root = readTrie(reader); 

        int length = reader.readInt();

        for (int i = 0; i < length; i++) {
            Node x = root;
            while (!x.isLeaf()) {
                boolean bit = reader.readBoolean();
                if (bit) x = x.right;
                else     x = x.left;
            }
            writer.write(x.ch);
        }
        writer.flush();

    }

    public static void expandL(String filename, String filename2) {
        BinaryIn reader = new BinaryIn(filename);
        BinaryOut writer = new BinaryOut(filename2);

        String[] st = new String[L];
        int i; 

        
        for (i = 0; i < R; i++)
            st[i] = "" + (char) i;
        st[i++] = "";                        

        int codeword = reader.readInt(W);
        String val = st[codeword];

        while (true) {
            writer.write(val);
            codeword = reader.readInt(W);
            if (codeword == R) break;
            String s = st[codeword];
            if (i == codeword) s = val + val.charAt(0);   
            if (i < L) st[i++] = val + s.charAt(0);
            val = s;
        }
        writer.close();
    }


    public static void main(String[] args) throws IOException {
        String extenstion = args[0].substring(args[0].length()-3);

        for (int i = 0; i < args.length; i++){
            if (extenstion.equals(".hh"))
                expandH(args[i], args[i].substring(0, args[i].length()-3));
            else if (extenstion.equals(".ll"))
                expandL(args[i], args[i].substring(0, args[i].length()-3));
            // else if (extenstion.equals(".zh"))
            //     // expandH(args[i], args[i].substring(0, args[i].length()-3));
            //     DeschubsArc.main(new String[] {args[i]});
            }

        }
    }

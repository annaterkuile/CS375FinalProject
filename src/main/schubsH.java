package com.lynda;

import java.io.*;

public class schubsH {

    private static BinaryIn in;
    private static BinaryOut out;

    private static final int R = 256;
    public static boolean logging = true;

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


    public static void err_print(String msg)
    {
	if (logging)
	    System.err.print(msg);
    }

    public static void err_println(String msg)
    {
	if (logging)
	    {
		System.err.println(msg);
	    }
    }

    public static void compress() {
  
        String s = in.readString();
        char[] input = s.toCharArray();

        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++)
            freq[input[i]]++;

        Node root = buildTrie(freq);

        String[] st = new String[R];
        buildCode(st, root, "");

        writeTrie(root);
	err_println("writeTrie");

        out.write(input.length);
	err_println("writing input length " + input.length);

	err_println("happily encoding... ");
       
        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
	    err_print("Char " + input[i] + " ");
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    out.write(false);
		    err_print("0");
                }
                else if (code.charAt(j) == '1') {
                    out.write(true);
		    err_print("1");
                }
                else throw new RuntimeException("Illegal state");
            }
	    err_println("");
        }

        out.flush();
    }

    private static Node buildTrie(int[] freq) {

        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++)
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));

        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
	    err_println("buildTrie parent " + left.freq + " " + right.freq);
            pq.insert(parent);
        }
        return pq.delMin();
    }


    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            out.write(true);
            out.write(x.ch);
	    err_println("T" + x.ch);
            return;
        }
        out.write(false);
	err_print("F");

        writeTrie(x.left);
        writeTrie(x.right);
    }

    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
	    err_println("buildCode " + x.ch + " " + s);
        }
    }

    private static Node readTrie() {
        boolean isLeaf = in.readBoolean();
        if (isLeaf) {
	    char x = in.readChar();
	    err_println("t: " + x );
            return new Node(x, -1, null, null);
        }
        else {
	    err_print("f");
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++){
            in = new BinaryIn(args[i]);
            out = new BinaryOut(args[i] + ".hh");
            compress();
        }
        
    }

}


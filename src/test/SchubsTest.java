package com.lynda;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.*;


public class SchubsTest 
    extends TestCase
{
    
    public SchubsTest( String testName )
    {
        super( testName );
    }

   
    public static Test suite()
    {
        return new TestSuite( SchubsTest.class );
    }

   
    public void testSchubsH() throws IOException
    {
        File f1 = new File("src" + File.separator + "res" + File.separator + "copy4.txt");
        File f2 = new File("src" + File.separator + "res" + File.separator + "oldcopy4.txt");
        File f3 = new File("src" + File.separator + "res" + File.separator + "copy5.txt");
        File f4 = new File("src"  + File.separator + "res"  + File.separator + "oldcopy5.txt");
        File f5 = new File("src"  + File.separator + "res"  + File.separator + "copy6.txt");
        File f6 = new File("src"  + File.separator + "res"  + File.separator + "oldcopy6.txt");
        
        schubsH.main(new String[] {"src"  + File.separator + "res"  + File.separator + "copy4.txt", "src"  + File.separator + "res"  + File.separator + "copy5.txt", "src"  + File.separator + "res"  + File.separator + "copy6.txt"});
        boolean b = f1.renameTo(f2);
        boolean c = f3.renameTo(f4);
        boolean d = f5.renameTo(f6);
        Deschubs.main(new String[] {"src"  + File.separator + "res"  + File.separator + "copy4.txt.hh", "src"  + File.separator + "res"  + File.separator + "copy5.txt.hh", "src"  + File.separator + "res"  + File.separator + "copy6.txt.hh"});

        BufferedReader reader1 = new BufferedReader(new FileReader("src"  + File.separator + "res"  + File.separator + "copy4.txt")); 
        BufferedReader reader2 = new BufferedReader(new FileReader("src"  + File.separator + "res"  + File.separator + "oldcopy4.txt"));
         
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
         
        boolean areEqual = true; 
        int lineNum = 1;
         
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if(! line1.equals(line2))
            {
                areEqual = false;
                 break;
            }
             
            line1 = reader1.readLine();
            line2 = reader2.readLine();
             
            lineNum++;
        }
         
        reader1.close();
        reader2.close();

        assert(areEqual);
    }

    public void testSchubsL() throws IOException
    {
        File f1 = new File("src"  + File.separator + "res"  + File.separator + "copy.txt");
        File f2 = new File("src"  + File.separator + "res"  + File.separator + "oldcopy.txt");
        File f3 = new File("src"  + File.separator + "res"  + File.separator + "copy2.txt");
        File f4 = new File("src"  + File.separator + "res"  + File.separator + "oldcopy2.txt");
        File f5 = new File("src"  + File.separator + "res"  + File.separator + "copy3.txt");
        File f6 = new File("src"  + File.separator + "res"  + File.separator + "oldcopy3.txt");
        
        SchubsL.main(new String[] {"src"  + File.separator + "res"  + File.separator + "copy.txt", "src"  + File.separator + "res"  + File.separator + "copy2.txt", "src"  + File.separator + "res"  + File.separator + "copy3.txt"});
        boolean b = f1.renameTo(f2);
        boolean c = f3.renameTo(f4);
        boolean d = f5.renameTo(f6);
        Deschubs.main(new String[] {"src"  + File.separator + "res"  + File.separator + "copy.txt.ll", "src"  + File.separator + "res"  + File.separator + "copy2.txt.ll", "src"  + File.separator + "res"  + File.separator + "copy3.txt.ll"});

        BufferedReader reader1 = new BufferedReader(new FileReader("src"  + File.separator + "res"  + File.separator + "copy.txt")); 
        BufferedReader reader2 = new BufferedReader(new FileReader("src"  + File.separator + "res"  + File.separator + "oldcopy.txt"));
         
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
         
        boolean areEqual = true; 
        int lineNum = 1;
         
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if(! line1.equals(line2))
            {
                areEqual = false;
                 break;
            }
             
            line1 = reader1.readLine();
            line2 = reader2.readLine();
             
            lineNum++;
        }
         
        reader1.close();
        reader2.close();

        assert(areEqual);
    }

    // public void testSchubsTars() throws IOException
    // {
    //     File f1 = new File("src"  + File.separator + "res"  + File.separator + "copy.txt");
    //     File f2 = new File("src"  + File.separator + "res"  + File.separator + "oldcopy.txt");
    //     File f3 = new File("src"  + File.separator + "res"  + File.separator + "copy2.txt");
    //     File f4 = new File("src"  + File.separator + "res"  + File.separator + "oldcopy2.txt");
    //     File f5 = new File("src"  + File.separator + "res"  + File.separator + "copy3.txt");
    //     File f6 = new File("src"  + File.separator + "res"  + File.separator + "oldcopy3.txt");
        
    //     SchubsArc.main(new String[] {"src"  + File.separator + "res"  + File.separator + "copy.txt", "src"  + File.separator + "res"  + File.separator + "copy2.txt", "src"  + File.separator + "res"  + File.separator + "copy3.txt"});
    //     boolean b = f1.renameTo(f2);
    //     boolean c = f3.renameTo(f4);
    //     boolean d = f5.renameTo(f6);
    //     Deschubs.main(new String[] {"src"  + File.separator + "res"  + File.separator + "copy.txt.hh"});

    //     BufferedReader reader1 = new BufferedReader(new FileReader("src"  + File.separator + "res"  + File.separator + "copy.txt")); 
    //     BufferedReader reader2 = new BufferedReader(new FileReader("src"  + File.separator + "res"  + File.separator + "oldcopy.txt"));
         
    //     String line1 = reader1.readLine();
    //     String line2 = reader2.readLine();
         
    //     boolean areEqual = true; 
    //     int lineNum = 1;
         
    //     while (line1 != null || line2 != null)
    //     {
    //         if(line1 == null || line2 == null)
    //         {
    //             areEqual = false;
    //             break;
    //         }
    //         else if(! line1.equals(line2))
    //         {
    //             areEqual = false;
    //              break;
    //         }
             
    //         line1 = reader1.readLine();
    //         line2 = reader2.readLine();
             
    //         lineNum++;
    //     }
         
    //     reader1.close();
    //     reader2.close();

    //     assert(areEqual);
    // }

}

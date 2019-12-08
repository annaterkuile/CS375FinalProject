# CS375FinalProject

This project focueses on data compression using the Huffman and LZW algorithms which a ideal when dealing with a moderate amound of data

## Design

When dealing with the design of the project it is important to understand the algorithm theories and the various trade offs each one has. 

### Huffman 

Huffman is used to avoid ambiguity becuase it ensure that there is no codeword that is a prefix of another. The algorithm tabulates a char frequencies and then builds a binary trie where the leaves are made of chars and the codewords are the roots to the leaves. It produces an optimal prefix-free code.

### LZW

LZW is an algorithm that relies on reoccuring patterns to save data space and is commonly used for general purpose data compression. This algorithm works by reading in a sequence of symbols and then grouping them into strings and coverting into code. 

### Differences and Tradeoffs

Huffman is a dynamic model which means that the model is generated based on text. There must be a preliminary pass to generate the model and also much transmit the model. LZW on the other hand is an adaptive model becuase it progressively learns and updated the model as you read the text. Overall LZW creates a more accurate model which leads to better compression. 

## Tests

The automated tests are run when 'mvn test' is run in the terminal. 

### Break down of tests

The tests take in txt files that have been created and put in the res folder and then performs the designated algorithm to compress them. 

After defining the files, both "old" and "new", which are names that are used to designate which was initially run with the algorithm and which is the one that was decompressed. I call the huffman main to compress the three files that have been defined 

```
schubsH.main(new String[] {"src"  + File.separator + "res"  + File.separator + "copy4.txt""});
```
and then rename the files that were used to be called "old" that way we can go back and check but they are not the output files 

```
boolean b = f1.renameTo(f2);
```
and then call the expand program that will take what has been compressed and return it to the original txt which is where we get the now "copy.txt"

```Deschubs.main(new String[] {"src"  + File.separator + "res"  + File.separator + "copy4.txt.hh"});
```

Then to make sure that correct thing has been outputted I read in both files, us a readline functions and then make sure that they are equal so that the we see that what we put in and what was compressed and then expanded are the same. 

I do the same thing for the LZW. And then also test using more than one file to make sure that they can take in 'n' files. 

## Installation 

To install this project you must clone the repo and then compile said repo with 'mvn test' in the root directory. 

## Run Examples

If you are going to use java -cp target/classes <Program Name> src/res/<filename> 

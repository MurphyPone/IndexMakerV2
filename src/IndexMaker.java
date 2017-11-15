/**
 * This program takes a text file, creates an index (by line numbers)
 *  for all the words in the file and writes the index
 *  into the output file.  The program takes input and output file names
 *  from the command-line args or prompts the user for the file names.
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class IndexMaker {
  public static void main(String[] args) throws IOException {
    Scanner keyboard = new Scanner(System.in);
    String fileName;

    // Open input file
    if (args.length > 0) 
    		fileName = args[0];	//Input = first arg
    	else {
    		System.out.print("\nEnter input file name: ");
    		fileName = keyboard.nextLine().trim(); //Input = user input
    }

    BufferedReader inputFile = new BufferedReader(new FileReader(fileName), 1024);

    // Create output file:
    if (args.length > 1)
    		fileName = args[1];	//Output = second arg
    else {	//Input supplied, but no output
    	System.out.println(getPrefix(fileName) + "Index" + getExtension(fileName));		
      	fileName = getPrefix(fileName) + "Index" + getExtension(fileName);
    }

    PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));

    // Create index:
    DocumentIndex index = new DocumentIndex();

    String line;
    int lineNum = 0;
    while ((line = inputFile.readLine()) != null) {
      lineNum++;
      index.addAllWords(line, lineNum);
    }

    // Save index:
    Set<String> keys = index.keySet();	//returns the set of keys	
    									//Thanks patrick --do not use me
    									//put in tostring
    for(String entry : keys) 	//For each key in the set of keys corresponding to the TreeMap: index
        outputFile.println(index.get(entry));
   
    // Finish:
    inputFile.close();
    outputFile.close();

    keyboard.close();
    System.out.println("Done.");
  }
  
  public static String getExtension(String in) {
	  int dot = in.indexOf(".");	//Finds the first period
	  //Check if there is an extension 
	  if(!(dot == -1)) //if there is at least one . denoting a file extension
		   return in.substring(dot);	//Clips the input so that it just has the extension 
	  return "";	//Return an empty string, the file extension does not exist
  }
  
  public static String getPrefix(String in) {
	  int dot = in.indexOf(".");
	  if(!(dot == -1))	//If there is a .
		  return in.substring(0, dot);	//return everything up to the first .
	  return in;	 //Else, return the whole input string
  }
}

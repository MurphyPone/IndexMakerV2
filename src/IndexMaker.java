/**
 * 	Class Description: This program takes a text file, creates an index (by line numbers)
 *  					for all the words in the file and writes the index
 *  					into the output file.  The program takes input and output file names
 *  					from the command-line args or prompts the user for the file names.
 *  @author MurphyP1
 *  @date 11/15/17
 */

/*imports a whole mess of libs*/
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class IndexMaker {
	
	/**
	 * The tester main method kicks things off
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method main
	 * 
	 * @param args an array of Strings which are the files supplied to the Java program via command line?
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);	//Creates the keyboard
		String fileName;	//Declares a string fileName which will be used throughout the rest of the method

		// Open input file
		if (args.length > 0) 
    		fileName = args[0];	//Input = first arg
    	else {
    		System.out.print("\nEnter input file name: ");
    		fileName = keyboard.nextLine().trim(); //Input = user input
    	}
		
		//Creates the input file from the first argument or the user input
		BufferedReader inputFile = new BufferedReader(new FileReader(fileName), 1024);

		// Create output file:
		if (args.length > 1) 
    		fileName = args[1];	//Output = second arg
		else {	//Input supplied, but no output
			//System.out.println(getPrefix(fileName) + "Index" + getExtension(fileName));		
			fileName = getPrefix(fileName) + "Index" + getExtension(fileName);
		}

		//Creates the output file
		PrintWriter outputFile = new PrintWriter(new FileWriter(fileName));

		// Create index:
		DocumentIndex index = new DocumentIndex();

		String line;	//String variable which will represent 
		int lineNum = 0;	//Int counter which informs the DocumentIndex>IndexEntry classes which line number a word occurs on
		while ((line = inputFile.readLine()) != null) {
			lineNum++;	
			index.addAllWords(line, lineNum);
		}

		// Save/write index:
		outputFile.print(index);
   
		// Finish:
		inputFile.close();
		outputFile.close();

		keyboard.close();
		System.out.println("Done.");
	}
  
	/**
	 * Clips the end of an input filename, leaving only the extension if one is present
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method getExtension
	 * 
	 * @param in a String which represents the input file to be shortened
	 * @returns either an file extension or an empty String depending on whether or not the input file has an extension
	 */
	public static String getExtension(String in) {
	  int dot = in.indexOf(".");	//Finds the first period
	  //Check if there is an extension 
	  if(!(dot == -1)) //if there is at least one . denoting a file extension
		   return in.substring(dot);	//Clips the input so that it just has the extension 
	  return "";	//Return an empty string, the file extension does not exist
	}
  
	/**
	 * Clips OFF the end of an input filename, leaving everything up to the file extension if any
	 * 
	 * @author MurphyP1
	 * @date 11/15/17
	 * @method getPrefix
	 * 
	 * @param in a String which represents the input file to be shortened
	 * @returns either the file name up to the extension, or an empty String depending on whether or not the input file has an extension
	 */
	public static String getPrefix(String in) {
	  int dot = in.indexOf(".");
	  if(!(dot == -1))	//If there is a .
		  return in.substring(0, dot);	//return everything up to the first .
	  return in;	 //Else, return the whole input string
  }
}

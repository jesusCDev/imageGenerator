package createString;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GetSentencedFromFile {

	private String fileQuotes = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\FileKeeper\\Quotes.txt";
	private String fileIDs = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\FileKeeper\\imageIDs.txt";
	
	/**
	 * This gets the latest quote we need depending on the last number of ids
	 * @return returns the quote
	 */
	public String getQuote(){

		BufferedReader fileOfQuotes = null;
		BufferedReader fileOfIDs = null;
		int lastAssignedID = 0;
		String quote = null;
		String line = null;
		int lineNumber = 0;
		
	
	//OPEN FILES
		//finds what the next quote we are going to use is & opens file
		try {
			fileOfQuotes = new BufferedReader(new FileReader(fileQuotes));
			fileOfIDs = new BufferedReader(new FileReader(fileIDs));
			
			while ((fileOfIDs.readLine()) != null) {
				lastAssignedID++;
			}
			fileOfIDs.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//OPEN FILE
		
	
	//READ QUOTE FROM FILE
		//sets string to the next quote we haven't used
		try {
			while((line = fileOfQuotes.readLine()) != null){
				if(lineNumber == lastAssignedID){
					quote = line;
				}
				lineNumber++;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	//READ QUOTE FROM FILE

		
		//close scanner scanner
		if(fileOfQuotes != null){
			try {
				fileOfQuotes.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return quote;
	}
}

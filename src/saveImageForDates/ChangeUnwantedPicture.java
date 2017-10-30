package saveImageForDates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * This method will change unwanted pictures
 * @author jesus
 *
 */
public class ChangeUnwantedPicture {

	private String fileIDs = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\FileKeeper\\imageIDs.txt";
	private String fileUsedImages = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\FileKeeper\\usedImaegs.txt";
	//checks document
	public void randomlyPickImageForFolder() throws IOException{
		Random number = new Random();
		BufferedReader fileIdOfQuotes = new BufferedReader(new FileReader(fileIDs));
		BufferedReader picturesUsed = new BufferedReader(new FileReader(fileUsedImages));

		String line = null;
		int lineOfIds = 0;
		int lineOfPicturesUsed = 0;
		boolean done = true;
		
	//READ QUOTE FROM FILE
		//sets string to the next quote we haven't used
		while((line = fileIdOfQuotes.readLine()) != null){
			lineOfIds++;
		}
		
		line = null;
		
		//sets string to the next quote we haven't used
		while((line = picturesUsed.readLine()) != null){
			lineOfPicturesUsed++;
		}
	//READ QUOTE FROM FILE
		int randomNumberPickedOne;
		int randomNumberPickedTwo;
		int randomNumberPickedThree;
		String lineId;
		String lineIdUsed;
		do{
			fileIdOfQuotes = new BufferedReader(new FileReader(fileIDs));

			randomNumberPickedOne = number.nextInt(lineOfIds) + 1;
			randomNumberPickedTwo = number.nextInt(lineOfIds) + 1;
			randomNumberPickedThree = number.nextInt(lineOfIds) + 1;
			
			for(int i = 0; i < lineOfPicturesUsed; i++){
				lineIdUsed = picturesUsed.readLine();
				for(int j = 0; j < lineOfIds; i++){
					lineId = fileIdOfQuotes.readLine();
					if(lineIdUsed == lineId){
						
					}
				}
			}
		}while(done);
		
		picturesUsed.close();
		fileIdOfQuotes.close();
	}
	//file scanned
	//if missing number, then redo picture
	//save it back to dropbox folder and switch it with new picture
	
}

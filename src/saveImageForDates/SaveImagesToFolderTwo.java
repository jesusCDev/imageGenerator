package saveImageForDates;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SaveImagesToFolderTwo {

	private String fileIDs = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\FileKeeper\\imageIDs.txt";
	private String fileUsedImages = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\FileKeeper\\usedImages.txt";
	private String getImages = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\Images\\";
	private String saveImages ="C:\\Users\\jesus\\Dropbox\\Instagram\\Images\\";
	private String fileToUseReaderText = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\FileKeeper\\fileToUseReader.txt";
	private String extention = ".png";
	private String slashMarks = "\\";
	private String hashTagExtention = "hashTags.txt";
	private String id = "ID_";
	private String tag = "_TAG_Motivation_NAME_";
	private String hashtags = "#Motivation #inspiration #workout #healthy #diet #lifestyle #gym #gains #entrepreneur #startup #business"
			+ " #programmer #quote #daily #dailyquote #dailyMotivation #inspire #life #fitness #healthylife #entrepreneurship #mindset"
			+ " #wealth #success #hustle #passion #dream #dreams #wisdom #founder";
	
	private int numberOfPicturesInEachFolder = 5;
	
	/**
	 * Randomly pics 1
	 * @return returns names of 
	 */
	public String randomlyPickImageForFolder(){
		
		Random number = new Random();

		int lineOfIds = 0;
		int lineOfPicturesUsed = 0;
		String quote = null;
		
		
	//OPEN FILES
		try {
			BufferedReader fileIdOfQuotes = new BufferedReader(new FileReader(fileIDs));
			BufferedReader picturesUsed = new BufferedReader(new FileReader(fileUsedImages));

		//COUNT NUMBER OF LINES IN BOTH FILES
			//sets string to the next quote we haven't used
			while((fileIdOfQuotes.readLine()) != null){
				lineOfIds++;
			}
			//sets string to the next quote we haven't used
			while((picturesUsed.readLine()) != null){
				lineOfPicturesUsed++;
			}
		//COUNT NUMBER OF LINES IN BOTH FILES
		
			fileIdOfQuotes.close();
			picturesUsed.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	//OPEN FILES
		
		
		//if(lineOfIds < (lineOfPicturesUsed - 2)){
		int randomNumberPickedOne;
			
		boolean oneTrue = false;
		String  foundId = null;
		boolean done = true;
		
		
	//GETS THREE NAMES THAT HAVEN'T BEEN PICEED
		if(lineOfPicturesUsed < lineOfIds){
			try {
				BufferedReader picturesUsed;	
				do{
					
				//PICK FIRST RANDOM NAMES
					randomNumberPickedOne = number.nextInt(lineOfIds);
					foundId = id + randomNumberPickedOne + tag;
				//PICK FIRST RANDOM NAMES


				//COMPARE NAMES TO INSIDE FILE
					picturesUsed = new BufferedReader(new FileReader(fileUsedImages));
					String lineBeingRead;
					while((lineBeingRead = picturesUsed.readLine()) != null){
						if(lineBeingRead.equals(foundId)){
							oneTrue = true;
						}
					}
					if(oneTrue == false){
						break;
					}
					oneTrue = false;
				//COMPARE NAMES TO INSIDE FILE
					
				}while(done);
				picturesUsed.close();

			//SAVES NEW VALUE TO FILE
				BufferedWriter picturesUsedWriter = new BufferedWriter(new FileWriter(fileUsedImages, true));
				
				picturesUsedWriter.write(foundId);
				picturesUsedWriter.newLine();
				picturesUsedWriter.close();
			//SAVES NEW VALUE TO FILE
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		//FINEDS FILE IF THERE IS A FILE LEFT
			quote = foundId;
		}
	//GETS THREE NAMES THAT HAVEN'T BEEN PICEED	

		return quote;
	
	}
	
	/**
	 * This method gets the values of which folder they are currently on and how many pictures are in the folder
	 * @return number of images in folder, number of folder they are stored in
	 */
	public int[] getFolderNumberAndPicturesInFolder(){
	  
		int[] folderAndNumberBeingSavedTo = {0,0};
		try{
	  	//FINDS WHICH FILE WE ARE USING (POSITIVE OR NEGATIVE)
			BufferedReader fileToUseReader = new BufferedReader(new FileReader(fileToUseReaderText));
			String numberOfFilesNumberOfFolder = fileToUseReader.readLine();
			if(numberOfFilesNumberOfFolder != null){
				String[] lineWithInfoConver = numberOfFilesNumberOfFolder.split("\\s+");
				int numberOfFilesInFolder = Integer.parseInt(lineWithInfoConver[0]);
				int numberOfFolder = Integer.parseInt(lineWithInfoConver[1]);
				folderAndNumberBeingSavedTo[0] = numberOfFilesInFolder;
				folderAndNumberBeingSavedTo[1] = numberOfFolder;
			} else {
				 folderAndNumberBeingSavedTo[0] = 0;
				 folderAndNumberBeingSavedTo[1] = 0;
			}
		//PUTS NUMBER OF FOLDER AND NUMBER OF FILES IN FOLER IN ARRAY
			fileToUseReader.close();
		//FINDS WHICH FILE WE ARE USING (POSITIVE OR NEGATIVE)
		}catch(IOException e){
			System.out.println(e);
		}
		return folderAndNumberBeingSavedTo;
	}

	/**
	 * This method saves the details for what folder they are in and for how many pictures are in the current file
	 * @param folderAndNumberBeingSaveTo the alues taht will be stored in the folder
	 */
	public void SaveToNewfile(int[] folderAndNumberBeingSaveTo){
		//Sets to have which file to copy onto next time
		try {
			BufferedWriter fileToUseWriter = new BufferedWriter(new FileWriter(fileToUseReaderText));
			fileToUseWriter.write(folderAndNumberBeingSaveTo[0] + " " + folderAndNumberBeingSaveTo[1]);
			fileToUseWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Sets to have which file to copy onto next time
	}
	
	/**
	 * This method copies the picture in the current folder to the new destination
	 * @param folderAndNumberBeingSavedTo number of pictures in folder, number of folder
	 * @param linesPlacedInFolder the string of the image that needs to be moved
	 * @return the array with the values incase it needs to finish and save the values
	 */
	public int[] saveImageToDropboxFolder(int[] folderAndNumberBeingSavedTo, String linesPlacedInFolder){
		
		//GETS PICTURE DIRECTORY
		File source = new File(getImages + linesPlacedInFolder + slashMarks + linesPlacedInFolder + extention);

		//CREATES DESTINATION FOLDER
		new File(saveImages + folderAndNumberBeingSavedTo[1]).mkdirs();
		//CREATRES DESTINATION FOR PICTURE
		File destanation = new File(saveImages + folderAndNumberBeingSavedTo[1] + slashMarks + linesPlacedInFolder + extention);
				
		//COPIES FILE
		copyFile(source, destanation);
		
		//keeps track of the number of pictures in each folder
		folderAndNumberBeingSavedTo[0] = (folderAndNumberBeingSavedTo[0] + 1);
		if(folderAndNumberBeingSavedTo[0] == numberOfPicturesInEachFolder){
			
			//saves a hashtag file to each file
			try {
				BufferedWriter hashTagsFile = new BufferedWriter(new FileWriter(saveImages + folderAndNumberBeingSavedTo[1] + slashMarks + hashTagExtention));
				hashTagsFile.write(hashtags);
				hashTagsFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			folderAndNumberBeingSavedTo[0] = 0;
			folderAndNumberBeingSavedTo[1] = folderAndNumberBeingSavedTo[1] + 1;
		}
		return folderAndNumberBeingSavedTo;
	}
	
	/**
	 * This method will just copy the file to the new folder and will not effect any othe rfile
	 * @param quoteAndDestination
	 */
	public void saveImageToDropboxFolder(String[] quoteAndDestination){
			
		//GETS PICTURE DIRECTORY
		File source = new File(quoteAndDestination[0] + slashMarks + quoteAndDestination[2] + extention);
		//CREATRES DESTINATION FOR PICTURE
		File destanation = new File(quoteAndDestination[1] + quoteAndDestination[2] + extention);
					
		//COPIES FILE
		copyFile(source, destanation);
		
		System.out.println("done copying");
	}

	/**
	 * copyies files to new folders
	 * @param source this is the image they are moving
	 * @param destanation thius is the place they will be moving too
	 */
	private void copyFile(File source, File destanation){
		
		try{
			InputStream input = new FileInputStream(source);
			FileOutputStream output = new FileOutputStream(destanation);
		
		//MOVING IMAGE
			byte[] buf = new byte[1024];
			int bytesRead;
			
			while((bytesRead = input.read(buf)) > 0){
				output.write(buf, 0, bytesRead);
			}
		//MOBING IMAGE
			
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

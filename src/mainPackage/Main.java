package mainPackage;

import java.util.ArrayList;

import createBackground.AutomaticallyGenerted;
import createBackground.CreateImage;
import createString.GetSentencedFromFile;
import fixImage.FixImages;
import saveImageForDates.SaveImagesToFolderTwo;

public class Main {

	/**
	 * Creates Images for Instagram
	 */
	public static void main(String[] args){
		
		
	//CREATES THE IMAGES
		boolean quotesBeingRead = true;
		GetSentencedFromFile quoteFromList = new GetSentencedFromFile();
		AutomaticallyGenerted automaticallyGeneratedValues = new AutomaticallyGenerted();
		String automaticallyGeneratedTitle;
		CreateImage createImage = new CreateImage();
		
		do{
			
		//CREATE QUOTE
			//returns quote
			String quote = quoteFromList.getQuote();
			if(quote == null){
				break;
			}
		//CREATE QUOTE
		
		//CREATE FOLDER
			//creates automatically generated image ID & stores it in self folder
			automaticallyGeneratedTitle = automaticallyGeneratedValues.automaticallyCreateImageID();
			//creates folder path for new image
			automaticallyGeneratedValues.automaticallyCreateFolderPathForImage(automaticallyGeneratedTitle);
		//CREATE FOLDER
			
		//CREATGE IMAGE
			int numberOfLines = createImage.setImageRatio(quote);
			createImage.imageDetails(quote);
			createImage.createStringForground(quote, numberOfLines);
			createImage.saveImage(automaticallyGeneratedTitle, quote);
		//CREATE IMAGE
			
		}while(quotesBeingRead);
	//CREATES THE IMAGES

		System.out.println("Done Creating all images" + "\n");
		
	//SAVE IMAGE INTO FOLDER USED
		SaveImagesToFolderTwo saveImage = new SaveImagesToFolderTwo();
		int[] folderBeingSavedTo = saveImage.getFolderNumberAndPicturesInFolder();
		String linesBeingPlacedInFolder;
		
		//will run until there are no longer any more images left to move
		do{
	
			linesBeingPlacedInFolder = saveImage.randomlyPickImageForFolder();
			//if a quote is provided, it is moved to a new folder, if it is not then it will break
			if(linesBeingPlacedInFolder != null){
				folderBeingSavedTo = saveImage.saveImageToDropboxFolder(folderBeingSavedTo, linesBeingPlacedInFolder);
			}else{
				saveImage.SaveToNewfile(folderBeingSavedTo);
				break;
			}
			
		}while(quotesBeingRead);
	//SAVE IMAGE INTO FOLDER USED
		
		System.out.println("Done Moving Images" + "\n");
		
	//FIX IMAGES
		FixImages fix = new FixImages();
		int currentFile = 0;
		ArrayList<String> filesToFix = fix.getFileName();
		do{
			String[] quoteAndDestination = fix.getQuoteAndDestination(filesToFix, currentFile);
			if(quoteAndDestination[0] != null){
				fix.createImage(quoteAndDestination);
				fix.copyToOtherFolder(quoteAndDestination);
				currentFile++;
			}else{
				break;
			}
		}while(quotesBeingRead);
		fix.clearFile();
	//FIX IMAGES
		
		System.out.println("Done Fixing Images" + "\n");
	}
}

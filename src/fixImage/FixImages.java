package fixImage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import createBackground.CreateImage;
import saveImageForDates.SaveImagesToFolderTwo;

/**
 * This class will allow me to fix certain pictures if they are not to my liking
 * @author jesus
 *
 */
public class FixImages {

	private String fixedFileDestination = "C:\\Users\\jesus\\Dropbox\\Instagram\\fixImages.txt";
	private String oneDrivePath = "C:\\Users\\jesus\\Dropbox\\Instagram\\Images\\";
	private String originalFolderPath = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\Images\\";
	
	/**
	 * This method gets the info for the files i would like to change
	 * @return array with the info of the files to manipulate
	 */
	public ArrayList<String> getFileName(){
		
		ArrayList<String> filesToFix = new ArrayList<String>();
		String lineToFix = "blank";
		
		try {
			BufferedReader file = new BufferedReader( new FileReader(fixedFileDestination));
			while(lineToFix != null){
				lineToFix = file.readLine();
				filesToFix.add(lineToFix);
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filesToFix;
	}

	/**
	 * This method will get the destination of the original folder, the onedrive folder, and the qutoe name
	 * @param filesToFix this is passing in the file that i need to fix so it only gets the info for the file in the row
	 * @param currentFile this tracks where we are in the array list
	 * @return returns the info we have now gotten: source path, deestination, and file name
	 */
	public String[] getQuoteAndDestination(ArrayList<String> filesToFix, int currentFile) {
		
		String file = filesToFix.get(currentFile);
		String[] quoteAndDestination = new String[3];
		
		if(file != null){
			String[] fileInfo = file.split("\\s");

			quoteAndDestination = new String[3];
			
			quoteAndDestination[2] = fileInfo[1];
			quoteAndDestination[1] = oneDrivePath + fileInfo[0] + "\\";
			quoteAndDestination[0] = originalFolderPath + quoteAndDestination[2] + "\\";
		}else{
			quoteAndDestination[0] = null;
		}
		
		return quoteAndDestination;
	}
	
	/**
	 * this will create the image using the file info
	 * @param quoteAndDestination this will take in the info we provide it with to make the right picture
	 */
	public void createImage(String[] quoteAndDestination){
		
		String quote = null;
		//Gets quoteString quote;
		try {
			BufferedReader quoteReader = new BufferedReader(new FileReader(quoteAndDestination[0] + "\\quote.txt"));
			quote = quoteReader.readLine();
			quoteReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//creates the image
		CreateImage createImage = new CreateImage();
		int numberOfLines = createImage.setImageRatio(quote);
		createImage.imageDetails(quote);
		createImage.createStringForground(quote, numberOfLines);
		createImage.saveImage(quoteAndDestination[2], quote);
	}

	/**
	 * This will copy the new picture we have just created to the new folder
	 * @param quoteAndDestination this is passing along the destination and the source and the name of the image
	 */
	public void copyToOtherFolder(String[] quoteAndDestination) {
		SaveImagesToFolderTwo saveImage = new SaveImagesToFolderTwo();
		saveImage.saveImageToDropboxFolder(quoteAndDestination);
	}

	/**
	 * this will clear the file with the names of the images we wish to remake
	 */
	public void clearFile() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fixedFileDestination));
			writer.write("");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

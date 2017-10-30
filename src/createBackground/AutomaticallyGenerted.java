package createBackground;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AutomaticallyGenerted {

	private String fileIDs = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\FileKeeper\\imageIDs.txt";
	private String filesWhereImagesAre = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\Images\\";
	private String id = "ID_";
	private String tag = "_TAG_Motivation_NAME_";
	
	/*
	 *generates image's id 
	 * @return
	 */
	public String automaticallyCreateImageID() {
		
		String generatedID;
		int lastAssignedID = 0;
		
		//find out next number for ID
		try {
			BufferedReader fileOfIDs = new BufferedReader(new FileReader(fileIDs));
			while ((fileOfIDs.readLine()) != null) {
				lastAssignedID++;
			}
			fileOfIDs.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//generate ID
		generatedID = id + lastAssignedID + tag;

		lastAssignedID++;

		//add new ID to file
		try{
			BufferedWriter writingIDToFile = new BufferedWriter(new FileWriter(fileIDs, true)); //Keep true so it doesn't delete everything in it
			writingIDToFile.write(generatedID);
			writingIDToFile.newLine();
			writingIDToFile.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//return ID
		return generatedID;
	}
	
	/*
	 * generates folder names
	 */
	public void automaticallyCreateFolderPathForImage(String automaticallyGeneratedFolderName){
		new File(filesWhereImagesAre + automaticallyGeneratedFolderName).mkdir();
	}
}

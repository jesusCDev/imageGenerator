package createBackground;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;

import createString.CreateString;

public class CreateImage {

	private BufferedImage bufferedImage;
	private Graphics graphics;
	
	private int width;
	private int height;
	private FontMetrics metrics;
	private String textFontColor = "white";
	private String quoteExtention = "\\quote.txt";
	private String filesWhereImagesAre = "C:\\Users\\jesus\\Desktop\\workspace\\insta\\AutoCreate\\Images\\";
	/**
	 * creates image background
	 * @param quote creates background
	 */
	public void imageDetails(String quote){
		
		
	//CREATES BACKGROUND
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        graphics = bufferedImage.getGraphics();
    //CREATES BACKGROUND
        
        
    //CREATES BACKGROUND
        CreateBackground createBackground = new CreateBackground();
        
        textFontColor = createBackground.colorBackgroundGradient(height, width, bufferedImage);
        
        String mainShape = createBackground.choseMainShape();

        int[] sizeOrientationColor = createBackground.createMainShapeDescription(mainShape, textFontColor, height, width);
        createBackground.createMainShape(bufferedImage, mainShape, sizeOrientationColor);
    //CREATES BACKGROUND
        
        
	}
	
	/**
	 * Puts quote on picture
	 * @param quote put string on image
	 * @param numberOfLines number of lines it'll take to put in picture
	 */
	public void createStringForground(String quote, int numberOfLines){
	
		
	//PUTS QUOTE ON IMAGE
        CreateString createString = new CreateString();
      //Font color
        if(textFontColor.equals("grey")){
        	Color customColor = new Color(58,58,58);
            graphics.setColor(customColor);
        }else{
            graphics.setColor(Color.WHITE);
        }
        createString.setTextInImage(quote, height, graphics, metrics, numberOfLines);
    //PUTS QUOTE ON IMAGE
	
        
	}
	/**
	 * Makes folder and save image
	 * @param automaticallyGeneratedTitle title of folder and image
	 */
	public void saveImage(String automaticallyGeneratedTitle, String quote){
		
		
	//SAVE IMAGE
		try {
			new File(filesWhereImagesAre + automaticallyGeneratedTitle).mkdirs();
			File file = new File(filesWhereImagesAre + automaticallyGeneratedTitle + "\\" + automaticallyGeneratedTitle + ".png" );
			ImageIO.write(bufferedImage, "png",file );
			//saves file to destination
			BufferedWriter textWithQuote = new BufferedWriter(new FileWriter(filesWhereImagesAre + automaticallyGeneratedTitle + quoteExtention));
			textWithQuote.write(quote);
			textWithQuote.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//SAVE IMAGE
		
		
	}
	
	/**
	 * sets ratio to image
	 * @param quote the quote taken from the file
	 * @return returns the number of lines it will take in the picture
	 */
	public int setImageRatio(String quote){
		
		int numberOfLines = 0;
		int startOfQuote = 0;
		int endOfQuote = quote.length();
		int nextNumberOfQuote = 35;
		int lineInWhichQuoteStartsIfAuthoPossible = quote.indexOf("-");
		

	//SETS END OF QUOTE IF AND BEFORE AUTHOR
		if(lineInWhichQuoteStartsIfAuthoPossible != -1){
			endOfQuote = lineInWhichQuoteStartsIfAuthoPossible - 1;
		}
	//SETS END OF QUOTE IF AND BEFORE AUTHOR
		

	//COUNTS NUMBER OF LINES IN QUOTE
		while(nextNumberOfQuote != endOfQuote){
			
			//breaks loop if the quote is done being read
			if(nextNumberOfQuote > endOfQuote){
				nextNumberOfQuote = endOfQuote;
			}
			if(startOfQuote > endOfQuote){
				break;
			}
			
			
		//FIXES WHITESPACE
			//counts the whitespace in the line
			int whiteSpace = 0;
			for(int i = startOfQuote; i < nextNumberOfQuote; i++){
				if(Character.isWhitespace(quote.charAt(i))){
					whiteSpace = i;
				}
			}
			
			if(nextNumberOfQuote > endOfQuote){
				nextNumberOfQuote = endOfQuote;
			}
			
			//adds the line of the value that the white space is at
			if(whiteSpace != 0){
				nextNumberOfQuote = whiteSpace;
			}
		//FIXES WHITESPACE
			
		
		//FIXES QUOTE SECTION AND LINE NUMBERS
			startOfQuote = (nextNumberOfQuote + 1);
			nextNumberOfQuote += 35;
			
			numberOfLines++;
		//FIXES QUOTE SECTION AND LINE NUMBERS
		
			
		}
	//COUNTS NUMBER OF LINES IN QUOTE
		
		
	//CHECKS IF QUTOE HAS AUTHOR
		if(lineInWhichQuoteStartsIfAuthoPossible != -1){
			numberOfLines++;
		}
	//CHECKS IF QUTOE HAS AUTHOR
		
		
	//SETS HEIGHT
		if(numberOfLines > 7){
			width = 1920;
			height = 2400;
		}else{
			width = 1920;
			height = 1920;
		}
	//SETS HEIGHT
		
		return numberOfLines;
	}
}

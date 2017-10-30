package createString;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class CreateString {

	/**
	 * sets text to image
	 * @param quote quote that will be set to image
	 * @param height height of the image to determine how text will be manipulated
	 * @param graphics graphics of the image that is bring created
	 * @param metrics passes metrics of font that is bringing used
	 * @param numberOfLines size of lines of the image to determine how text will be manipulated
	 */
	public void setTextInImage(String quote, int height, Graphics graphics, FontMetrics metrics, int numberOfLines){

		//this will add the extra line for room for my watertag
	//DETAILS OF IMAGE
		int imageWidth = 1920;
		int centerPositionWidth = 960;
		int centerPositionHeight = 1200;
	//DETAILS OF IMAGE
		
		boolean done = true;
		String userName = "@5DailyMotivation";
		
	//LINE INFORMATION
		int numberOfLinesToReachTop = 7;
		int lineSpaceing = 130;
		int sentenceSplitSize = 35;
		int startOfQuote = 0;
		int endOfQuote = quote.length();
		int nextNumberOfQuote = sentenceSplitSize;
		int linesInQuote = numberOfLines;
		int lines = numberOfLines;
		String quoteSection = null;
	//LINE INFORMATION
		
		Font font = new Font("Arial", Font.BOLD, 100);
		metrics = graphics.getFontMetrics(font);
		int lineInWhichQuoteStarts = quote.lastIndexOf("-");
		
		if(height == 2400){
			centerPositionHeight = 1200;	
		}
		

	//SETTING FONT AND WORD COUNT//
		if(numberOfLines >= 17){
			int fontSize = 100;

			//run until the amoutn of lines gets to 17
			while(linesInQuote >= 17){
				sentenceSplitSize += 5;
				fontSize -= 15;
				linesInQuote = quote.length()/sentenceSplitSize;
			}

			font = new Font("Arial", Font.BOLD, fontSize);
			metrics = graphics.getFontMetrics(font);
			
			nextNumberOfQuote = sentenceSplitSize;
		}
	//SETTING FONT AND WORD COUNT//
			
	//TO BIG TEXT FONT AND NUMBER
		if(lineInWhichQuoteStarts != -1){
			endOfQuote = lineInWhichQuoteStarts - 1;
		}
	//TO BIG TEXT FONT AND NUMBER
			
	//HEIGHT
		int SpacedUsed = (linesInQuote * (metrics.getHeight())) + (linesInQuote * 10);
		int startingSpace = (height - SpacedUsed)/2;
	//HEIGHT
		
		while(done){
					
			//Set final number to equal last number if it surpasses it
			if(nextNumberOfQuote > endOfQuote){
				nextNumberOfQuote = endOfQuote;
			}
					
			
		// FIXING WHITE SPACE //
			//counts teh whitespace in the line
			int whiteSpace = 0;
			for(int i = startOfQuote; i < nextNumberOfQuote; i++){
				if(Character.isWhitespace(quote.charAt(i))){
					whiteSpace = i;
				}		
			}
							
			if(nextNumberOfQuote == (endOfQuote - 1)){
				if(Character.isWhitespace(quote.charAt(nextNumberOfQuote - 1))){
					whiteSpace = 0;
				}
			}else if(nextNumberOfQuote != endOfQuote){
				if(Character.isWhitespace(quote.charAt(nextNumberOfQuote))){
					whiteSpace = 0;
				}
			}
					
			if(nextNumberOfQuote == endOfQuote){
				whiteSpace = 0;
			}
						
			if(whiteSpace != 0){
				nextNumberOfQuote = whiteSpace;
			}
		// FIXING WHITE SPACE //
						
						
			//this will get the section of the quote
			quoteSection = quote.substring(startOfQuote, nextNumberOfQuote);
					
					
		//HEIGHT AND WIDTH//
			centerPositionWidth = (imageWidth - metrics.stringWidth(quoteSection))/2;
		//HEIGHT AND WIDTH//
			

		//HEIGHT AND WIDTH//
			startingSpace += (metrics.getHeight() + 10);
		//HEIGHT AND WIDTH//

		//POSTING IMAGE//
			//add the writing to the image
			graphics.setFont(font);
			graphics.drawString(quoteSection, centerPositionWidth, startingSpace);
		//POSTING IMAGE//
			
				
		//CHECKING FOR DONE//
			//Determines when quote no longer has anything to cut
			if(nextNumberOfQuote == endOfQuote || startOfQuote > endOfQuote){
				break;
			}

			startOfQuote = (nextNumberOfQuote + 1);
			nextNumberOfQuote += sentenceSplitSize;
				
			if(startOfQuote > endOfQuote){
				break;
			}
		//CHECKING FOR DONE//
			
			
		}

	//QUOTE AUTHOR
		if(lineInWhichQuoteStarts != -1){
			endOfQuote = quote.length();
			startOfQuote = lineInWhichQuoteStarts;
			quoteSection = quote.substring(startOfQuote,endOfQuote);
			centerPositionWidth = (imageWidth - metrics.stringWidth(quoteSection))/2;
			startingSpace += (metrics.getHeight() + 10);
			graphics.drawString(quoteSection, centerPositionWidth, startingSpace);
		}
	//QUOTE AUTHOR
		
	//ADD WATERMARK
		Font userNameFont = new Font("Arial", Font.PLAIN, 25);
		graphics.setFont(userNameFont);
		metrics = graphics.getFontMetrics(userNameFont);
		quoteSection = userName;
		centerPositionWidth = (imageWidth - metrics.stringWidth(quoteSection))/2;
		startingSpace += (metrics.getHeight() + 20);
		graphics.drawString(quoteSection, centerPositionWidth, startingSpace);
	//ADD WATERMARK
	}
}

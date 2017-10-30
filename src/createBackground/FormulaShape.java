package createBackground;

import java.awt.image.BufferedImage;

public class FormulaShape {

	/**
	 * create a circle in image
	 * @param bufferedImage the image we will be to make
	 * @param sizeOrientationColor details of image
	 */
	public void createCircle(BufferedImage bufferedImage, int[] sizeOrientationColor){

		//fixed this to have a contrast color for when piced
		int width = sizeOrientationColor[0];
		int height = sizeOrientationColor[1];
		int stroke = sizeOrientationColor[2];
		int radious = sizeOrientationColor[3];
		int orientation = sizeOrientationColor[4];
		
		int a = 250; 
		int r = sizeOrientationColor[5];
		int g = sizeOrientationColor[6];
		int b = sizeOrientationColor[7];
		
		int imageCenterWidth = width/2;
		int imageCenterHeight = height/2;
		boolean done = true;
		int strokeIncrement = 0;
				
		double xCoordinate;
		double yCoordinate;
		
		while(done){
					
			//DRAW TOP AND BOTTOM OF CIRCLE
			for(int y = 0; y < height; y++){
				int p = (a<<24) | (r<<24) | (g<<16) | (b<<8) | b; 
				
				xCoordinate = imageCenterWidth + (Math.sqrt( Math.pow(radious, 2) - Math.pow((y - imageCenterHeight), 2)));
				
				if((int)xCoordinate < width && y < height){
					bufferedImage.setRGB((int)xCoordinate, y, p);
				}
				
				xCoordinate = imageCenterWidth - (Math.sqrt( Math.pow(radious, 2) - Math.pow((y - imageCenterHeight), 2)));
				if((int)xCoordinate < width && y < height){
					bufferedImage.setRGB((int)xCoordinate, y, p);
				}
			}
			//DRAW TOP AND BOTTOM OF CIRCLE
			
			//DRAW SIDE OF CIRCLE
			for(int x = 0; x < width; x++){
				int p = (a<<24) | (r<<24) | (g<<16) | (b<<8) | b; 
				
				yCoordinate = imageCenterHeight + (Math.sqrt( Math.pow(radious, 2) - Math.pow((x - imageCenterWidth), 2)));
				if(x < width && (int)yCoordinate < height){
					bufferedImage.setRGB(x, (int)yCoordinate, p);
				}
						
				yCoordinate = imageCenterHeight - (Math.sqrt( Math.pow(radious, 2) - Math.pow((x - imageCenterWidth), 2)));
				if(x < width && (int)yCoordinate < height){
					bufferedImage.setRGB(x, (int)yCoordinate, p);
				}
			}
			//DRAW SIDE OF CIRCLE
			
			if(stroke < strokeIncrement){
				done = false;
			}
			radious += 1;
			strokeIncrement++;
		}
	}
	
	/**
	 * creates a square in image
	 * @param bufferedImage the image we will be to make
	 * @param sizeOrientationColor details of image
	 */
	public void createTriangle(BufferedImage bufferedImage, int[] sizeOrientationColor){
		
		//fixed this to have a contrast color for when piced
		int width = sizeOrientationColor[0];
		int height = sizeOrientationColor[1];
		int stroke = sizeOrientationColor[2];
		int radious = sizeOrientationColor[3];
		int orientation = sizeOrientationColor[4];
						
		int a = 250; 
		int r = sizeOrientationColor[5];
		int g = sizeOrientationColor[6];
		int b = sizeOrientationColor[7];
						
		
		int imageCenterWidth = width/2;
		int imageCenterHeight = height/2;
		int strokeIncrement = 0;

		int xPointOne = (imageCenterWidth + radious);
		int xPointTwo = (imageCenterWidth - radious);
		
		int yPointOne = imageCenterHeight + (radious/2);
		int radiousChange = 0;
		
		int p = (a<<24) | (r<<24) | (g<<16) | (b<<8) | b; 
		
	//creates sides of triangle
		do{
		
		//draws on image
			do{
				if(xPointOne < width && yPointOne < height){
					bufferedImage.setRGB(xPointOne, yPointOne, p);
				}
				if(xPointTwo < width && yPointOne < height){
					bufferedImage.setRGB(xPointTwo, yPointOne, p);
				}
				
				xPointOne--;
				xPointTwo++;
				yPointOne--;
				
			}while(xPointOne >= xPointTwo);
		//draws on image
		
			radiousChange++;
			xPointOne = (imageCenterWidth + (radious - radiousChange));
			xPointTwo = (imageCenterWidth - (radious - radiousChange));
			yPointOne = imageCenterHeight + (radious/2);
			
			stroke--;
		}while(stroke > strokeIncrement);
	//creates sides of triangle
		
		
	//creatingBottomLine
		stroke = sizeOrientationColor[2];
		radious = sizeOrientationColor[3];
		xPointOne = (imageCenterWidth + radious);
		xPointTwo = (imageCenterWidth - radious);
		yPointOne = imageCenterHeight + (radious/2);
		radiousChange = 0;
		
		do{
			while(xPointTwo != xPointOne){
				xPointTwo++;

				if(xPointTwo < width && yPointOne < height){
					bufferedImage.setRGB(xPointTwo, yPointOne, p);
				}
			}
			yPointOne--;
			radiousChange++;
			xPointTwo = (imageCenterWidth - (radious - radiousChange));
			xPointOne = (imageCenterWidth + (radious - radiousChange));
			stroke--;
		}while(stroke > strokeIncrement);
	//creatingBottomLine
	}
	
	/**
	 * creates a square
	 * @param bufferedImage the image we will be to make
	 * @param sizeOrientationColor details of image
	 */
	public void createSquare(BufferedImage bufferedImage, int[] sizeOrientationColor){
		
		//fixed this to have a contrast color for when piced
		int width = sizeOrientationColor[0];
		int height = sizeOrientationColor[1];
		int stroke = sizeOrientationColor[2];
		int radious = sizeOrientationColor[3];
		int orientation = sizeOrientationColor[4];
				
		int a = 250; 
		int r = sizeOrientationColor[5];
		int g = sizeOrientationColor[6];
		int b = sizeOrientationColor[7];
		
				
		int imageCenterWidth = width/2;
		int imageCenterHeight = height/2;
		int strokeIncrement = 0;

		int xPointOne = (imageCenterWidth - radious);
		int xPointTwo = (imageCenterWidth + radious);

		int xPointDone = (imageCenterWidth + radious);
		int xPointDoneTwo = (imageCenterWidth - radious);
		
		int yPointOne = (imageCenterHeight - radious);
		int yPointTwo = (imageCenterHeight + radious);
		
		int yPointDone = (imageCenterHeight + radious);
		int yPointDoneTwo = (imageCenterHeight - radious);
		
		int radiousChange = 0;

	//creates top and bottom of square
		do{
			
		//draws on image
			do{
				int p = (a<<24) | (r<<24) | (g<<16) | (b<<8) | b; 
						
				if(xPointOne != xPointDone){
					if(xPointOne < width && yPointOne < height){
						bufferedImage.setRGB(xPointOne, yPointOne, p);
					}
				}
				xPointOne++;
				
				if(xPointTwo != xPointDoneTwo){
					if(xPointTwo < width && yPointTwo < height){
						bufferedImage.setRGB(xPointTwo, yPointTwo, p);
					}
				}
				xPointTwo--;
				
			}while(xPointOne != xPointDone);
		//draws on image

			radiousChange++;
			xPointOne = ((width/2) - radious);
			xPointTwo = ((width/2) + radious);

			yPointOne = ((height/2) - (radious - radiousChange));
			yPointTwo = ((height/2) + (radious - radiousChange));
			
			stroke--;
			
		}while(stroke > strokeIncrement);
	//creates top and bottom of square
		

	//creates sides of square
		stroke = sizeOrientationColor[2];
		radiousChange = 0;
		
		do{
			
		//draws on image
			do{
				int p = (a<<24) | (r<<24) | (g<<16) | (b<<8) | b; 
						
				if(yPointOne != yPointDone){
					if(xPointOne < width && yPointOne < height){
						bufferedImage.setRGB(xPointOne, yPointOne, p);
					}
				}
				yPointOne++;
				
				if(yPointTwo != yPointDoneTwo){
					if(xPointTwo < width && yPointTwo < height){
						bufferedImage.setRGB(xPointTwo, yPointTwo, p);
					}
				}
				yPointTwo--;
			}while(yPointOne != yPointDone);
		//draws on image
			
			radiousChange--;
			xPointOne = ((width/2) - (radious - radiousChange));
			xPointTwo = ((width/2) + (radious - radiousChange));
			
			yPointOne = ((height/2) - radious);
			yPointTwo = ((height/2) + radious);
		
			stroke--;
		}while(stroke > strokeIncrement);
	//creates sides of square
		
	}
}	

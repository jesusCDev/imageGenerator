package createBackground;

import java.awt.image.BufferedImage;
import java.util.Random;

public class CreateBackground {

	private String shapeCircle = "circle";
	private String shapeSquare = "square";
	private String shapeTriangle = "triangle";
	private String colorGrey = "grey";
	private String colorWhite = "white";
	/**
	 * this colors the background of the image
	 * @param height takes height of image
	 * @param width takes in width of image
	 * @param bufferedImage takes in image being buffered
	 * @return returns the font color we need to color the text so it wont match the background
	 */
	public String colorBackgroundGradient(int height, int width, BufferedImage bufferedImage){
		
		// The number limit is 250
		int grantedRatio = (height/250) + 1;
				
		
	//CHOSE COLOR
		int a = 250; //alpha
		int r = new Random().nextInt(255) + 1; //red
		int g = new Random().nextInt(255) + 1; //green
		int b = new Random().nextInt(255) + 1; //blue
				
		int newR = 0;
		int newG = 0;
		int newB = 0;
				
		while(newR < r || newG < g || newB < b){
			newR = new Random().nextInt(255) + 1; //red
			newG = new Random().nextInt(255) + 1; //green
			newB = new Random().nextInt(255) + 1; //blue
		}
	//CHOSE COLOR
		
		int incrementedThroughColor = 1;
		
		
	//CH9OSE COLOR INCREMENTS
		int topNumberR = r - newR;
		int topNumberG = g - newG;
		int topNumberB = b - newB;
		int numberClosestToZero = 0;
				
		if((topNumberR < topNumberG) && (topNumberR < topNumberB)){
			numberClosestToZero = topNumberR;
		}else if((topNumberG < topNumberR) && (topNumberG < topNumberB)){
			numberClosestToZero = topNumberG;
		}else{
			numberClosestToZero = topNumberB;
		}
				
		for(int i = 0; i < numberClosestToZero ; i++){
			//incrementedThroughColor += 1;
			grantedRatio  += 5;
		}
	//CHOSE COLOR INCREMENTS
		
		//chose gradient
		int choseGradient = new Random().nextInt(2) + 1;
			
		if(choseGradient == 1){
				
				
		//DOWN GRADIENT
			int ratioTracker = 0;
			for(int y = 0; y < height; y++){
				for(int x = 0; x < width; x++){
					
					int p = (a<<24) | (r<<24) | (g<<16) | (b<<8) | b; //pixel
						
					bufferedImage.setRGB(x, y, p);
				}
				ratioTracker++;
				if(ratioTracker == grantedRatio){
					if(r < newR){
						r += incrementedThroughColor;
					}
					if(g < newG){
						g += incrementedThroughColor;
					}
					if(b < newB){
						b += incrementedThroughColor;
					}
					ratioTracker = 0;
				}
			}
		//DOWN GRADIENT
				

		}else{
				
				
		//UP GRADIENT
			int ratioTracker = 0;
			for(int y = (height - 1); y > 0; y--){
				for(int x = (width - 1); x > 0; x--){
						
					int p = (a<<24) | (r<<24) | (g<<16) | (b<<8) | b; //pixel
						
					bufferedImage.setRGB(x, y, p);
				}
				ratioTracker++;
				if(ratioTracker == grantedRatio){
					if(r < newR){
						r += incrementedThroughColor;
					}
					if(g < newG){
						g += incrementedThroughColor;
					}
					if(b < newB){
						b += incrementedThroughColor;
					}
					ratioTracker = 0;
				}
			}
		//UP GRADIENT
				
				
		}
	
		
	//CHOSE TEXT COLOR
		String textFontColor;
		
		if((r > 240) || (g > 240) || (b > 240)){
			textFontColor = colorGrey;
		}else{
			textFontColor = colorWhite;
		}
		
		if((newR > 240) || (newG > 240) || (newB > 240)){
			textFontColor = colorGrey;
		}else{
			textFontColor = colorWhite;
		}
	//CHOSE TEXT COLOR
		
		
		return textFontColor;
	}

	
//CREATE Small SHAPE
	public String choseShape() {
		
		String shape;
		int choseShape = new Random().nextInt(6) + 1;
		
		if(choseShape == 1){
			shape = shapeTriangle;
		}else if(choseShape == 2){
			shape = shapeSquare;
		}else if(choseShape == 3){
			shape = "pentagron";
		}else if(choseShape == 4){
			shape = "hexagon";
		}else if(choseShape == 5){
			shape = "heptagon";
		}else{
			shape = "octogon";
		}
		
		return shape;
	}
	
	public int[] createShapeDescriptions() {
		
		//size of shape, orientation of shape, color of shape
		int[] sizeOrientationColor = new int[5];
		
		Random number = new Random();
		
		int size = number.nextInt(5) + 1;
		int orientation = number.nextInt(36) + 1;
		int r = number.nextInt(250) + 1;
		int g = number.nextInt(250) + 1;
		int b = number.nextInt(250) + 1;
		
		sizeOrientationColor[0] = size;
		//percentage * 36
		sizeOrientationColor [1] = (orientation * 10);
		
		sizeOrientationColor[2] = r;
		sizeOrientationColor[3] = g;
		sizeOrientationColor[4] = b;
		
		return sizeOrientationColor;
	}

	public void createShape(String shape, int[] createShapeDescription){
		
		//chose which shape will be made for pattern
		if(shape.equals(shapeCircle)){
			
		}else if(shape.equals(shapeTriangle)){
			
		}else if(shape.equals(shapeSquare)){
			
		}else if(shape.equals("pentagron")){
			
		}else if(shape.equals("hexagon")){
			
		}else if(shape.equals("heptagon")){
			
		}else{
			
		}
	}
	public void createPattern() {

		
	//CREATE GRADIENT
		
	//CREATE GRADIENT
	
	
	}
//CREATE Small SHAPE
	

//CREATE MAINSHAPE
	
	/**
	 * Chose which shape will be made for the mian image
	 * @return returns the shape that was picked randomly
	 */
	public String choseMainShape() {
		String shape;
		int choseShape = new Random().nextInt(3) + 1;
		
		if(choseShape == 1){
			shape = shapeCircle;
		}else if(choseShape == 2){
			shape = shapeTriangle;
		}else if(choseShape == 3){
			shape = shapeSquare;
		}
		//these are for later on - when i have more time
		else if(choseShape == 4){
			shape = "pentagron";
		}else if(choseShape == 5){
			shape = "hexagon";
		}else if(choseShape == 6){
			shape = "heptagon";
		}else{
			shape = "octogon";
		}
		
		return shape;
	}
	
	/**
	 * thie cretes the value of the mian shape
	 * @param mineShape
	 * @param letterColor
	 * @param height
	 * @param width
	 * @return retuns the description of the shape in an array
	 */
	public int[] createMainShapeDescription(String mineShape, String letterColor, int height, int width) {
		
		Random number = new Random();
		
		//imageWidth, imageHeight, stroke, raidus, orientation, color(r,g,b)
		int[] sizeOrientationColor = new int[8];
		
		//imageWidth
		sizeOrientationColor[0] =	width;
		
		//imageHeight
		sizeOrientationColor[1] = height;
		
		//stroke
		sizeOrientationColor[2] = number.nextInt(50);
		//raidus 
		int margin = 40;
		int raidus = number.nextInt((((width/2) - margin) - 500)) + 500;
		sizeOrientationColor[3]  = raidus ;
		
		//orientation		
		int orientation = number.nextInt(36) + 1;
		//percentage * 36
		sizeOrientationColor [4] = (orientation * 10);
		
		int r;
		int g;
		int b;
		
		if(letterColor.equals(colorGrey)){
			do{
				r = number.nextInt(250) + 1;
				g = number.nextInt(250) + 1;
				b = number.nextInt(250) + 1;
			}while(r < 230 || g < 230 || b < 230);
		}else{
			do{
				r = number.nextInt(250) + 1;
				g = number.nextInt(250) + 1;
				b = number.nextInt(250) + 1;
			}while(r > 230 || g > 230 || b > 230);
		}
		
		//color(a)
		sizeOrientationColor[5] = r;
		
		//color(g)
		sizeOrientationColor[6] = g;
		
		//color(b)
		sizeOrientationColor[7] = b;
				
		return sizeOrientationColor;
	}

	/**
	 * runs the formula to draw the shape
	 * @param bufferedImage image that will be drawn on
	 * @param mainShape shape we are making
	 * @param sizeOrientationColor description of shape that is being made
	 */
	public void createMainShape(BufferedImage bufferedImage, String mainShape, int[] sizeOrientationColor) {
		
		//chose 3 points of a circle and connect the dots using a formula for slope
		FormulaShape shapeMaker = new FormulaShape();
		if(mainShape.equals(shapeCircle)){
			
			shapeMaker.createCircle(bufferedImage, sizeOrientationColor);
			
		}else if(mainShape.equals(shapeTriangle)){
			
			shapeMaker.createTriangle(bufferedImage, sizeOrientationColor);
			
		}else if(mainShape.equals(shapeSquare)){
			
			shapeMaker.createSquare(bufferedImage, sizeOrientationColor);
			
		}else if(mainShape.equals("pentagron")){

		}else if(mainShape.equals("hexagon")){

		}else if(mainShape.equals("heptagon")){

		}else{

		}
	}
//CREATE MAINSHAPE
	
}

package ro.src.housecosumption;

public class House {

	private double sizeOfFirstWall;
	private double sizeOfSecondWall;
	private double sizeOfThirdWall;
	private double areaForRoundRoom;
	private double areaForSquareRoom;
	private double areaForTriangleRoom;
	
	
	public House(double sizeOfFirstWall){
		this.sizeOfFirstWall = sizeOfFirstWall;
	}
	
	public House(double sizeOfFirstWall, double sizeOfSecondWall){
		this.sizeOfFirstWall = sizeOfFirstWall;
		this.sizeOfSecondWall = sizeOfSecondWall;	
	}
	public House(double sizeOfFirstWall, double sizeOfSecondWall, double sizeOfThirdWall){
		this.sizeOfFirstWall = sizeOfFirstWall;
		this.sizeOfSecondWall = sizeOfSecondWall;	
		this.sizeOfThirdWall = sizeOfThirdWall;
	}

	public double calculateAreaForRoundRoom(){
		areaForRoundRoom = Math.PI * Math.pow(sizeOfFirstWall, 2);
		return areaForRoundRoom;
	}
	public double calculateAreaForSquareRoom(){
		areaForSquareRoom = sizeOfFirstWall * sizeOfSecondWall;
		return areaForSquareRoom;
	}
	public double calculateAreaForTriangleRoom(){
		double perimeter = sizeOfFirstWall + sizeOfSecondWall + sizeOfThirdWall;
		double semiPerimeter = perimeter / 2;
		areaForTriangleRoom = Math.sqrt((semiPerimeter * (semiPerimeter - sizeOfFirstWall) * (semiPerimeter - sizeOfSecondWall) * (semiPerimeter - sizeOfThirdWall)));
		return areaForTriangleRoom;
	}
	
}

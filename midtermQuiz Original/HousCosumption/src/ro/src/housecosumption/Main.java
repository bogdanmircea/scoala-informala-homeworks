package ro.src.housecosumption;

public class Main {

	public static void main(String[] args) {

		House house = new House(5d);
		House oneRoomHouse = new House(2d, 2d);
		House twoRoomHouse = new House(10d, 10d, 10d);

		house.calculateAreaForRoundRoom();
		oneRoomHouse.calculateAreaForSquareRoom();
		twoRoomHouse.calculateAreaForTriangleRoom();

		Calculator calculator = new Calculator(house.calculateAreaForRoundRoom(), 33d);
		calculator.calculateWattageForRoom(house.calculateAreaForRoundRoom(), 33d);

		Calculator calculatorForSqureRoom = new Calculator(house.calculateAreaForSquareRoom(), 33d);
		calculatorForSqureRoom.calculateWattageForRoom(oneRoomHouse.calculateAreaForSquareRoom(), 33d);

		Calculator calculatorTriangleRoom = new Calculator(house.calculateAreaForTriangleRoom(), 33d);
		calculatorTriangleRoom.calculateWattageForRoom(twoRoomHouse.calculateAreaForTriangleRoom(), 33d);

		double totalAreaOfTheHouse = house.calculateAreaForRoundRoom() + oneRoomHouse.calculateAreaForSquareRoom()
				+ twoRoomHouse.calculateAreaForTriangleRoom();

		System.out.println("The round room area is : " + house.calculateAreaForRoundRoom() + " and the consumption is: "
				+ calculator.calculateWattageForRoom(house.calculateAreaForRoundRoom(), 33d));
		System.out.println("The square/rectangular room area is: " + oneRoomHouse.calculateAreaForSquareRoom() + " and the consumption is: "
				+ calculator.calculateWattageForRoom(oneRoomHouse.calculateAreaForSquareRoom(), 33d));
		System.out.println("The triangle room area is: " + twoRoomHouse.calculateAreaForTriangleRoom() + " and the consumption is: "
				+ calculator.calculateWattageForRoom(twoRoomHouse.calculateAreaForTriangleRoom(), 33d));

		System.out.println("The total consumpion is: " + totalAreaOfTheHouse * 33);

	}

}

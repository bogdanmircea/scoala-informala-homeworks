package houseconsumtpionapplicationtest;

import static org.junit.Assert.*;

import org.junit.Test;

import ro.sit.houseconsumptionapplication.House;
import ro.sit.houseconsumptionapplication.RectangleRoom;
import ro.sit.houseconsumptionapplication.Room;
import ro.sit.houseconsumptionapplication.RoundRoom;
import ro.sit.houseconsumptionapplication.SquareRoom;

public class HouseConsumptionTest {

	@Test
	public void areaCalculationTest() {

		Room squareRoom = new SquareRoom(10d);
		Room rectangleRoom = new RectangleRoom(10d, 10d);
		Room roundRoom = new RoundRoom(10d);

		House myHouse = new House();

		myHouse.add(squareRoom);
		myHouse.add(rectangleRoom);
		myHouse.add(roundRoom);

		assertEquals(100, squareRoom.calculateArea(), 1);
		assertEquals(100, rectangleRoom.calculateArea(), 1);
		assertEquals(314, roundRoom.calculateArea(), 1);

		assertEquals(16967, myHouse.calculateHouseConsumption(), 1);
	}

}

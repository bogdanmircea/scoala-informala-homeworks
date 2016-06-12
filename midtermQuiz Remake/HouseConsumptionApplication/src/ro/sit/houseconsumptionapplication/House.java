package ro.sit.houseconsumptionapplication;

import java.util.ArrayList;
import java.util.List;

public class House {
	protected double area;
	protected double totalArea;

	List<Room> house = new ArrayList<Room>();

	public void add(Room room) {
		house.add(room);
	}

	public double calculateHouseConsumption() {
		for (Room room : house) {
			area = room.calculateArea();
			totalArea = totalArea + area;
		}
		return totalArea * 33;
	}

}


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ro.src.housecosumption.Calculator;
import ro.src.housecosumption.House;

public class consumptionTest {

	@Test
	public void calcuateArea() {
		House roundHouse = new House(5d);
		assertThat(roundHouse, instanceOf(House.class));
		assertEquals(78, roundHouse.calculateAreaForRoundRoom(), 1);
		Calculator calculator = new Calculator(roundHouse.calculateAreaForRoundRoom(), 33d);
		assertEquals(2591, calculator.calculateWattageForRoom(roundHouse.calculateAreaForRoundRoom(), 33d), 1);

	}

	@Test
	public void calcuateAreaSquareRoom() {
		House squareHouse = new House(2d, 2d);
		assertThat(squareHouse, instanceOf(House.class));
		assertEquals(4, squareHouse.calculateAreaForSquareRoom(), 0);
		Calculator calculator = new Calculator(squareHouse.calculateAreaForSquareRoom(), 33d);
		assertEquals(132, calculator.calculateWattageForRoom(squareHouse.calculateAreaForSquareRoom(), 33d), 1);

	}

	@Test
	public void calcuateAreaTriangle() {
		House triangleHouse = new House(10d, 10d, 10d);
		assertThat(triangleHouse, instanceOf(House.class));
		assertEquals(43, triangleHouse.calculateAreaForTriangleRoom(), 1);
		Calculator calculator = new Calculator(triangleHouse.calculateAreaForTriangleRoom(), 33d);
		assertEquals(1428, calculator.calculateWattageForRoom(triangleHouse.calculateAreaForTriangleRoom(), 33d), 1);
	}

}

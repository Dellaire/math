package de.bearishcode.math.vector;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VectorEquationTest
{
	@Test
	public void createVectorEquation()
	{
		double[] startPoint = { 2.0, 4.0 };
		double[] endPoint = { 3.0, 6.0 };

		VectorEquation vectorEquation = new VectorEquation(startPoint, endPoint);

		assertThat(vectorEquation.getStartPoint()[0], is(2.0));
		assertThat(vectorEquation.getStartPoint()[1], is(4.0));
		assertThat(vectorEquation.getDirection()[0], is(1.0));
		assertThat(vectorEquation.getDirection()[1], is(2.0));
	}

	@Test
	public void calculateSimpleIntersection()
	{
		double[] startPoint1 = { 0.0, 0.0 };
		double[] endPoint1 = { 1.0, 1.0 };
		double[] startPoint2 = { 2.0, 0.0 };
		double[] endPoint2 = { 5.0, 1.0 };

		VectorEquation vectorEquation1 = new VectorEquation(startPoint1, endPoint1);
		VectorEquation vectorEquation2 = new VectorEquation(startPoint2, endPoint2);
		double[] intersection = vectorEquation1.calculateIntersection(vectorEquation2);

		assertThat(intersection[0], is(-1.0));
		assertThat(intersection[1], is(-1.0));
	}

	@Test
	public void calculateHardIntersection()
	{
		double[] startPoint1 = { -280.407, 218.915 };
		double[] endPoint1 = { -309.527, 219.272 };
		double[] startPoint2 = { -403.049, 725.470 };
		double[] endPoint2 = { -437.636, 716.125 };

		VectorEquation vectorEquation1 = new VectorEquation(startPoint1, endPoint1);
		VectorEquation vectorEquation2 = new VectorEquation(startPoint2, endPoint2);
		double[] intersection = vectorEquation1.calculateIntersection(vectorEquation2);

		assertThat(intersection[0], is(-2191.1719422771926));
		assertThat(intersection[1], is(237.37164239144636));
	}
}

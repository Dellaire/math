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
}

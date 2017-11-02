package de.bearishcode.math.sle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import de.bearishcode.math.vector.VectorEquation;

public class SystemOfLinearEquationTest
{
	@Test
	public void createFromVectorEquations()
	{
		double[] startPoint1 = { 2.0, 4.0 };
		double[] startPoint2 = { 8.0, 7.0 };
		double[] endPoint1 = { 3.0, 6.0 };
		double[] endPoint2 = { 3.0, 6.0 };

		VectorEquation vectorEquation1 = new VectorEquation(startPoint1, endPoint1);
		VectorEquation vectorEquation2 = new VectorEquation(startPoint2, endPoint2);

		SystemOfLinearEquations systemOfLinearEquations = new SystemOfLinearEquations(vectorEquation1, vectorEquation2);

		assertThat(systemOfLinearEquations.getElement(0, 0), is(1.0));
		assertThat(systemOfLinearEquations.getElement(0, 1), is(5.0));
		assertThat(systemOfLinearEquations.getElement(0, 2), is(6.0));
		assertThat(systemOfLinearEquations.getElement(1, 0), is(2.0));
		assertThat(systemOfLinearEquations.getElement(1, 1), is(1.0));
		assertThat(systemOfLinearEquations.getElement(1, 2), is(3.0));
	}

	@Test
	public void solve()
	{
		double[] startPoint1 = { 2.0, 4.0 };
		double[] startPoint2 = { 8.0, 7.0 };
		double[] endPoint1 = { 3.0, 6.0 };
		double[] endPoint2 = { 3.0, 6.0 };

		VectorEquation vectorEquation1 = new VectorEquation(startPoint1, endPoint1);
		VectorEquation vectorEquation2 = new VectorEquation(startPoint2, endPoint2);

		SystemOfLinearEquations systemOfLinearEquations = new SystemOfLinearEquations(vectorEquation1, vectorEquation2);
		double[] solutionVector = systemOfLinearEquations.solve();

		assertThat(solutionVector[0], is(1.0));
		assertThat(solutionVector[1], is(1.0));
	}
}

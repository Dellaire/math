package de.bearishcode.math.sle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

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
	public void solveSimpleExample()
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

	@Test
	public void solveHardExample()
	{
		List<List<Double>> matrix = Arrays.asList(Arrays.asList(10.235, -4.56, 0.0, -0.035, 5.87, 8.95),
				Arrays.asList(-2.463, 11.27, 3.97, -8.63, -1.08, 20.54),
				Arrays.asList(-6.58, 2.86, -0.257, 8.32, -43.6, 7.42),
				Arrays.asList(9.83, 7.39, -17.25, 0.036, 2.486, 5.6),
				Arrays.asList(-19.31, 3.49, 78.56, 10.07, 65.8, 58.43));

		SystemOfLinearEquations systemOfLinearEquations = new SystemOfLinearEquations(matrix);
		double[] solutionVector = systemOfLinearEquations.solve();

		assertThat(solutionVector[0], is(1.8301150381052356));
		assertThat(solutionVector[1], is(1.7072701230456002));
		assertThat(solutionVector[2], is(1.4007023010362007));
		assertThat(solutionVector[3], is(0.014056695380717486));
		assertThat(solutionVector[4], is(-0.33996314643625614));
	}
}

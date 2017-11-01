package de.bearishcode.math.matrix;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MatrixTest
{
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void exceptionInCaseOfUnequalRowSize()
	{
		this.exception.expect(RuntimeException.class);
		this.exception.expectMessage("The rows of the specified matrix have different legths.");

		new Matrix(Arrays.asList(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(-1.0, -2.0)));
	}

	@Test
	public void copyDoesNotAffectOldData()
	{
		Matrix matrix1 = new Matrix(Arrays.asList(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(1.0, 1.0, 1.0)));
		Matrix matrix2 = matrix1.copy();

		matrix2.reduceToRForm();

		assertThat(matrix1.get(1, 0), is(1.0));
		assertThat(matrix2.get(1, 0), is(0.0));

	}

	@Test
	public void swapRows()
	{
		Matrix matrix = new Matrix(Arrays.asList(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(-1.0, -2.0, -3.0)));

		matrix.swapRows(0, 1);

		assertThat(matrix.get(0, 0), is(-1.0));
		assertThat(matrix.get(0, 1), is(-2.0));
		assertThat(matrix.get(0, 2), is(-3.0));

		assertThat(matrix.get(1, 0), is(1.0));
		assertThat(matrix.get(1, 1), is(2.0));
		assertThat(matrix.get(1, 2), is(3.0));
	}

	@Test
	public void multiplyRow()
	{
		Matrix matrix = new Matrix(Arrays.asList(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(2.0, 3.0, 4.0)));

		matrix.multiplyRow(-1.0, 0);

		assertThat(matrix.get(0, 0), is(-1.0));
		assertThat(matrix.get(0, 1), is(-2.0));
		assertThat(matrix.get(0, 2), is(-3.0));
	}

	@Test
	public void multiplyAndAddRow()
	{
		Matrix matrix = new Matrix(Arrays.asList(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(2.0, 3.0, 4.0)));

		matrix.multiplyAndAddRow(-1.0, 0, 1);

		assertThat(matrix.get(1, 0), is(1.0));
		assertThat(matrix.get(1, 1), is(1.0));
		assertThat(matrix.get(1, 2), is(1.0));
	}

	@Test
	public void reduceColumnForward()
	{
		Matrix matrix = new Matrix(Arrays.asList(Arrays.asList(1.0, 2.0, 3.0, 4.0), Arrays.asList(0.0, 2.0, 3.0, 4.0),
				Arrays.asList(0.0, 2.0, 4.0, 5.0), Arrays.asList(0.0, 2.0, 4.0, 5.0)));

		matrix.reduceColumnForward(1);

		assertThat(matrix.get(0, 0), is(1.0));
		assertThat(matrix.get(0, 1), is(2.0));
		assertThat(matrix.get(0, 2), is(3.0));
		assertThat(matrix.get(0, 3), is(4.0));

		assertThat(matrix.get(1, 0), is(0.0));
		assertThat(matrix.get(1, 1), is(2.0));
		assertThat(matrix.get(1, 2), is(3.0));
		assertThat(matrix.get(1, 3), is(4.0));

		assertThat(matrix.get(2, 0), is(0.0));
		assertThat(matrix.get(2, 1), is(0.0));
		assertThat(matrix.get(2, 2), is(1.0));
		assertThat(matrix.get(2, 3), is(1.0));

		assertThat(matrix.get(3, 0), is(0.0));
		assertThat(matrix.get(3, 1), is(0.0));
		assertThat(matrix.get(3, 2), is(1.0));
		assertThat(matrix.get(3, 3), is(1.0));
	}

	@Test
	public void reduceColumnBackward()
	{
		Matrix matrix = new Matrix(Arrays.asList(Arrays.asList(5.0, 4.0, 2.0, 0.0), Arrays.asList(5.0, 4.0, 2.0, 0.0),
				Arrays.asList(4.0, 3.0, 2.0, 0.0), Arrays.asList(5.0, 4.0, 3.0, 0.0)));

		matrix.reduceColumnBackward(2);

		assertThat(matrix.get(0, 0), is(1.0));
		assertThat(matrix.get(0, 1), is(1.0));
		assertThat(matrix.get(0, 2), is(0.0));
		assertThat(matrix.get(0, 3), is(0.0));

		assertThat(matrix.get(1, 0), is(1.0));
		assertThat(matrix.get(1, 1), is(1.0));
		assertThat(matrix.get(1, 2), is(0.0));
		assertThat(matrix.get(1, 3), is(0.0));

		assertThat(matrix.get(2, 0), is(4.0));
		assertThat(matrix.get(2, 1), is(3.0));
		assertThat(matrix.get(2, 2), is(2.0));
		assertThat(matrix.get(2, 3), is(0.0));

		assertThat(matrix.get(3, 0), is(5.0));
		assertThat(matrix.get(3, 1), is(4.0));
		assertThat(matrix.get(3, 2), is(3.0));
		assertThat(matrix.get(3, 3), is(0.0));
	}

	@Test
	public void reduceToRForm()
	{
		Matrix matrix = new Matrix(
				Arrays.asList(Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0), Arrays.asList(1.0, 2.0, 2.0, 2.0, 2.0),
						Arrays.asList(1.0, 2.0, 3.0, 3.0, 3.0), Arrays.asList(1.0, 2.0, 3.0, 4.0, 4.0)));

		matrix.reduceToRForm();

		assertThat(matrix.get(0, 0), is(1.0));
		assertThat(matrix.get(0, 1), is(1.0));
		assertThat(matrix.get(0, 2), is(1.0));
		assertThat(matrix.get(0, 3), is(1.0));
		assertThat(matrix.get(0, 4), is(1.0));

		assertThat(matrix.get(1, 0), is(0.0));
		assertThat(matrix.get(1, 1), is(1.0));
		assertThat(matrix.get(1, 2), is(1.0));
		assertThat(matrix.get(1, 3), is(1.0));
		assertThat(matrix.get(1, 4), is(1.0));

		assertThat(matrix.get(2, 0), is(0.0));
		assertThat(matrix.get(2, 1), is(0.0));
		assertThat(matrix.get(2, 2), is(1.0));
		assertThat(matrix.get(2, 3), is(1.0));
		assertThat(matrix.get(2, 4), is(1.0));

		assertThat(matrix.get(3, 0), is(0.0));
		assertThat(matrix.get(3, 1), is(0.0));
		assertThat(matrix.get(3, 2), is(0.0));
		assertThat(matrix.get(3, 3), is(1.0));
		assertThat(matrix.get(3, 4), is(1.0));
	}

	@Test
	public void reduceToLeftRForm()
	{
		Matrix matrix = new Matrix(
				Arrays.asList(Arrays.asList(4.0, 3.0, 2.0, 1.0, 4.0), Arrays.asList(3.0, 3.0, 2.0, 1.0, 3.0),
						Arrays.asList(2.0, 2.0, 2.0, 1.0, 2.0), Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0)));

		matrix.reduceToLeftRForm();

		assertThat(matrix.get(0, 0), is(1.0));
		assertThat(matrix.get(0, 1), is(0.0));
		assertThat(matrix.get(0, 2), is(0.0));
		assertThat(matrix.get(0, 3), is(0.0));
		assertThat(matrix.get(0, 4), is(1.0));

		assertThat(matrix.get(1, 0), is(1.0));
		assertThat(matrix.get(1, 1), is(1.0));
		assertThat(matrix.get(1, 2), is(0.0));
		assertThat(matrix.get(1, 3), is(0.0));
		assertThat(matrix.get(1, 4), is(1.0));

		assertThat(matrix.get(2, 0), is(1.0));
		assertThat(matrix.get(2, 1), is(1.0));
		assertThat(matrix.get(2, 2), is(1.0));
		assertThat(matrix.get(2, 3), is(0.0));
		assertThat(matrix.get(2, 4), is(1.0));

		assertThat(matrix.get(3, 0), is(1.0));
		assertThat(matrix.get(3, 1), is(1.0));
		assertThat(matrix.get(3, 2), is(1.0));
		assertThat(matrix.get(3, 3), is(1.0));
		assertThat(matrix.get(3, 4), is(1.0));
	}

	@Test
	public void reduceToDForm()
	{
		Matrix matrix = new Matrix(
				Arrays.asList(Arrays.asList(1.0, 1.0, 1.0, 1.0, 4.0), Arrays.asList(1.0, 2.0, 2.0, 2.0, 7.0),
						Arrays.asList(1.0, 2.0, 3.0, 3.0, 9.0), Arrays.asList(1.0, 2.0, 3.0, 4.0, 10.0)));

		matrix.reduceToDForm();

		assertThat(matrix.get(0, 0), is(1.0));
		assertThat(matrix.get(0, 1), is(0.0));
		assertThat(matrix.get(0, 2), is(0.0));
		assertThat(matrix.get(0, 3), is(0.0));
		assertThat(matrix.get(0, 4), is(1.0));

		assertThat(matrix.get(1, 0), is(0.0));
		assertThat(matrix.get(1, 1), is(1.0));
		assertThat(matrix.get(1, 2), is(0.0));
		assertThat(matrix.get(1, 3), is(0.0));
		assertThat(matrix.get(1, 4), is(1.0));

		assertThat(matrix.get(2, 0), is(0.0));
		assertThat(matrix.get(2, 1), is(0.0));
		assertThat(matrix.get(2, 2), is(1.0));
		assertThat(matrix.get(2, 3), is(0.0));
		assertThat(matrix.get(2, 4), is(1.0));

		assertThat(matrix.get(3, 0), is(0.0));
		assertThat(matrix.get(3, 1), is(0.0));
		assertThat(matrix.get(3, 2), is(0.0));
		assertThat(matrix.get(3, 3), is(1.0));
		assertThat(matrix.get(3, 4), is(1.0));
	}
}

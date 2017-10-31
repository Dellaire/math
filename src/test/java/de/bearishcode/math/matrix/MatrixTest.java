package de.bearishcode.math.matrix;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class MatrixTest
{
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
	public void multiplyAndAddLine()
	{
		Matrix matrix = new Matrix(Arrays.asList(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(1.0, 2.0, 3.0)));

		matrix.multiplyAndAddLine(-1.0, 0, 1);

		assertThat(matrix.get(1, 0), is(0.0));
		assertThat(matrix.get(1, 1), is(0.0));
		assertThat(matrix.get(1, 2), is(0.0));
	}
}

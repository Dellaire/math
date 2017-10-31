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
		Matrix matrix = new Matrix(Arrays.asList(Arrays.asList(1.0, 2.0, 3.0), Arrays.asList(2.0, 3.0, 4.0)));

		matrix.multiplyAndAddLine(-1.0, 0, 1);

		assertThat(matrix.get(1, 0), is(1.0));
		assertThat(matrix.get(1, 1), is(1.0));
		assertThat(matrix.get(1, 2), is(1.0));
	}

	@Test
	public void reduceColumn()
	{
		Matrix matrix = new Matrix(Arrays.asList(Arrays.asList(1.0, 2.0, 3.0, 4.0), Arrays.asList(0.0, 2.0, 3.0, 4.0),
				Arrays.asList(0.0, 2.0, 4.0, 5.0), Arrays.asList(0.0, 2.0, 4.0, 5.0)));

		matrix.reduceColumn(1);

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
	public void reduceToTriangleForm()
	{
		Matrix matrix = new Matrix(
				Arrays.asList(Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0), Arrays.asList(1.0, 2.0, 2.0, 2.0, 2.0),
						Arrays.asList(1.0, 2.0, 3.0, 3.0, 3.0), Arrays.asList(1.0, 2.0, 3.0, 4.0, 4.0)));

		matrix.reduceToTriangleForm();

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
}

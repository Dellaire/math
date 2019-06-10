package de.bearishcode.math.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.bearishcode.math.sle.SystemOfLinearEquations;
import de.bearishcode.math.vector.VectorEquation;

@SpringUI(path = "/ui/lineIntersection")
public class LineIntersectionView extends UI {

	private static final long serialVersionUID = 6416562456100518838L;

	@Override
	protected void init(VaadinRequest request) {

		VerticalLayout content = new VerticalLayout();
		this.setContent(content);

		HorizontalLayout firstLine = new HorizontalLayout();
		TextArea firstStartPoint = new TextArea();
		firstStartPoint.setHeight("60px");
		TextArea firstEndPoint = new TextArea();
		firstEndPoint.setHeight("60px");
		firstLine.addComponent(firstStartPoint);
		firstLine.addComponent(firstEndPoint);
		
		HorizontalLayout secondLine = new HorizontalLayout();
		TextArea secondStartPoint = new TextArea();
		secondStartPoint.setHeight("60px");
		TextArea secondEndPoint = new TextArea();
		secondEndPoint.setHeight("60px");
		secondLine.addComponent(secondStartPoint);
		secondLine.addComponent(secondEndPoint);
		
		TextArea result = new TextArea();
		result.setHeight("60px");
		result.setReadOnly(true);

		Button calculate = new Button("Calculate Intersection");
		calculate.addClickListener((clickEvent) -> {

			VectorEquation ve1 = new VectorEquation(this.parseVector(firstStartPoint.getValue()),
					this.parseVector(firstEndPoint.getValue()));
			VectorEquation ve2 = new VectorEquation(this.parseVector(secondStartPoint.getValue()),
					this.parseVector(secondEndPoint.getValue()));

			SystemOfLinearEquations systemOfLinearEquations = new SystemOfLinearEquations(ve1, ve2);
			double[] solutionVector = systemOfLinearEquations.solve();

			double[] intersection = new double[solutionVector.length];
			for (int i = 0; i < intersection.length; i++) {
				intersection[i] = ve1.getStartPoint()[i] + ve1.getDirection()[i] * solutionVector[0];
			}

			String resultAsString = "";
			for (int i = 0; i < intersection.length; i++) {
				resultAsString += intersection[i] + "\n";
			}

			result.setValue(resultAsString);
		});

		content.addComponent(new Label("First Line"));
		content.addComponent(firstLine);
		content.addComponent(new Label("Second Line"));
		content.addComponent(secondLine);
		content.addComponent(calculate);
		content.addComponent(new Label("Intersection"));
		content.addComponent(result);
	}

	private double[] parseVector(String vectorAsString) {

		String[] valuesAsString = vectorAsString.split("\n");
		double[] values = new double[valuesAsString.length];
		for (int i = 0; i < values.length; i++) {
			values[i] = Double.parseDouble(valuesAsString[i]);
		}

		return values;
	}
}
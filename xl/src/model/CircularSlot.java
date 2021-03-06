package model;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;

public class CircularSlot implements Slot {
	
	private Expr expr;
	
	public CircularSlot(String expr) throws IOException {
		ExprParser parser = new ExprParser();
		this.expr = parser.build(expr);
	}

	@Override
	public double getValue(Sheet sheet) {
		System.out.println("HEjdå");
		throw new CircularSlotException("BLA");
	}

	@Override
	public String getComment() {
		System.out.println("Hallå");
		throw new CircularSlotException("BLA");
	}

}

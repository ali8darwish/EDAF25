package model;

public class ExprSlot extends Slot {
	
	public double getValue() {
		return 0; //Obviously not final
	}
	
	public String getComment() throws SlotTypeException {
		throw new SlotTypeException("Not a commentSlot");
	}

}

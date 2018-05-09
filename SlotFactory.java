package model;

public class SlotFactory {
	Slot slot;

	public Slot newSlot(String str) {
		if (str.substring(0, 1)=="#") {
			return slot=new CommentSlot(str);
		}
		
		return slot=new ExprSlot();
	}
	
	
}

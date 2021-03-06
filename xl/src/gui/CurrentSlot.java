package gui;

import java.util.Observable;

public class CurrentSlot extends Observable {
	
	private String address;
	
	public CurrentSlot() {
		this.address = "A1";
	}
	
	public void updateAddress(String address) {
		this.address = address;
		this.setChanged();
		this.notifyObservers(address);
	}

}

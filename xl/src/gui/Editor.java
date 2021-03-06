package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.ExprSlot;
import model.Sheet;
import model.Slot;

public class Editor extends JTextField implements ActionListener, Observer {

	private Sheet sheet;
	private String currentAddress;

	public Editor(Sheet sheet) {
		setBackground(Color.WHITE);
		this.sheet = sheet;
		this.addActionListener(this);
		currentAddress = "A1";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sheet.setSlot(currentAddress, this.getText());
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void update(Observable o, Object object) {
		if (o instanceof CurrentSlot) {
			currentAddress = (String) object;
		} else {
			Map<String, Slot> map = (Map) object; 
			if(map.containsKey(currentAddress)) {
				Slot slot = map.get(currentAddress);
				if (slot instanceof ExprSlot) {
					this.setText(((ExprSlot) slot).getExpr().toString());
				} else {
					this.setText(slot.getComment());
				}		
			} else {
				this.setText("");
			}
		}
	}
}
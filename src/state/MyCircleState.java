package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import view.MySlotView;
import commands.MyAddDeviceCommand;

public class MyCircleState extends MyState {
	private static final long serialVersionUID = 1L;
	private MySlotView med;
	
	public MyCircleState(MySlotView md) {
		this.med = md;
	}
	public MyCircleState( MyCircleState mcs ){
		this.med = new MySlotView(mcs.med);
	}
	
	@SuppressWarnings("static-access")
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if (e.getButton() == MouseEvent.BUTTON1) {
			 if (med.getSlot().getModel().getDeviceAtPosition(position) == -1) {
				 med.getCommandManager().
				 	addCommand(new MyAddDeviceCommand(med.getSlot().getModel(), position, med.CIRCLE)
				 );
			 }
		}
	}
}

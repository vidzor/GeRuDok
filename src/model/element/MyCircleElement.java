package model.element;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import model.MyElement;
import model.MySlot;
import app_main.MyMainFrame;
import view.painter.MyCirclePainter;

public class MyCircleElement extends MySlotElement {
	private static final long serialVersionUID = 1L;

	public MyCircleElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(position, size, stroke, paint, strokeColor);
		elementPainter = new MyCirclePainter(this);
		MySlot seld_slot = MyMainFrame.getInstance().getWorkspaceTree().getCurrentSlot();
		if(seld_slot != null){
			if(seld_slot.getParent_page().getParent_doc().getOriginal() != null){
				seld_slot = seld_slot.getParent_page().getParent_doc()
				.getOriginal().getDoc().getPage(seld_slot.getParent_page().toString())
				.getSlot(seld_slot.toString());
			}
			MyElement elem = new MyElement(" ");
			elem.setType("Circle");
			elem = seld_slot.addElement(elem);
			this.setName(" ");
			this.relevant_element_ID = elem.getID();
		}
	}
	
	public MyCircleElement(MyCircleElement circle) {
		super(circle);
		elementPainter = new MyCirclePainter(circle);
		MySlot seld_slot = MyMainFrame.getInstance().getWorkspaceTree().getCurrentSlot();
		MyElement elem = new MyElement(" ");
		elem.setType("Circle");
		elem = seld_slot.addElement(elem);
		this.setName(" ");
		this.relevant_element_ID = elem.getID();
	}
	
	public static MySlotElement createDefault(Point2D pos, int elemNo) {
		Point2D position = (Point2D) pos.clone();
		Paint[] fill = {Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.RED, Color.ORANGE};
		Color[] strokeC = {Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.RED, Color.ORANGE};
		
		MyCircleElement circle = new MyCircleElement(
			position, new Dimension(40, 40), 
			new BasicStroke(2f), 
			fill[i_c], strokeC[i_c]
		);
		
		if(i_c < 5) i_c++; else i_c = 0;
		return circle;
	}

	@Override
	public MySlotElement clone() {
		return new MyCircleElement(this);
	}
}

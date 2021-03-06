package gui;

import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import controller.MyWSTreeListeners;
import model.MyDocument;
import model.MyElement;
import model.MyPage;
import model.MyProject;
import model.MySlot;
import model.MyWorkspace;
import view.MyTreeCellEditor;
import view.MyTreeCellRenderer;

public class MyWorkspaceTree extends JTree implements Observer {
	private static final long serialVersionUID = 1L;
	
	private MyWorkspace workspace;
	
	public MyWorkspaceTree(MyWorkspace workspace) {
		super(workspace);
		this.workspace = workspace;
		this.workspace.getObservable().addObserver(this);
		this.setCellEditor(new MyTreeCellEditor(this, new MyTreeCellRenderer()));
		this.setCellRenderer(new MyTreeCellRenderer());
		this.setEditable(true);
		this.addMouseListener(new MyWSTreeListeners(this));
		this.addTreeSelectionListener(new MyWSTreeListeners(this));
	}
	
	public MyProject getCurrentProject() {
		TreePath path = getSelectionPath();
		if(path == null) return null;
		MyProject proj = null;
		
		for(int i = 0; i < path.getPathCount(); i++) {
			if(path.getPathComponent(i) instanceof MyProject) {
				proj = (MyProject) path.getPathComponent(i);
				break;
			}
		}
		return proj;
	}
	
	public MyDocument getCurrentDocument() {
		TreePath path = getSelectionPath();
		if(path == null) return null;
		MyDocument doc = null;
		
		for(int i = 0; i < path.getPathCount(); i++) {
			if(path.getPathComponent(i) instanceof MyDocument) {
				doc = (MyDocument) path.getPathComponent(i);
				break;
			}
		}
		return doc;
	}
	
	public MyPage getCurrentPage() {
		TreePath path = getSelectionPath();
		if(path == null) return null;
		MyPage page = null;
		
		for(int i = 0; i < path.getPathCount(); i++) {
			if(path.getPathComponent(i) instanceof MyPage) {
				page = (MyPage) path.getPathComponent(i);
				break;
			}
		}
		return page;
	}
	
	public MySlot getCurrentSlot() {
		TreePath path = getSelectionPath();
		if(path == null) return null;
		MySlot slot = null;
		
		for(int i = 0; i < path.getPathCount(); i++) {
			if(path.getPathComponent(i) instanceof MySlot) {
				slot = (MySlot) path.getPathComponent(i);
				break;
			}
		}
		return slot;
	}
	
	public void click_helper(MouseEvent e) {
		TreePath path = this.getSelectionPath();
		if(path == null) return;
		if(path.getPathCount() == 1 && path.getPathComponent(0) instanceof MyWorkspace) {
			if (e != null && e.isPopupTrigger()) {
				MyPopUpMenu menu = new MyPopUpMenu(1);
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		} else if(path.getPathCount() == 2 && path.getPathComponent(1) instanceof MyProject) {
			if (e != null && e.isPopupTrigger()) {
				MyPopUpMenu menu = new MyPopUpMenu(2);
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		} else if(path.getPathCount() == 3 && path.getPathComponent(2) instanceof MyDocument) {
			if (e != null && e.isPopupTrigger()) {
				MyPopUpMenu menu = new MyPopUpMenu(3);
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		} else if(path.getPathCount() == 4 && path.getPathComponent(3) instanceof MyPage) {
			if (e != null && e.isPopupTrigger()) {
				MyPopUpMenu menu = new MyPopUpMenu(4);
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		} else if(path.getPathCount() == 5 && path.getPathComponent(4) instanceof MySlot) {
			if (e != null && e.isPopupTrigger()) {
				MyPopUpMenu menu = new MyPopUpMenu(5);
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		} else if(path.getPathCount() == 6 && path.getPathComponent(5) instanceof MyElement) {
			if (e != null && e.isPopupTrigger()) {
				MyPopUpMenu menu = new MyPopUpMenu(6);
				menu.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}

	@Override
	public void update(Observable o, Object object) {
		//Ako je dodavanje u pitanju, uzeti element koji je dodat i zapoceti osluskivanje njega. this osluskuje njega
		SwingUtilities.updateComponentTreeUI(this);
	}
}

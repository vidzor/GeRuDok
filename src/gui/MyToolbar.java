package gui;

import javax.swing.AbstractAction;
import javax.swing.JToolBar;

import app_main.MyMainFrame;
import view.TDToolbar;

public class MyToolbar extends JToolBar {
	private static final long serialVersionUID = 1L;
	
	public MyToolbar() {
		super();
		setFloatable(true);
		
		add(MyMainFrame.getInstance().getActionManager().getNewProjectAction());
		add(MyMainFrame.getInstance().getActionManager().getNewDocumentAction());
		add(MyMainFrame.getInstance().getActionManager().getNewPageAction());
		add(MyMainFrame.getInstance().getActionManager().getNewTSlotAction());
		add(MyMainFrame.getInstance().getActionManager().getNewGSlotAction());
		addSeparator();
		add(MyMainFrame.getInstance().getActionManager().getDeleteAction());
		add(MyMainFrame.getInstance().getActionManager().getShareAction());
		addSeparator();
		add(MyMainFrame.getInstance().getActionManager().getCascadeWindowAction());
		add(MyMainFrame.getInstance().getActionManager().getVerticalWindowAction());
		add(MyMainFrame.getInstance().getActionManager().getHorizontalWindowAction());
		addSeparator();
		add(MyMainFrame.getInstance().getActionManager().getCallAboutDialog());
	}
	
	public void initComponents() {
		MyMainFrame.getInstance().getActionManager().getDeleteAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnDelete"));
		
		MyMainFrame.getInstance().getActionManager().getDeleteAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnDelete"));
		MyMainFrame.getInstance().getActionManager().getShareAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnShare"));
		MyMainFrame.getInstance().getActionManager().getShareAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnShare"));
	
		MyMainFrame.getInstance().getActionManager().getSelectAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnSelect"));
		MyMainFrame.getInstance().getActionManager().getNewRectangleAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnRectangle"));
		MyMainFrame.getInstance().getActionManager().getNewCircleAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnCircle"));
		MyMainFrame.getInstance().getActionManager().getUndoAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnUndo"));
		MyMainFrame.getInstance().getActionManager().getRedoAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnRedo"));
		MyMainFrame.getInstance().getActionManager().getCutAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnCut"));
		MyMainFrame.getInstance().getActionManager().getCopyAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnCopy"));
		MyMainFrame.getInstance().getActionManager().getPasteAction().putValue(AbstractAction.NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnPaste"));
		
		MyMainFrame.getInstance().getActionManager().getSelectAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnSelect"));
		MyMainFrame.getInstance().getActionManager().getNewRectangleAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnRectangle"));
		MyMainFrame.getInstance().getActionManager().getNewCircleAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnCircle"));
		MyMainFrame.getInstance().getActionManager().getUndoAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnUndo"));
		MyMainFrame.getInstance().getActionManager().getRedoAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnRedo"));
		MyMainFrame.getInstance().getActionManager().getCutAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnCut"));
		MyMainFrame.getInstance().getActionManager().getCopyAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnCopy"));
		MyMainFrame.getInstance().getActionManager().getPasteAction().putValue(AbstractAction.SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnPaste"));
	
		TDToolbar.btnB.setToolTipText(MyMainFrame.getInstance().getResourceBundle().getString("btnBold"));
		TDToolbar.btnI.setToolTipText(MyMainFrame.getInstance().getResourceBundle().getString("btnItalic"));
		TDToolbar.btnU.setToolTipText(MyMainFrame.getInstance().getResourceBundle().getString("btnUnderline"));
	}
}

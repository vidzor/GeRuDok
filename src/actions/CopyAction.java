package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import app_main.MyMainFrame;
import model.MySlotElementsSelection;
import view.MySlotView;

public class CopyAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;
	
	private MySlotView view;
	
	public CopyAction() {
		super();
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("src/images/size16/copy.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/copy.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnCopy"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnCopy"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*MyWorkspaceView view = MyMainFrame.getInstance().getDesktop();
		
		MyProjectView pView = (MyProjectView) view.getSelectedFrame();
		//System.out.println(pView.getProject().toString());
		
		MyDocumentView dView = (MyDocumentView) pView.getTabs().getSelectedComponent();
		//System.out.println(dView.getDocument().toString());
		*/
		
		if(!(this.view.getSlot().getSelectionModel().getSelectionListSize() == 0)) {
			MySlotElementsSelection contents = new MySlotElementsSelection(this.view.getSlot().getSelectionModel().getSelected());
			MyMainFrame.getInstance().getClipboard().setContents(contents, MyMainFrame.getInstance());
			
			//System.out.println("hahah");
		}
	}

	public MySlotView getView() {
		return view;
	}

	public void setView(MySlotView view) {
		this.view = view;
	}
}

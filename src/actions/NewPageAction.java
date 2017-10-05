package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.SwingUtilities;

import app_main.MyMainFrame;
import model.MyDocument;
import model.MyPage;
import model.MySlot;

public class NewPageAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public NewPageAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/page_blank.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/page_blank.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnNewPage"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnNewPage"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyMainFrame mfinst = MyMainFrame.getInstance();
		//MyProject Seld_proj = mfinst.getWorkspaceTree().getCurrentProject();
		
		MyDocument sel_doc = mfinst.getWorkspaceTree().getCurrentDocument();
		if(sel_doc != null) {
			if(sel_doc.getOriginal() != null)
				sel_doc = sel_doc.getOriginal().getDoc();
			MyPage page = new MyPage(" ");
			sel_doc.addPage(page);
		}
		
		SwingUtilities.updateComponentTreeUI(MyMainFrame.getInstance().getWorkspaceTree());
		MyMainFrame.getInstance().getWorkspaceTree().click_helper(null);
	}
	
	public int gen_idx(ArrayList<Integer> free_indexes, ArrayList<MySlot> slots){
		if(free_indexes.size() == 1){
			int min_idx_val = free_indexes.get(0);
			free_indexes.remove(0);
			return min_idx_val;
		}
		else if(free_indexes.size() >= 2){
			int min_idx = free_indexes.indexOf(
				Collections.min(free_indexes)
			);
			int min_idx_val = free_indexes.get(min_idx);
			free_indexes.remove(min_idx);
			return min_idx_val;
		}
		else return slots.size()+1;
	}
}

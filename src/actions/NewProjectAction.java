package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.SwingUtilities;

import app_main.MyMainFrame;
import model.MyDocument;
import model.MyProject;
import model.MyWorkspace;

public class NewProjectAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public NewProjectAction() {
		super();
		putValue(SMALL_ICON, loadIcon("src/images/size16/project.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/project.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnNewProject"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnNewProject"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyWorkspace workspace = (MyWorkspace) MyMainFrame.getInstance().getWorkspaceTree().getModel().getRoot();
		MyProject project = new MyProject(" ");
		workspace.addProject(project);
		
		//TreeObserver koji radi samo ovaj posao ispod i osluskuje sve model.
		SwingUtilities.updateComponentTreeUI(MyMainFrame.getInstance().getWorkspaceTree());
		
		MyMainFrame.getInstance().getWorkspaceTree().click_helper(null);
	}
	
	public int gen_idx(ArrayList<Integer> free_indexes, ArrayList<MyDocument> documents){
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
		else return documents.size()+1;
	}
}

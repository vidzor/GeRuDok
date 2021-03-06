package actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import app_main.MyMainFrame;
import model.MyProject;

public class SaveProjectFileAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public SaveProjectFileAction() {
		super();
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, loadIcon("src/images/size16/saveProject.png"));
		putValue(LARGE_ICON_KEY, loadIcon("src/images/size22/saveProject.png"));
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("menuSave"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("menuSave"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new MyFileFilter());
		
		MyProject project = MyMainFrame.getInstance().getWorkspaceTree().getCurrentProject();
		File projectFile = project.getProjectFile();
		
		if (!project.isChanged()) {
			return;
		}
		
		if (project.getProjectFile() == null) {
			if(jfc.showSaveDialog(MyMainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
				projectFile = jfc.getSelectedFile();       
			} else {
				return; 
			}
		}
//		for(int d=0; d<project.getDocumentCount(); d++){
//			MyDocument _doc = project.getDocument(d);
//			_doc.setName( "Doc "+_doc.getID() );
//		}

		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(projectFile));
			os.writeObject(project);
			project.setProjectFile(projectFile);
			project.setChanged(false);
			SwingUtilities.updateComponentTreeUI(MyMainFrame.getInstance().getWorkspaceTree());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

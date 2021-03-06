package actions;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import app_main.MyMainFrame;

public class ExitAction extends MyAbstractAction {
	private static final long serialVersionUID = 1L;

	public ExitAction() {
		super();
		putValue(NAME, MyMainFrame.getInstance().getResourceBundle().getString("btnExit"));
		putValue(SHORT_DESCRIPTION, MyMainFrame.getInstance().getResourceBundle().getString("btnExit"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int choice = JOptionPane.showConfirmDialog( null, 
			MyMainFrame.getInstance().getResourceBundle().getString("close_save_ws_prompt")
		);
		if(choice == 0){
			// save ws:
			ObjectOutputStream os;
			try {
				JFileChooser jfc = new JFileChooser();
				jfc.setFileFilter(new MyFileFilter_ws());
				
				if(jfc.showSaveDialog(MyMainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
					MyMainFrame.getInstance().set_Workspace_file(
						jfc.getSelectedFile()
					);
				}
				os = new ObjectOutputStream(
					new FileOutputStream(
						MyMainFrame.getInstance().get_Workspace_file()
					)
				);
				os.writeObject( MyMainFrame.getInstance().getWorkspace() );
				os.close();
				System.exit(0);
			}
			catch (IOException e1){ e1.printStackTrace(); }
		}
		else if(choice == 1){
			// don't save ws:
//			MyMainFrame.get_Workspace_file().delete();
			System.exit(0);
		}
	}

}

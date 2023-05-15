import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class CopyActionListener implements ActionListener {
	JTextArea text;
	
	public CopyActionListener(JTextArea text) {
		this.text = text;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection selection = new StringSelection(this.text.getSelectedText());
		clipboard.setContents(selection, null);
	}

}

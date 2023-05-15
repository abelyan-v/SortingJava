import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

public class PasteActionListener implements ActionListener {
	JTextArea text;
	
	public PasteActionListener(JTextArea text) {
		this.text = text;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		DataFlavor flavor = DataFlavor.stringFlavor;
		if (clipboard.isDataFlavorAvailable(flavor)) {
			try {
				String pasteText = text.getText();
				this.text.setText(pasteText.substring(0, text.getSelectionStart()) + clipboard.getData(flavor).toString() + pasteText.substring(text.getSelectionEnd(), pasteText.length()));
			}
			catch (UnsupportedFlavorException | IOException e1) {
            }
		}
	}

}

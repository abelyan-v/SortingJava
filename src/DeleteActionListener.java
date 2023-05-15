import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextArea;

public class DeleteActionListener implements ActionListener {
	JTextArea text;
	
	public DeleteActionListener(JTextArea text) {
		this.text = text;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.text.getSelectedText() != null) {
			this.text.setText(this.text.getText().replace(this.text.getSelectedText(), ""));
		}
	}

}
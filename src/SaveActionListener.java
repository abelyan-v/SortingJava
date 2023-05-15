import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.io.FileWriter;

public class SaveActionListener implements ActionListener {
	public JTextArea text = new JTextArea();
	public JPanel panel;
	
	public SaveActionListener(JTextArea text, JPanel panel) {
		this.text = text;
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	JFileChooser file = new JFileChooser();
	file.showDialog(panel, "Save");
		
        try(FileWriter writer = new FileWriter(file.getSelectedFile(), false))
        {
            writer.write(this.text.getText());

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

	}

}

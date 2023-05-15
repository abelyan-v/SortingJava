import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.io.FileReader;

public class LoadActionListener implements ActionListener {
	public JTextArea text = new JTextArea();
	public JPanel panel;
	
	public LoadActionListener(JTextArea text, JPanel panel) {
		this.text = text;
		this.panel = panel;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser file = new JFileChooser();
		file.showDialog(panel, "Load");
		
		try(FileReader reader = new FileReader(file.getSelectedFile()))
        {
            int c;
            this.text.setText(null);
            while((c=reader.read())!=-1) {
                this.text.append(String.valueOf((char)c));
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

	}

}

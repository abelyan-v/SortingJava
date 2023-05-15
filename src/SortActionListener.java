import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class SortActionListener implements ActionListener {
	public JTextArea text;
	public JRadioButton decrease;
	public JRadioButton increase;
	
	public SortActionListener(JTextArea text, JRadioButton decrease, JRadioButton increase) {
		this.text = text;
		this.decrease = decrease;
		this.increase = increase;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String textString = this.text.getText();
		String[] words = textString.split("\n");
        String[] words_sorted_inverted = new String[words.length];
        int word_length = words.length;
        this.text.setText(null);
        Arrays.sort(words);
        System.out.println("number: " + words.length);
        if (this.increase.isSelected()) {
            for (String word : words) {
                this.text.append(word + "\n");
            }
        }
        System.out.println("debug");
        if (this.decrease.isSelected()) {
            for (int i = words.length - 1; i >= 0; i--) {
                words_sorted_inverted[(words.length - i - 1)] = words[i];
            }
            for (String word : words_sorted_inverted) {
                this.text.append(word + "\n");
            }
        }
        System.out.println(Arrays.toString(words));
	}
}

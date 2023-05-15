import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.JPopupMenu.Separator;

public class Form extends JFrame {
	public Form() {
		super("Sorting");
		pack();
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		Container container = getContentPane();
		setVisible(true);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		container.add(panel);
		final JTextArea text = new JTextArea();
		panel.add(text);
		JPanel footer = new JPanel();
		panel.add(footer, BorderLayout.SOUTH);
		JPanel buttonsPanel = new JPanel();
		footer.setLayout(new GridLayout(2, 0, 0, 0));
		JPanel radioButtonsPanel = new JPanel();
		final JRadioButton increase = new JRadioButton("increase");
		increase.setSelected(true);
		final JRadioButton decrease = new JRadioButton("decrease");
		ButtonGroup radioButtonsGroup = new ButtonGroup();
		radioButtonsGroup.add(increase);
		radioButtonsGroup.add(decrease);
		radioButtonsPanel.add(increase);
		radioButtonsPanel.add(decrease);
		footer.add(radioButtonsPanel);
		footer.add(buttonsPanel);
		JButton sortButton = new JButton("Sort");
		buttonsPanel.add(sortButton);
		JButton loadButton = new JButton("Load");
		buttonsPanel.add(loadButton);
		JButton saveButton = new JButton("Save");
		buttonsPanel.add(saveButton);
		ActionListener sortListener = new SortActionListener(text, decrease, increase);
		ActionListener loadListener = new LoadActionListener(text, panel);
		ActionListener saveListener = new SaveActionListener(text, panel);
		sortButton.addActionListener(sortListener);
		loadButton.addActionListener(loadListener);
		saveButton.addActionListener(saveListener);
		ActionListener exitListener = new ExitActionListener();
		ActionListener copyTextListener = new CopyActionListener(text);
		ActionListener pasteTextListener = new PasteActionListener(text);
		ActionListener cutTextListener = new CutActionListener(text);
		ActionListener deleteTextListener = new DeleteActionListener(text);
		
		JMenuBar menu = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenu = new JMenuItem("Load");
		JMenuItem saveMenu = new JMenuItem("Save");
		JMenuItem exitMenu = new JMenuItem("Exit");
		JMenu editMenu = new JMenu("Edit");
		JMenuItem copyBarMenu = new JMenuItem("Copy");
		JMenuItem cutBarMenu = new JMenuItem("Cut");
		JMenuItem pasteBarMenu = new JMenuItem("Paste");
		JMenuItem deleteBarMenu = new JMenuItem("Delete");
		loadMenu.setMnemonic('l');
		saveMenu.setMnemonic('s');
		exitMenu.setMnemonic('e');
		fileMenu.setMnemonic('f');
		copyBarMenu.setMnemonic('c');
		cutBarMenu.setMnemonic('u');
		pasteBarMenu.setMnemonic('p');
		deleteBarMenu.setMnemonic('d');
		editMenu.setMnemonic('e');
		loadMenu.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
		saveMenu.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
		exitMenu.setAccelerator(KeyStroke.getKeyStroke('Q', KeyEvent.CTRL_MASK));
		copyBarMenu.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.CTRL_MASK));
		cutBarMenu.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK));
		pasteBarMenu.setAccelerator(KeyStroke.getKeyStroke('V', KeyEvent.CTRL_MASK));
		deleteBarMenu.setAccelerator(KeyStroke.getKeyStroke('D', KeyEvent.CTRL_MASK));
		fileMenu.add(loadMenu);
		fileMenu.add(saveMenu);
		fileMenu.add(new Separator());
		fileMenu.add(exitMenu);
		editMenu.add(copyBarMenu);
		editMenu.add(cutBarMenu);
		editMenu.add(pasteBarMenu);
		editMenu.add(deleteBarMenu);
		menu.add(fileMenu);
		menu.add(editMenu);
		panel.add(menu, BorderLayout.NORTH);
		loadMenu.addActionListener(loadListener);
		exitMenu.addActionListener(exitListener);
		copyBarMenu.addActionListener(copyTextListener);
		pasteBarMenu.addActionListener(pasteTextListener);
		cutBarMenu.addActionListener(cutTextListener);
		deleteBarMenu.addActionListener(deleteTextListener);
		
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem copyMenu = new JMenuItem("Copy");
		JMenuItem cutMenu = new JMenuItem("Cut");
		JMenuItem pasteMenu = new JMenuItem("Paste");
		JMenuItem deleteMenu = new JMenuItem("Delete");
		copyMenu.addActionListener(copyTextListener);
		pasteMenu.addActionListener(pasteTextListener);
		cutMenu.addActionListener(cutTextListener);
		deleteMenu.addActionListener(deleteTextListener);
		copyMenu.setAccelerator(KeyStroke.getKeyStroke('C', KeyEvent.CTRL_MASK));
		cutMenu.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK));
		pasteMenu.setAccelerator(KeyStroke.getKeyStroke('V', KeyEvent.CTRL_MASK));
		popupMenu.add(copyMenu);
		popupMenu.add(cutMenu);
		popupMenu.add(pasteMenu);
		popupMenu.add(new Separator());
		popupMenu.add(deleteMenu);
		text.setComponentPopupMenu(popupMenu);
		setSize(400, 350);
	}

}

class ExitActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
}
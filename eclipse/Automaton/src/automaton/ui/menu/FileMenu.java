package automaton.ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;

import automaton.decoder.Decoder;
import automaton.io.Console;
import automaton.main.Main;

/**
 * File menu displayed in the menu bar.
 */
public class FileMenu extends JMenu {

	/**
	 * File menu displayed in the menu bar.
	 */
	public FileMenu() {

		this.setText("File");


		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save as");
		JMenuItem exitItem = new JMenuItem("Exit");


		openItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));

				fileChooser.setFileFilter(new FileNameExtensionFilter("life", "life"));

				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

					File file = fileChooser.getSelectedFile();

					Main.automaton.world.clear();
					Decoder.decode(file, Main.automaton.world);

				}

			}

		});

		saveItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));

				fileChooser.setFileFilter(new FileNameExtensionFilter("life", "life"));

				if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

					File file = fileChooser.getSelectedFile();

					if (!file.getName().toLowerCase().endsWith(".life")) {
						file = new File(file.getAbsolutePath() + ".life");
					}

					if (!file.exists()) {

						try {

							file.createNewFile();

						} catch (Exception exception) {
							Console.err(exception, this);
							return;
						}

					}

					Decoder.encode(Main.automaton.world, file);

				}

			}

		});

		exitItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Main.automaton.stop();

			}

		});


		this.add(openItem);
		this.add(saveItem);
		this.add(exitItem);

	}

}

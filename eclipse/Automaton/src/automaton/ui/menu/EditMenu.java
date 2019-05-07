package automaton.ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import automaton.config.Conf;
import automaton.main.Main;

/**
 * Edit menu displayed in the menu bar.
 */
public class EditMenu extends JMenu {

	/**
	 * Edit menu displayed in the menu bar.
	 */
	public EditMenu() {

		this.setText("Edit");


		JMenuItem playItem  = new JMenuItem("Play/Pause");
		JMenuItem clearItem = new JMenuItem("Clear");

		JCheckBoxMenuItem editingItem = new JCheckBoxMenuItem("Active Editing");
		JCheckBoxMenuItem coloredItem = new JCheckBoxMenuItem("Active Colored Cells");
		JCheckBoxMenuItem borderItem  = new JCheckBoxMenuItem("Show Chunk Borders");


		playItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Main.automaton.toggle();
			}

		});

		clearItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Main.automaton.world.clear();
				Main.automaton.pause();
			}

		});


		editingItem.setState(Conf.CANVAS_ACTIVE_EDITING);
		editingItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Conf.CANVAS_ACTIVE_EDITING = !Conf.CANVAS_ACTIVE_EDITING;
			}

		});

		coloredItem.setState(Conf.CANVAS_ACTIVE_COLORED_CELLS);
		coloredItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Conf.CANVAS_ACTIVE_COLORED_CELLS = !Conf.CANVAS_ACTIVE_COLORED_CELLS;
			}

		});

		borderItem.setState(Conf.CANVAS_ACTIVE_CHUNK_BORDERS);
		borderItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Conf.CANVAS_ACTIVE_CHUNK_BORDERS = !Conf.CANVAS_ACTIVE_CHUNK_BORDERS;
			}

		});


		this.add(playItem);
		this.add(clearItem);
		this.addSeparator();
		this.add(editingItem);
		this.add(coloredItem);
		this.add(borderItem);

	}

}

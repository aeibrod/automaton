package automaton.ui.widget;

import javax.swing.JMenuBar;

import automaton.ui.menu.AboutMenu;
import automaton.ui.menu.EditMenu;
import automaton.ui.menu.FileMenu;
import automaton.ui.menu.ImportMenu;

/**
 * Menu bar component displayed in the window.
 * 
 * @see Window
 */
public class MenuBar extends JMenuBar {

	/**
	 * Menu bar component displayed in the window.
	 * 
	 * @see Window
	 */
	public MenuBar() {

		this.add(new FileMenu());
		this.add(new EditMenu());
		this.add(new ImportMenu());
		this.add(new AboutMenu());

	}

}

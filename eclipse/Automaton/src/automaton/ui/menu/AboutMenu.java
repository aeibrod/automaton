package automaton.ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import automaton.config.Conf;
import automaton.decoder.Decoder;
import automaton.io.Resource;
import automaton.main.Main;

/**
 * About menu displayed in the menu bar.
 */
public class AboutMenu extends JMenu {

	/**
	 * About menu displayed in the menu bar.
	 */
	public AboutMenu() {

		this.setText("About");


		JMenuItem aboutItem = new JMenuItem("About " + Conf.APP_NAME);


		aboutItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Main.automaton.world.clear();
				Decoder.decode(Resource.getRes("res/presets/about/about.life"), Main.automaton.world);

			}

		});


		this.add(aboutItem);

	}

}

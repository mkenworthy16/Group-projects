/**
 * 
 */
package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * @author Cole Kenworthy
 *
 */
public class DeskTop {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Internal Frames"); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JDesktopPane desktop = new JDesktopPane(); 
		
		final JInternalFrame ruleWindow = new JInternalFrame(("Rules"), true, false, true, false); 
		//1st boolean - Resizable //2nd boolean - Closable //3rd boolean - Maximizable //4th boolean - Iconifiable 
		
		JButton setRules = new JButton("Set Rules"); 
		
		setRules.addActionListener(new ActionListener() { 
			@Override public void actionPerformed(ActionEvent e) { 
				rulePane();
				//calls for other window generation
			}
		}); 
		
		
		JPanel t = new JPanel(); 
		t.add(setRules); 
		ruleWindow.add(t, BorderLayout.CENTER);
		ruleWindow.setVisible(true);
		ruleWindow.setSize(500, 500);
		ruleWindow.setMinimumSize(new Dimension(300, 240));
		desktop.add(ruleWindow); 
		
		//set desktop in window Jframe, sets size and everything else
		window.add(BorderLayout.CENTER, desktop);
		window.setSize(500, 500);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
	}
	
	private static void rulePane() {
		JPanel a = new JPanel();
		JLabel house = new JLabel();
		
		house.setText("House Rules");
		
		a.add(house);
		
		//rules and labels for the rules
		JCheckBox threeCheckBox = new JCheckBox();
		JLabel three = new JLabel();
		three.setText("Three Pair Rule");
		
		JCheckBox straightCheckBox = new JCheckBox();
		JLabel straight = new JLabel();
		straight.setText("Straight Rule");
		
		JCheckBox fullCheckBox = new JCheckBox();
		JLabel full = new JLabel();
		full.setText("Full House Rule");
		
		JCheckBox addCheckBox = new JCheckBox();
		JLabel add = new JLabel();
		add.setText("Adding Rule");
		
		
		
		//for adding new players
		JButton addPlayer = new JButton("Add Player");
		JTextPane addP = new JTextPane();
		
		
		
		//new rule pane button
		JButton newRule = new JButton("Create New Rule");
		newRule.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				createNewRulePane();
			}
		});
		
		
	}
	
	private void createNewRulePane()
	{
		JButton addPlayer = new JButton("1");
		JTextPane addP = new JTextPane();
		
		JButton addPlayer = new JButton("5");
		JTextPane addP = new JTextPane();
		
		JButton addPlayer = new JButton("Add Player");
		JTextPane addP = new JTextPane();
		
		JButton addPlayer = new JButton("Add Player");
		JTextPane addP = new JTextPane();
		
		JButton addPlayer = new JButton("Add Player");
		JTextPane addP = new JTextPane();
		
		JButton addPlayer = new JButton("Add Player");
		JTextPane addP = new JTextPane();
		
		JButton addPlayer = new JButton("Add Player");
		JTextPane addP = new JTextPane();
		
		JButton addPlayer = new JButton("Add Player");
		JTextPane addP = new JTextPane();
		
	}
	

}

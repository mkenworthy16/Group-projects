/**
 * Farkle game UX package
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 * @author Cole
 *
 */
public class RuleBox extends JPanel{

	JLabel label;
    //ImageIcon icon = createImageIcon("images/dice.PNG");
    JFrame frame;
    String houseDesc = "Click each check box for rules you would like to play with";
    String userDesc = "Enter the score(#) you would like for each item";
    String playerDesc = "Enter the number of players you would like with names";
    String extraDesc = "Extra rules to play with";
	int numOfPlayers;
    
	/**
	 * 
	 */
	public RuleBox(JFrame frame) {
		super(new BorderLayout());
        this.frame = frame;
 
        //Create the components.
        JPanel housePanel = createHousePanel();
        JPanel userPanel = createUserPanel();
        JPanel playerPanel = createPlayerPanel();
        JPanel extraPanel = createExtraPanel();
        label = new JLabel("Click on each rule you would like to change and add in 2+ players ", JLabel.CENTER);
        
        //start game button 
        JButton startGame = new JButton("Start Game"); 
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	//used to start game, should resize and adjust everything from here
            	
                return;
            }
        });
        
        //Lay them out.
        Border padding = BorderFactory.createEmptyBorder(20,20,5,20);
        userPanel.setBorder(padding);
        housePanel.setBorder(padding);
        playerPanel.setBorder(padding);
        extraPanel.setBorder(padding);
 
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Scoreing Rules", null,
                          userPanel,
                          userDesc); 
        tabbedPane.addTab("House Rules", null,
                          housePanel,
                          houseDesc); 
        tabbedPane.addTab("Enter Players", null,
                          playerPanel,
                          playerDesc); 
        tabbedPane.addTab("Extra Rules", null, 
        					extraPanel,
        					extraDesc);
        
        add(tabbedPane, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);
        add(startGame, BorderLayout.EAST);
        label.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//TEST!
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

	}

	
	   /**
     * Create the UX and show it.  
     * start box for the game
     */
    static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Yahtzee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        
        //Create and set up the content pane.
        RuleBox newContentPane = new RuleBox(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
	
	
	 /** Sets the text displayed at the bottom of the frame. 
     * 
     * @param newText
     */
    void setLabel(String newText) {
        label.setText(newText);
    }
 
    
    /**
     *  Creates the panel shown by the first tab.
     *  used to control the active house rules in the game 
     * @return
     */
    private JPanel createHousePanel() {
        final int numButtons = 2;
        JRadioButton[] radioButtons = new JRadioButton[numButtons];
        JCheckBox[] checkBox = new JCheckBox[3];
        final ButtonGroup group = new ButtonGroup();
 
        final String addingCommand = "Add";
        final String doublingCommand = "Double";
        
        radioButtons[0] = new JRadioButton("Add the 3 of a Kind score for each additional “of a kind” die" +
										   "(eg. (3-3-3) = 300, (3-3-3-3) = 600, (3-3-3-3-3) = 900)");
        radioButtons[0].setActionCommand(addingCommand);
 
        radioButtons[1] = new JRadioButton("Double the score for each additional “of a kind” die" + 
        								   "(eg. (3-3-3) = 300, (3-3-3-3) = 600, (3-3-3-3-3) = 1200)");
        radioButtons[1].setActionCommand(doublingCommand);
        
        for (int i = 0; i < numButtons; i++) {
            group.add(radioButtons[i]);
        }
        
        radioButtons[0].setSelected(true);
        
        checkBox[0] = new JCheckBox("Three Pairs: ");// need score data
        //need action listener for these
        checkBox[1] = new JCheckBox("Straight: ");//need score data
        
        checkBox[2] = new JCheckBox("Full House: ");//need score data for full house value 
             
        
        //checks to see if radio button is selected, will set value to that, need actionlistener?
        String command = group.getSelection().getActionCommand();
 
        //5 dice in play
        if (command == addingCommand) 
        {
        	
        }
        //6 dice in play
        else if (command == doublingCommand) 
        {
        	
        }
                
        
        return createPane(houseDesc + ":",
                          radioButtons,
                          checkBox);
    }
	
    /**
     * Creates the panel shown by the 2nd tab.
     * allows for user to add in players 
     */
    private JPanel createPlayerPanel() {
        JTextField name;
        JLabel message; 
        JLabel response;
        JButton add;
    	
        message = new JLabel("Enter Player Name: ");
        
        response = new JLabel("");
        
        name = new JTextField();
        name.setPreferredSize(new Dimension(15,30));
        
        add = new JButton("Add Player");
        add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e){
        		String player = name.getText();
        		//check to see if field is empty
        		if(player.isEmpty()){
        			response.setText("Enter a name");
        		}
        		else{
        			//set value to player 1
        			response.setText("Player added");
        			numOfPlayers++;
        		}
        	}
        });
    	
        return createPane(playerDesc + ":",
                              name,
                              message, add, response);
    }
 
    /** Creates the panel shown by the second tab.
     * 	allows user to alter the scoring values for scoreable items
     **/    
    private JPanel createUserPanel() {
        
    	JTextField[] fields = new JTextField[7];
    	JLabel[] labels = new JLabel[7];
    	JButton[] button = new JButton[7];
    	
    	for(int i = 0; i < 7; i++)
    	{
    		fields[i] = new JTextField();
    		fields[i].setPreferredSize(new Dimension(15,30));
    		labels[i] = new JLabel();
    		button[i] = new JButton("Set Value");
    		button[i].addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e){
        			String player = fields[0].getText();//stuck..................
        			//check to see if field is empty
        			if(player.isEmpty()){
        				
        			}
        			else{
        				//set data value to score 
        				//______ = player;
        			}
        		}
    		});
    		
    	}
    	
    	labels[0].setText("One");
    	labels[1].setText("Five");
    	for(int i = 2; i < 7; i++)
    	{
    		labels[i].setText("3 "+ (i - 1));
    	}
    	
        return createPane(userDesc + ":",
                          labels, fields,
                          button);
    }
    
    /**
     *  Creates the panel shown by the first tab.
     *  used to control the number of dice in play in the game
     *  user is given three choices 5,6,7 
     * @return
     */
    private JPanel createExtraPanel() {
        JLabel[] labels = new JLabel[5];
        JCheckBox[] box = new JCheckBox[5];
        
        //need action listeners
        for(int i = 0; i < 5; i++)
        	box[i] = new JCheckBox();
        
        labels[0] = new JLabel("Starting Threshold");
        labels[1] = new JLabel("PiggyBacking");
        labels[2] = new JLabel("Hot Streak");
        labels[3] = new JLabel("Kick'em while they're down ");
        labels[4] = new JLabel("Welfare");
        
        
        return createPane(extraDesc + ":",
                          labels,
                          box);
    }
    
    
    /**
     * Used by createUserPanel
     * to create a pane containing a description, a single column
     * of labels, text fields, and the Set Value button.
     */
    private JPanel createPane(String description,JLabel[] labels,
                              JTextField[] fields,
                              JButton[] button) {
 
        JPanel box = new JPanel();
        JLabel label = new JLabel(description);
 
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.add(label);
        
        for (int i = 0; i < 7; i++) {
            box.add(labels[i]);
            box.add(fields[i]);
            box.add(button[i]);
        }
 
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(box, BorderLayout.PAGE_START);
        return pane;
    }
    
    /**
     * Used by createHousePanel
     * to create a pane containing a description, a single column
     * of radio buttons, and a single column of check boxes.
     * Method Overwrite
     */
    private JPanel createPane(String description,
    		                  JRadioButton[] radioButton,
                              JCheckBox[] checkBox) {
 
        int numChoices = checkBox.length;
        int numPick = radioButton.length;
        
        JPanel box = new JPanel();
        JLabel label = new JLabel(description);
 
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.add(label);
 
        for(int i = 0; i < numPick; i++){
        	box.add(radioButton[i]);
        }
        
        for (int i = 0; i < numChoices; i++) {
            box.add(checkBox[i]);
        }
 
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(box, BorderLayout.PAGE_START);
        return pane;
    }
    
    /**
     * Used by createPlayerPanel
     * to create a pane containing a description, a label,
     * instructions, and the Set player name button.
     */
    private JPanel createPane(String description,
                             JTextField name,JLabel label, JButton add
                             , JLabel response) {
 
        JPanel box = new JPanel();
        JLabel label1 = new JLabel(description);
 
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.add(label1);
        box.add(label);
        box.add(name);
        box.add(response);
  
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(box, BorderLayout.PAGE_START);
        pane.add(add, BorderLayout.PAGE_END);
        return pane;
    }

    /**
     * Used by createPlayerPanel
     * to create a pane containing a description, a label,
     * instructions, and the Set player name button.
     */
    private JPanel createPane(String description,
                             JLabel[] label, JCheckBox[] checkBox) {
 
        JPanel box = new JPanel();
        JLabel label1 = new JLabel(description);
 
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.add(label1);
        
        for(int i = 0; i < 5; i++){
        	box.add(label[i]);
        	box.add(checkBox[i]);
        }
  
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(box, BorderLayout.PAGE_START);
        return pane;
    }
    
    
    
    
}

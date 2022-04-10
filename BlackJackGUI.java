package blackJack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BlackJackGUI extends JFrame implements ActionListener{
	//we create our variables for our GUI
	JButton newGameButton;
	JButton	hitButton;
	JButton standButton;
	private JPanel panel;
	private JLabel label;
	
	//we call the class BlackJackGame
	BlackJackGame game;
	
	//we make our boolean variables to check win/loss logics
	boolean startOfGame;
	boolean bust;
	boolean dealerWins;
	boolean dealerBust;
	boolean blackJackWin;
	boolean playerWins;
	boolean draw;
	
	BlackJackGUI (String title){
		super(title); //we set our title which is getting called from the RunGame class
		setSize(500,500); //we set our size
		setLayout(new BorderLayout()); //we use a Borderlayout as it looks more fitting
		
		//we initiate our BlackJackGame class
		game = new BlackJackGame();
		
		//we create our new game button
		newGameButton = new JButton("New Game");
		newGameButton.setToolTipText("Click me to play again");
		newGameButton.addActionListener(this);
		
		//we make our hit button
		hitButton = new JButton("Hit");
		hitButton.setToolTipText("Click me to get another card");
		hitButton.addActionListener(this);
		
		//we make our stand button
		standButton = new JButton("Stand");
		standButton.setToolTipText("Click me to stand and see if you are close to 21");
		standButton.addActionListener(this);
		
		//the label will display the information on the centre of the GUI
		label = new JLabel("                      Player gets: " + game.getPlayerCard() + "         Dealer gets: " + game.getDealerCard());
		
		//we give our GUI a blackjack table colour. or close to that colour
		panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.getHSBColor((float)0.347, (float)1, (float)0.5));
        
        //we position where the buttons will be at
        panel.add(newGameButton, BorderLayout.NORTH);
        panel.add(hitButton, BorderLayout.WEST);
        panel.add(standButton, BorderLayout.EAST);       
        panel.add(label, BorderLayout.CENTER);
        
        //we add the panel to the GUI
        add(panel);
          
        //and set its visibility to true
        setVisible(true);
        
        //before the game even begins, we set all of our conditions to false
        bust = false;
        dealerBust = false;
        startOfGame = false;
        dealerWins = false;
        playerWins = false;
        blackJackWin = false;
        draw = false;
	}
		
	@Override		
	public void actionPerformed(ActionEvent buttonClicked) 
	{	
		if (buttonClicked.getSource() == newGameButton) {
			
			//when the new game button is clicked. we call the method firsRound from BlackJackGame
			game.FirstRound();
			
			//we set all of our game conditions to false again except for startofgame. for error checking
			startOfGame = true;
			bust = false;
			dealerWins = false;
			dealerBust = false;
	        playerWins = false;
	        blackJackWin = false;
	        draw = false;
	        
	        label.setText("                      Player gets: " + game.getPlayerCard() + "           Dealer gets: " + game.getDealerCard());
		}
		
		//you cant click any other button other then newgame to begin playing
		if (startOfGame == false) {
			JOptionPane.showMessageDialog(this, "Click new game First!");
		}
		else {
			if (buttonClicked.getSource() == hitButton) {
					
				//if hit was clicked and startofgame is true
				//we call the method hit from the BlackJackGame
				game.hit();
				
				//and we give a popup text showing what card value they got
				JOptionPane.showMessageDialog(this,"You got: " + game.getNewCard());
				
				//we call the isbust boolean logic over to check if the player went over 21
				bust = game.isBust();
				
				//we display the card they got on the GUI
				label.setText("                      Player total: " + game.getPlayerTotal());
				
				//if the player went over 21, we display the messeages and set the startofgame to false 
				//as its the end of the round
				if(bust == true) {
					JOptionPane.showMessageDialog(this, "You bust! click new game to play again!");
					System.out.println("Bust!");
					label.setText("                      Player total: " + game.getPlayerTotal() + "           Dealer gets: " + game.getDealerTotal());
					startOfGame = false;
				}
			}
			if (buttonClicked.getSource() == standButton) {	
				
				//if stand is clicked and startofgame is true
				//we call the stand method from BlackJackGame
				game.stand();
				
				//and we call the win logic conditions over from BlackJackGame
				dealerWins = game.dealerWins();
				dealerBust = game.dealerBust();
				playerWins = game.playerWins();
				blackJackWin = game.blackJackWin();
				draw = game.draw();
				
				//we display the total of the cards for the player and dealer in the GUI
				label.setText("                      Player total: " + game.getPlayerTotal() + "           Dealer total: " + game.getDealerTotal());
				
				startOfGame = true;
				
				if(dealerWins == true) {
					JOptionPane.showMessageDialog(this, "dealer wins by biggest hand! click new game to play again!");
					System.out.println("dealer won!");
					label.setText("                      Player total: " + game.getPlayerTotal() + "           Dealer total: " + game.getDealerTotal());
					startOfGame = false;
				}
				
				if(dealerBust == true) {
					JOptionPane.showMessageDialog(this, "Dealer bust! click new game to play again!");
					System.out.println("Dealer went bust");
					label.setText("                      Player total: " + game.getPlayerTotal() + "           Dealer total: " + game.getDealerTotal());
					startOfGame = false;
				}
					
				if(playerWins == true) {
					JOptionPane.showMessageDialog(this, "You won by biggest hand! click new game to play again!");
					System.out.println("Player won!");
					label.setText("                      Player total: " + game.getPlayerTotal() + "           Dealer total: " + game.getDealerTotal());
					startOfGame = false;
				}
					
				if(blackJackWin == true) {
					JOptionPane.showMessageDialog(this, "WOOOOOOO 21 BLACKJACK!!!! click new game to play again!");
					System.out.println("Player won by blackJack!");
					label.setText("                      Player total: " + game.getPlayerTotal() + "           Dealer total: " + game.getDealerTotal());
					startOfGame = false;
				}
				
				if(draw == true) {
					JOptionPane.showMessageDialog(this,"Draw!");
					System.out.println("no winner, its a push!");
					label.setText("                      Player total: " + game.getPlayerTotal() + "           Dealer total: " + game.getDealerTotal());
					startOfGame = false;
				}
			}
		}
	}
}	



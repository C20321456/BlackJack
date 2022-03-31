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
	JButton newGameButton;
	JButton	hitButton;
	JButton standButton;
	private JPanel panel;
	private JLabel label;
	private JLabel label1;
	
	BlackJackGame game;
	
	boolean startOfGame;
	boolean bust;
	boolean dealerWins;
	boolean blackJackWin;
	boolean playerWins;
	
	BlackJackGUI (String title){
		super(title);
		setSize(500,500);
		setLayout(new BorderLayout());	
		
		game = new BlackJackGame();
		
		newGameButton = new JButton("New Game");
		newGameButton.setToolTipText("Click me to play again");
		newGameButton.addActionListener(this);
		
		hitButton = new JButton("Hit");
		hitButton.setToolTipText("Click me to get another card");
		hitButton.addActionListener(this);
		
		standButton = new JButton("Stand");
		standButton.setToolTipText("Click me to stand and see if you are close to 21");
		standButton.addActionListener(this);
		
		label = new JLabel("Player gets: " + game.getPlayerCard() + "     Dealer gets: " + game.getDealerCard());
		//label1 = new JLabel("Yolo");
		
		panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.getHSBColor((float)0.347, (float)1, (float)0.5));
        
        panel.add(newGameButton, BorderLayout.NORTH);
        panel.add(hitButton, BorderLayout.WEST);
        panel.add(standButton, BorderLayout.EAST);       
        panel.add(label, BorderLayout.CENTER);
        
        //label1.setVerticalAlignment(50);
        
        add(panel);
               
        setVisible(true);
        
        bust = false;
        startOfGame = false;
        dealerWins = false;
        playerWins = false;
        blackJackWin = false;
	}
		
	@Override		
	public void actionPerformed(ActionEvent event) 
	{	
		if (event.getSource() == newGameButton) {
			
			game.FirstRound();
			startOfGame = false;
			bust = false;
			dealerWins = false;
	        playerWins = false;
	        blackJackWin = false;
	        
	        label.setText("			Player gets: " + game.getPlayerCard() + "           Dealer gets: " + game.getDealerCard());
		}
		
		if (startOfGame == true) {
			JOptionPane.showMessageDialog(this, "Click new game First!");
		}
		else {
			if (event.getSource() == hitButton) {
					
				game.hit();
				JOptionPane.showMessageDialog(this,"You got: " + game.getNewCard());
				
				bust = game.isBust();
				label.setText("			Player gets: " + game.getPlayerCard() + "           Dealer gets: " + game.getDealerCard());
				
				if(bust == true) {
					JOptionPane.showMessageDialog(this, "You bust! click new game to play again!");
					System.out.println("Bust!");
					label.setText("			Player gets: " + game.getPlayerCard() + "           Dealer gets: " + game.getDealerCard());
					startOfGame = true;
				}
			}
			if (event.getSource() == standButton) {	
				
				game.stand();
				dealerWins = game.dealerWins();
				playerWins = game.playerWins();
				blackJackWin = game.blackJackWin();
				
				label.setText("			Player gets: " + game.getPlayerCard() + "           Dealer gets: " + game.getDealerCard());
				
				startOfGame = true;
				
				if(dealerWins == true) {
					JOptionPane.showMessageDialog(this, "dealer wins by biggest hand! click new game to play again!");
					System.out.println("dealer won!");
					label.setText("			Player gets: " + game.getPlayerCard() + "           Dealer gets: " + game.getDealerCard());
				}
					
				if(playerWins == true) {
					JOptionPane.showMessageDialog(this, "You won by biggest hand! click new game to play again!");
					System.out.println("Player won!");
					label.setText("			Player gets: " + game.getPlayerCard() + "           Dealer gets: " + game.getDealerCard());
				}
					
				if(blackJackWin == true) {
					JOptionPane.showMessageDialog(this, "WOOOOOOO 21 BLACKJACK!!!! click new game to play again!");
					System.out.println("Player won by blackJack!");
					label.setText("			Player gets: " + game.getPlayerCard() + "           Dealer gets: " + game.getDealerCard());
				}
			}
		}
	}
}	



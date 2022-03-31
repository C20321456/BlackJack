package blackJack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Inherited;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BlackJackGUI extends JFrame implements ActionListener{
	JButton button1;
	JButton	button2;
	JButton button3;
	JPanel panel;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JLabel label;
	JLabel label1;
	
	BlackJackGame game;
	
	boolean isBust;
	
	
	BlackJackGUI (String title){
		super(title);
		setSize(600,600);
		setLayout(new BorderLayout());	
		
		game = new BlackJackGame();
		
		button1 = new JButton("New Game");
		button1.setToolTipText("Click me to play again");
		button1.addActionListener(this);
		
		button2 = new JButton("Hit");
		button2.setToolTipText("Click me to get another card");
		button2.addActionListener(this);
		
		button3 = new JButton("Stand");
		button3.setToolTipText("Click me to stand and see if you are close to 21");
		button3.addActionListener(this);
		
		label = new JLabel("Your cards are: " + game.getPlayerCards() + "               Dealers cards are: " + game.getDealerCards());
		
		
		panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.red);
        
        panel.add(button1, BorderLayout.NORTH);
        add(panel);
        
        panel.add(button2, BorderLayout.WEST);
        add(panel);
        
        panel.add(button3, BorderLayout.EAST);
        add(panel);
        
        panel.add(label, BorderLayout.CENTER);
        add(panel);
        
        setVisible(true);
        
        isBust = false;
	}
		
	@Override		
	public void actionPerformed(ActionEvent event) 
	{	
		if (event.getSource() == button1) {
			JOptionPane.showMessageDialog(this, "You clicked new game");
			
			game.FirstRound();
		}
		
		if (event.getSource() == button2) {
			JOptionPane.showMessageDialog(this,"You clicked Hit");
			
			game.hit();
		}
		
		if (event.getSource() == button3) {
			JOptionPane.showMessageDialog(this, "You clicked Stand");
			
			game.stand();
		}
	}
	
	
	
}


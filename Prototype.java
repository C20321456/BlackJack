package blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Prototype {
	public static void main(String[] args) {
		
		List<Integer> deckOfCards = new ArrayList<Integer>(
				List.of(1,2,3,4,5,6,7,8,9,10,10,10,10,
			            1,2,3,4,5,6,7,8,9,10,10,10,10,
			            1,2,3,4,5,6,7,8,9,10,10,10,10,
			            1,2,3,4,5,6,7,8,9,10,10,10,10));
		String newGame = "yes";
		String newCard;
		
		int pickedCard;
		
		int player_card1;
		int player_card2;
		
		int dealer_card1;
		int dealer_card2;
		
		int player_Total = 0;
		int dealer_Total = 0;
		
		ArrayList<Integer> cardsCopy = new ArrayList<Integer>(deckOfCards);
		
		Scanner sc = new Scanner(System.in);
		Random random_Card = new Random();
		
		while(newGame.equals("yes"))
			{
				pickedCard = random_Card.nextInt(0, cardsCopy.size() + 1);
				player_card1 = deckOfCards.get(pickedCard);
				deckOfCards.remove(pickedCard);
				
				pickedCard = random_Card.nextInt(0, cardsCopy.size() + 1);
				player_card2 = deckOfCards.get(pickedCard);
				deckOfCards.remove(pickedCard);
				
				
				pickedCard = random_Card.nextInt(0, cardsCopy.size() + 1);
				dealer_card1 = deckOfCards.get(pickedCard);
				deckOfCards.remove(pickedCard);
				
				pickedCard = random_Card.nextInt(0, cardsCopy.size() + 1);
				dealer_card2 = deckOfCards.get(pickedCard);
				deckOfCards.remove(pickedCard);
				
				player_Total = player_card1 + player_card2;
				dealer_Total = dealer_card1 + dealer_card2;
				
				System.out.println("Dealers first card: " + dealer_card1);

				System.out.println("Your cards: " + player_card1 + " and " + player_card2);
				System.out.println("The card total is: " + player_Total);
				
				System.out.println("Would you like to play again? yes/no");
				
				newGame = sc.nextLine();
			}
		
		
		System.out.println("Your total was: " + player_Total);
		System.out.println("dealers total was: " + dealer_Total);
		
		System.out.println("Thank you for playing my game!");
	}

}

import java.util.Scanner;
import java.util.ArrayList;

public class PlayGame
	{
		static Scanner userInput = new Scanner(System.in);
		static String name;
		static ArrayList<Card> playerHand = new ArrayList<Card>();
		static ArrayList<Card> computerHand = new ArrayList<Card>();
		static int playerTotal = 0;
		static int computerTotal = 0;
		static Scanner userInputInt = new Scanner(System.in);

		public static void main(String[] args)
			{
				Deck.fillDeck();
				Deck.shuffleDeck();
				// opening();
				dealHands();
				actualPlay();
				endOfGame();
				playAgain();
			}

		public static void opening()
			{
				System.out.println("Hello player, and welcome to Blackjack!");
				System.out.println("I'll be your dealer today, what is your name?");
				name = userInput.nextLine();
				System.out.println("Hello " + name + ", press enter to play!");
				String play = userInput.nextLine();
			}

		public static void dealHands()
			{
				System.out.println(name + "'s hand is:");
				for (int i = 0; i < 2; i++)
					{
						playerHand.add(Deck.deck.get(0));
						System.out.println(Deck.deck.get(0).getRank() + " of " + Deck.deck.get(0).getSuit());
						playerTotal += Deck.deck.get(0).getValue();
						Deck.deck.remove(0);
					}
				System.out.println(name + "'s hand is a total of " + playerTotal);
				System.out.println();
				System.out.println("Press enter to see the computer's hand");
				userInput.nextLine();
				System.out.println("Computer's hand is:");
				for (int i = 0; i < 1; i++)
					{
						computerHand.add(Deck.deck.get(0));
						System.out.println(Deck.deck.get(0).getRank() + " of " + Deck.deck.get(0).getSuit());
						computerTotal = computerHand.get(0).getValue() + computerHand.get(0).getValue();
						Deck.deck.remove(0);
					}

			}

		public static void actualPlay()
			{
				System.out.println();
				System.out.println(name + " would you like to stay or hit?");
				String response = userInput.nextLine();
				if (response.equals("hit") || response.equals("Hit"))
					{
						playerHand.add(Deck.deck.get(0));
						System.out.println(name + " drew");
						System.out.println(Deck.deck.get(0).getRank() + " of " + Deck.deck.get(0).getSuit());
						playerTotal = playerTotal + Deck.deck.get(0).getValue();
						System.out.println(playerTotal);
						System.out.println("(Press enter)");
						userInput.nextLine();
						if (playerTotal > 21)
							{
								System.out.println("You just busted, you loose!");
								playAgain();

							}
						actualPlay();
					} 
					else if (response.equals("stay") || response.equals("Stay"))
					{
						System.out.println(name + "'s total is " + playerTotal);
						System.out.println("(Press enter)");
						userInput.nextLine();
						System.out.println("The computer's total currently is " + computerTotal);
						endOfGame();

					} 
					else
					{
						System.out.println("Invalid response, try again");
						actualPlay();
					}
			}

		public static void endOfGame()
			{
				if (computerTotal <= 16)
					{
						System.out.println("Computer chooses to hit");
						System.out.println("(Press enter)");
						userInput.nextLine();
						computerHand.add(Deck.deck.get(0));
						System.out.println(" Computer drew ");
						System.out.println(Deck.deck.get(0).getRank() + " of " + Deck.deck.get(0).getSuit());
						computerTotal = computerTotal + Deck.deck.get(0).getValue();
						Deck.deck.remove(0);
						if (computerTotal > 21)
							{
								System.out.println("Computer busted, you win!");
							}
						endOfGame();
					} 
					else
					{
					
					}
			}
		public static void playAgain()
		{
			
		}

	}

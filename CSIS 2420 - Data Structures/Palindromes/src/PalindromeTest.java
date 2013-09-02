/********************************************************
*  Project :  Assignment 07 - Palindromes
*  File    :  PalindromeTest.java
*  Name    :  Anthony Browness
*  Date    :  7/03/2013
*
*  Description : 
*
*    1) Purpose: Tests the Palindrome Class and its methods using a variety of
*    			 palindromic and non-palindromic sentences and words.
*     
*    2) Data-structures: N/A
*
*    3) Data-structure- Algorithms, Techniques, Implementations: N/A
*
*    4) Methods: 	setUp, test_pass1, test_pass2, test_pass3, test_pass4, 
*    				test_fail1, test_fail2, test_fail3, test_fail4, 
*
*  Changes : N/A
********************************************************/
import junit.framework.TestCase;

public class PalindromeTest extends TestCase
{
		private String pass1;
		private String pass2;
		private String pass3;
		private String pass4;
		private String fail1;
		private String fail2;
		private String fail3;
		private String fail4;

		/****************************************************
		* Method     : setUp
		*
		* Purpose    : Sets up various useful Strings for testing.
		*
		* Parameters : This method does not require parameters.
		*
		* Returns    : This method does not return a value.
		*
		****************************************************/
		public void setUp()
		{
			pass1 = "Dennis, Nell, Edna, Leon, Nedra, Anita, Rolf, Nora, Alice, Carol, Leo, Jane, Reed, Dena, Dale, Basil, Rae, Penny, Lana, Dave, Denny, Lena, Ida, Bernadette, Ben, Ray, Lila, Nina, Jo, Ira, Mara, Sara, Mario, Jan, Ina, Lily, Arne, Bette, Dan, Reba, Diane, Lynn, Ed, Eva, Dana, Lynne, Pearl, Isabel, Ada, Ned, Dee, Rena, Joel, Lora, Cecil, Aaron, Flora, Tina, Arden, Noel, and Ellen sinned.";
			pass2 = "mom";
			pass3 = "A man, a plan, a caret, a ban, a myriad, a sum, a lac, a liar, a hoop, a pint, a catalpa, a gas, an oil, a bird, a yell, a vat, a caw, a pax, a wag, a tax, a nay, a ram, a cap, a yam, a gay, a tsar, a wall, a car, a luger, a ward, a bin, a woman, a vassal, a wolf, a tuna, a nit, a pall, a fret, a watt, a bay, a daub, a tan, a cab, a datum, a gall, a hat, a fag, a zap, a say, a jaw, a lay, a wet, a gallop, a tug, a trot, a trap, a tram, a torr, a caper, a top, a tonk, a toll, a ball, a fair, a sax, a minim, a tenor, a bass, a passer, a capital, a rut, an amen, a ted, a cabal, a tang, a sun, an ass, a maw, a sag, a jam, a dam, a sub, a salt, an axon, a sail, an ad, a wadi, a radian, a room, a rood, a rip, a tad, a pariah, a revel, a reel, a reed, a pool, a plug, a pin, a peek, a parabola, a dog, a pat, a cud, a nu, a fan, a pal, a rum, a nod, an eta, a lag, an eel, a batik, a mug, a mot, a nap, a maxim, a mood, a leek, a grub, a gob, a gel, a drab, a citadel, a total, a cedar, a tap, a gag, a rat, a manor, a bar, a gal, a cola, a pap, a yaw, a tab, a raj, a gab, a nag, a pagan, a bag, a jar, a bat, a way, a papa, a local, a gar, a baron, a mat, a rag, a gap, a tar, a decal, a tot, a led, a tic, a bard, a leg, a bog, a burg, a keel, a doom, a mix, a map, an atom, a gum, a kit, a baleen, a gala, a ten, a don, a mural, a pan, a faun, a ducat, a pagoda, a lob, a rap, a keep, a nip, a gulp, a loop, a deer, a leer, a lever, a hair, a pad, a tapir, a door, a moor, an aid, a raid, a wad, an alias, an ox, an atlas, a bus, a madam, a jag, a saw, a mass, an anus, a gnat, a lab, a cadet, an em, a natural, a tip, a caress, a pass, a baronet, a minimax, a sari, a fall, a ballot, a knot, a pot, a rep, a carrot, a mart, a part, a tort, a gut, a poll, a gateway, a law, a jay, a sap, a zag, a fat, a hall, a gamut, a dab, a can, a tabu, a day, a batt, a waterfall, a patina, a nut, a flow, a lass, a van, a mow, a nib, a draw, a regular, a call, a war, a stay, a gam, a yap, a cam, a ray, an ax, a tag, a wax, a paw, a cat, a valley, a drib, a lion, a saga, a plat, a catnip, a pooh, a rail, a calamus, a dairyman, a bater, a canal - Panama!";
			pass4 = "Mood's mode! Pallas, I won! (Diaper pane, sold entire.) Melt till ever sere, hide it. Drown a more vile note; (Tar of rennet.) Ah, trowel, baton, eras ago. The reward? A \"nisi.\" Two nag. Otary tastes putrid, yam was green. Odes up and on; stare we. Rats nod. Nap used one-erg saw.(May dirt upset satyr?) A toga now; 'tis in a drawer, eh? Togas are notable. (Worth a tenner for Ate.) Tone liver. O Man, word-tied I. Here's revel! Little merit, Ned? Lose, Nap? Repaid now is all apedom's doom.";
			fail1 = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
			fail2 = "test";
			fail3 = "failed";
			fail4 = "But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?";
		}
		
		/****************************************************
		* Method     : test_pass1
		*
		* Purpose    : Tests a palindromic word/sentence.
		*
		* Parameters : This method does not require parameters.
		*
		* Returns    : This method does not return a value.
		*
		****************************************************/
		public void test_pass1()
		{
			Palindrome test = new Palindrome(pass1);
			assertTrue(test.testPalindrome());
		}

		/****************************************************
		* Method     : test_pass2
		*
		* Purpose    : Tests a palindromic word/sentence.
		*
		* Parameters : This method does not require parameters.
		*
		* Returns    : This method does not return a value.
		*
		****************************************************/
		public void test_pass2()
		{
			Palindrome test = new Palindrome(pass2);
			assertTrue(test.testPalindrome());
		}

		/****************************************************
		* Method     : test_pass3
		*
		* Purpose    : Tests a palindromic word/sentence.
		*
		* Parameters : This method does not require parameters.
		*
		* Returns    : This method does not return a value.
		*
		****************************************************/
		public void test_pass3()
		{
			Palindrome test = new Palindrome(pass3);
			assertTrue(test.testPalindrome());
		}

		/****************************************************
		* Method     : test_pass4
		*
		* Purpose    : Tests a palindromic word/sentence.
		*
		* Parameters : This method does not require parameters.
		*
		* Returns    : This method does not return a value.
		*
		****************************************************/
		public void test_pass4()
		{
			Palindrome test = new Palindrome(pass4);
			assertTrue(test.testPalindrome());
		}

		/****************************************************
		* Method     : test_fail1
		*
		* Purpose    : Tests a non-palindromic word/sentence.
		*
		* Parameters : This method does not require parameters.
		*
		* Returns    : This method does not return a value.
		*
		****************************************************/
		public void test_fail1()
		{
			Palindrome test = new Palindrome(fail1);
			assertFalse(test.testPalindrome());
		}

		/****************************************************
		* Method     : test_fail2
		*
		* Purpose    : Tests a non-palindromic word/sentence.
		*
		* Parameters : This method does not require parameters.
		*
		* Returns    : This method does not return a value.
		*
		****************************************************/
		public void test_fail2()
		{
			Palindrome test = new Palindrome(fail2);
			assertFalse(test.testPalindrome());
		}

		/****************************************************
		* Method     : test_fail3
		*
		* Purpose    : Tests a non-palindromic word/sentence.
		*
		* Parameters : This method does not require parameters.
		*
		* Returns    : This method does not return a value.
		*
		****************************************************/
		public void test_fail3()
		{
			Palindrome test = new Palindrome(fail3);
			assertFalse(test.testPalindrome());
		}

		/****************************************************
		* Method     : test_fail4
		*
		* Purpose    : Tests a non-palindromic word/sentence.
		*
		* Parameters : This method does not require parameters.
		*
		* Returns    : This method does not return a value.
		*
		****************************************************/
		public void test_fail4()
		{
			Palindrome test = new Palindrome(fail4);
			assertFalse(test.testPalindrome());
		}
}

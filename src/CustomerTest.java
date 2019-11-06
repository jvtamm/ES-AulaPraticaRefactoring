import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {
	@Test
	void testStatement() {
		Customer bob = new Customer("Bob");

		assertEquals("Rental Record for Bob\n" + "Amount owed is 0.0\n" + "You earned 0 frequent renter points",
        bob.statement());

		Movie hp1 = new Movie("Harry Potter and the Sorcerer's Stone", Movie.REGULAR);
		bob.addRental(new Rental(hp1, 10));

		assertEquals("Rental Record for Bob\n" + "\tHarry Potter and the Sorcerer's Stone\t14.0\n" + "Amount owed is 14.0\n"
				    + "You earned 1 frequent renter points", bob.statement());

		Movie hp2 = new Movie("Harry Potter and the Chamber of Secrets", Movie.NEW_RELEASE);
		bob.addRental(new Rental(hp2, 10));

		assertEquals("Rental Record for Bob\n" + "\tHarry Potter and the Sorcerer's Stone\t14.0\n" + 
                    "\tHarry Potter and the Chamber of Secrets\t30.0\n" + "Amount owed is 44.0\n" +
                    "You earned 3 frequent renter points", bob.statement());

	}
}
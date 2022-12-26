package test.echec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import echec.Joueur;
import echec.Partie;

public class JoueurTest {
	

	
	@Test
	public void testGetCoupIA() {
		Partie p = new Partie("IA", "IA");
		Joueur j = new Joueur("IA", "BLANC");
		String coup = j.getCoupIA(p);
		assert(coup.charAt(0) <= 'h' && coup.charAt(0) >= 'a');
		assert(coup.charAt(1) <= '8' && coup.charAt(1) >= '1');
		assert(coup.charAt(2) <= 'h' && coup.charAt(2) >= 'a');
		assert(coup.charAt(3) <= '8' && coup.charAt(3) >= '1');
	}
}

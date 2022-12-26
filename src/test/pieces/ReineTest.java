package test.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import echec.Echiquier;
import echec.pieces.Reine;

public class ReineTest {
	@Test
	public void testEstPossible() {
		Echiquier e = new Echiquier();
		Reine r = new Reine("BLANC", 4, 4);
		
		assertTrue(r.estPossible(e, 5, 4));

	}
	

	
	@Test
	public void testGetSymbole() {
		Reine d = new Reine("BLANC", 0, 0);
		assertEquals(d.getSymbole(), 'D');
		
		d = new Reine("NOIR", 0, 0);
		assertEquals(d.getSymbole(), 'd');
	}
}

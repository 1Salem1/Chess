package test.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import echec.Coordonnée;
import echec.Echiquier;
import echec.pieces.Roi;

public class RoiTest {
	@Test
	public void testEstPossible() {
		Echiquier e = new Echiquier();
		Roi r = new Roi("BLANC", 4, 4);

		assertTrue(r.estPossible(e, 3, 3));
		assertTrue(r.estPossible(e, 3, 4));
		assertTrue(r.estPossible(e, 3, 5));
		assertTrue(r.estPossible(e, 4, 3));
		assertTrue(r.estPossible(e, 4, 5));
		assertTrue(r.estPossible(e, 5, 3));
		assertTrue(r.estPossible(e, 5, 4));
		assertTrue(r.estPossible(e, 5, 4));

		assertFalse(r.estPossible(e, 5, 6));
		assertFalse(r.estPossible(e, 6, 5));
		assertFalse(r.estPossible(e, 2, 2));
	}

}
package test.pieces;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import echec.Coordonnée;
import echec.Echiquier;
import echec.pieces.Pièce;

public class PièceTest {

    @Test
    public void testDéplacer() {
    	
    	// TESTER LA CREATION D'UNE PIECE
    	
        Echiquier e = new Echiquier();
        Pièce p = new Pièce("BLANC", 2, 4);
        e.setPièce(2, 4, p);
        
        
        
        Coordonnée départ = new Coordonnée(2, 4);
        Coordonnée arrivée = new Coordonnée(2, 3);

        
        
        // DEPLACEMENT D'UNE PIECE
        p.déplacer(e, départ, arrivée);
        assertTrue(e.getPièce(4, 4) == null);
        assertTrue(e.getPièce(0, 0) == p);
   
    
    }

}
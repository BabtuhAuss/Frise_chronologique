package modele;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class FriseTest extends TestCase {

	@Test
	void testAjoutEvenement() {
		
		Evenement monEvt = new Evenement(new Date(1, 1, 2010), "event", "descripto", 0, "");
		Frise maFrise = new Frise("Ma frise de test", 2000,2018, 2);
		maFrise.ajout(monEvt);
		
		for(Evenement evt : maFrise.getEvenements()) {
			if(evt.toString().equals("event")) {
				return;
			}
		}		
		fail("L'ajout de l'événement a échoué !");
	}
	
	@Test 
	void testEcritureFrise() {
		fail("la frise n'a pas été ecrite !");
	}

}

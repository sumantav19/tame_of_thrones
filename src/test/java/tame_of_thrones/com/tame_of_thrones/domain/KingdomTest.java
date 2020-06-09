package tame_of_thrones.com.tame_of_thrones.domain;

import org.junit.Test;
import static org.junit.Assert.*;


public class KingdomTest {

  @Test public void testKingdomHasAllegiance(){
    Kingdom air =  new KingdomImpl("OWL","owl");
    Kingdom ice =  new KingdomImpl("ICE", "MAMMOTH");
    assertTrue("Air has allegiance", air.hasAllegiance("rozo"));
    assertFalse("Air has allegiance", air.hasAllegiance("OWLAOWLBOWLC"));
    assertTrue("ice has allegiance", ice.hasAllegiance("MOMAMVTMTMHTM"));
  }

}
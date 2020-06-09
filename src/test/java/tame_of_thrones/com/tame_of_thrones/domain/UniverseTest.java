package tame_of_thrones.com.tame_of_thrones.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class UniverseTest {

  @Test public void testWinKingdom(){
    UniverseImpl universe = new UniverseImpl();
    universe.addKingdom("FIRE", new  KingdomImpl("FIRE", "DRAGON"));
    assertTrue("won fire kingdom",universe.winKingdom("FIRE", "AJXGAMUTA"));
    assertFalse("Lost fire kingdom",universe.winKingdom("FIRE", "OWLAOWLBOWLC"));
    assertFalse("lost invalid kingdom", universe.winKingdom("KNOWWHWEW", "RANDOMMESSAGE"));
  }
  
}
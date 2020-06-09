package tame_of_thrones.com.tame_of_thrones;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;


public class GeekTrustTest {
  @Test public void testGeekTrustWinKingdom() throws Exception {
        GeekTrust classUnderTest = new GeekTrust();
        classUnderTest.createUniverse();
        File winningFile = new File("src/test/resources/winning-messages");
        FileInputStream winningStream = new FileInputStream(winningFile);
        Scanner winningSc = new Scanner(winningStream,"UTF-8");
        String wonKingdom = classUnderTest.ruleUniverse("SPACE", winningSc);
        assertTrue("space should win kingdoms", wonKingdom.equals("SPACE LAND ICE FIRE"));

        File whitespaceFile = new File("src/test/resources/whitespace-messages");
        FileInputStream whitespaceStream = new FileInputStream(whitespaceFile);
        Scanner whitespaceSc = new Scanner(whitespaceStream,"UTF-8");
        String whitespaceKingdom = classUnderTest.ruleUniverse("SPACE", whitespaceSc);
        assertTrue("space should win kingdoms", whitespaceKingdom.equals("SPACE FIRE AIR WATER"));

        File losingFile = new File("src/test/resources/losing-messages");
        FileInputStream losingStream = new FileInputStream(losingFile);
        Scanner losingSc = new Scanner(losingStream,"UTF-8");
        String lost = classUnderTest.ruleUniverse("SPACE", losingSc);
        assertTrue("space should lose", lost.equals("NONE"));
        
        File repeatFile = new File("src/test/resources/repeat-messages");
        FileInputStream repeatStream = new FileInputStream(repeatFile);
        Scanner repeatSc = new Scanner(repeatStream,"UTF-8");
        String repeatLost = classUnderTest.ruleUniverse("SPACE", repeatSc);
        assertTrue("space should lose", repeatLost.equals("NONE"));
    }  
}
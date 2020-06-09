package tame_of_thrones.com.tame_of_thrones.utils;

import org.junit.Test;
import static org.junit.Assert.*;

public class CipherTest {
  
  @Test public void testDecryptSeasar(){
    assertEquals("should decrypt ROZO to OLWL", "X", Cipher.decryptSeasar("A",3)); 
    assertEquals("should decrypt ROZO to OLWL", "OLWL", Cipher.decryptSeasar("ROZO",3)); 
    assertEquals("should decrypt rozo to OLWL", "OLWL", Cipher.decryptSeasar("rozo",3)); 
    assertEquals("should decrypt rozo to OLWL", "?LWL", Cipher.decryptSeasar("1ozo",3)); 
  }
}
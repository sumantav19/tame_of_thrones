package tame_of_thrones.com.tame_of_thrones.utils;

public class Cipher {

  public static String decryptSeasar(String message, int length){
    message = message.toUpperCase();
    StringBuilder decryptedMessage = new StringBuilder();
    for(int i = 0 ; i < message.length();i++){
      int curCode = (int)message.charAt(i);
      if(curCode > 90 || curCode < 65){
        decryptedMessage.append('?');
        continue;
      }
      int decryptedCode =  ((curCode - 65 - length  + 26)%26)+65;
      decryptedMessage.append((char) decryptedCode);
    }
    return decryptedMessage.toString();
  }
}
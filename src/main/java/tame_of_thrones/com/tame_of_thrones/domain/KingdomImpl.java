package tame_of_thrones.com.tame_of_thrones.domain;

import java.util.HashMap;
import java.util.Map;

import tame_of_thrones.com.tame_of_thrones.utils.Cipher;

public class KingdomImpl implements Kingdom {
  private String name;
  private String emblem;
  private Map <Character,Integer> emblemLetter; 

  public KingdomImpl(String name,String emblem){
    this.name = name;
    this.emblem = emblem.toUpperCase();
    this.emblemLetter =  new HashMap<Character,Integer>();
    countLetter();
  }

  public String getName(){
    return this.name;
  }

  private void countLetter(){
    for(int i = 0 ; i < this.emblem.length();i++){
      char currentChar = this.emblem.charAt(i);
        emblemLetter.computeIfPresent(currentChar,(key,val)->val+1);
        emblemLetter.putIfAbsent(currentChar, 1);
    }
  }

  @Override
  public Boolean hasAllegiance(String message) {
    // TODO Auto-generated method stub
    String decryptedMessage = Cipher.decryptSeasar(message,emblem.length());
    boolean allegiance =  validMessage(decryptedMessage);
    return allegiance;
  }

  private boolean validMessage(String message){
    HashMap<Character, Integer> charCount =  new HashMap<Character,Integer>();
    for(int i =0; i < message.length(); i++){
      char currChar = message.charAt(i);
      if(emblemLetter.containsKey(currChar)){
        charCount.computeIfPresent(currChar, (key, val)->val+1);
        charCount.putIfAbsent(currChar, 1);
      }
    }
    try {
      return emblemLetter.entrySet().stream().allMatch(
      e -> e.getValue() <= charCount.get(e.getKey()));  
    } catch (Exception e) {
      //TODO: handle exception
      return false;
    }
    
  }
  
}
package tame_of_thrones.com.tame_of_thrones;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashSet;
import java.util.Scanner;

import tame_of_thrones.com.tame_of_thrones.domain.Kingdom;
import tame_of_thrones.com.tame_of_thrones.domain.KingdomImpl;
import tame_of_thrones.com.tame_of_thrones.domain.Universe;
import tame_of_thrones.com.tame_of_thrones.domain.UniverseImpl;

public class GeekTrust {

  Universe southeros = new UniverseImpl();
  final int WIN_KINGDOM = 3;

  public void createUniverse(){
    Kingdom space =  new KingdomImpl("SPACE", "GORILLA");
    Kingdom land =  new KingdomImpl("LAND", "PANDA");
    Kingdom water =  new KingdomImpl("WATER", "OCTOPUS");
    Kingdom ice =  new KingdomImpl("ICE", "MAMMOTH");
    Kingdom air =  new KingdomImpl("AIR", "OWL");
    Kingdom fire =  new KingdomImpl("FIRE", "DRAGON");
    southeros.addKingdom("SPACE", space);
    southeros.addKingdom("LAND", land);
    southeros.addKingdom("WATER", water);
    southeros.addKingdom("ICE", ice);
    southeros.addKingdom("AIR", air);
    southeros.addKingdom("FIRE", fire);
  }

  public String ruleUniverse(String ruler,Scanner sc){
    LinkedHashSet<String> wonKingdom = new LinkedHashSet<String>();
    wonKingdom.add(ruler);
    while(sc.hasNextLine()){
      String current = sc.nextLine();
      String[] kingdomMessage = current.split(" ",2);
      String kingdomName =  kingdomMessage[0].toUpperCase();
      
      if(southeros.winKingdom(kingdomName, kingdomMessage[1])){
        wonKingdom.add(kingdomName);
      }
    }
    if (wonKingdom.size() < (WIN_KINGDOM+1)){
      return "NONE";
    }else{
      return String.join(" ",wonKingdom);
    }
  }

  public static void main(String[] args) {
    String filePath = args[0];
    File file = new File(filePath);
    GeekTrust geekTrust = new GeekTrust();
    geekTrust.createUniverse();
    try {
      FileInputStream stream = new FileInputStream(file);
      Scanner sc = new Scanner(stream, "UTF-8");
      System.out.println(geekTrust.ruleUniverse("SPACE",sc));
    } catch (Exception e) {
      System.out.println("NONE");
    }
  }

}
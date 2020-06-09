package tame_of_thrones.com.tame_of_thrones.domain;

import java.util.HashMap;
import java.util.Map;

public class UniverseImpl implements Universe{
  Map<String,Kingdom> universeMap =  new HashMap<String,Kingdom>();
  @Override
  public boolean addKingdom(String name,Kingdom kingdom) {
    // TODO Auto-generated method stub
    universeMap.put(name, kingdom);
    return false;
  }
  
  @Override
  public boolean winKingdom(String kingdomName, String message) {
    // TODO Auto-generated method stub
    Kingdom kingdom = universeMap.get(kingdomName);
    if (kingdom != null){
      return kingdom.hasAllegiance(message);
    }
    return false;
  }
}
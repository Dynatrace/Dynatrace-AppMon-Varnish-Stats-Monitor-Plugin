/**
 * Code for the key finder 
 * 
 * Parse by Key value
	        
	        JSONParser parser = new JSONParser();
	        KeyFinder finder = new KeyFinder();
	        finder.setMatchKey("value");
	        try{
	          while(!finder.isEnd()){
	            parser.parse(inS, finder, true);
	            if(finder.isFound()){
	              finder.setFound(false);
	              System.out.println("client_conn:");
	              System.out.println(finder.getValue());
	              log.info("client_conn:"+finder.getValue());
	            }
	          }           
	        }
	        catch(ParseException pe){
	          pe.printStackTrace();
	        }
	        
 */

package com.dynatrace.diagnostics.plugins.varnish;

import java.io.IOException;
import org.json.simple.parser.ContentHandler;
import org.json.simple.parser.ParseException;

class KeyFinder implements ContentHandler{
  private Object value;
  private boolean found = false;
  private boolean end = false;
  private String key;
  private String matchKey;
        
  public void setMatchKey(String matchKey){
    this.matchKey = matchKey;
  }
        
  public Object getValue(){
    return value;
  }
        
  public boolean isEnd(){
    return end;
  }
        
  public void setFound(boolean found){
    this.found = found;
  }
        
  public boolean isFound(){
    return found;
  }
        
  public void startJSON() throws ParseException, IOException {
    found = false;
    end = false;
  }

  public void endJSON() throws ParseException, IOException {
    end = true;
  }

  public boolean primitive(Object value) throws ParseException, IOException {
    if(key != null){
      if(key.equals(matchKey)){
        found = true;
        this.value = value;
        key = null;
        return false;
      }
    }
    return true;
  }

  public boolean startArray() throws ParseException, IOException {
    return true;
  }

        
  public boolean startObject() throws ParseException, IOException {
    return true;
  }

  public boolean startObjectEntry(String key) throws ParseException, IOException {
    this.key = key;
    return true;
  }
        
  public boolean endArray() throws ParseException, IOException {
    return false;
  }

  public boolean endObject() throws ParseException, IOException {
    return true;
  }

  public boolean endObjectEntry() throws ParseException, IOException {
    return true;
  }
}
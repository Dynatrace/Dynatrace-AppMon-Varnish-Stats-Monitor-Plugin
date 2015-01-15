/**
 * Code for parsing through Json files
 */

/** Parse Iterator
	        JSONParser parser =  new JSONParser();
            BasicContainerFactory bcfactory = new BasicContainerFactory();
            try {
                    Object json = parser.parse(inS, bcfactory);
                    JsonIterator.printRecursive(json);                   

            } catch (ParseException pe){
                    pe.printStackTrace(System.err);
            }
 */

package com.dynatrace.diagnostics.plugins.varnish;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonIterator {

        public static void print(Map m){
                Iterator iterator = m.entrySet().iterator();
            print(iterator);
        }
        
        public static void print(List l){
                Iterator iterator = l.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
        
        public static void printRecursive(Object o){
                if (o == null)
                        return;
                
                if (o instanceof java.util.LinkedList)
                        printRecursive((List) o);
                
                if (o instanceof java.util.HashMap)
                        printRecursive((Map) o);
                
        }
        
        private static void printRecursive(Map map){
                if (map == null)
                        return;
                
                if (map.size() > 0){
                        print(map);
                        
                        Iterator iterator = map.values().iterator();
                        Object o = null;
                        while(iterator.hasNext()){
                                o = iterator.next();
                                if ((o instanceof java.util.HashMap) || (o instanceof java.util.LinkedList))
                                        printRecursive(o);
                        }
                }
        }
        
        private static void printRecursive(List list){
                if (list == null)
                        return;
                
                if (list.size() > 0){
                        print(list);
                        
                        Iterator iterator = list.iterator();
                        Object o = null;
                        while(iterator.hasNext()){
                                o = iterator.next();
                                if ((o instanceof java.util.HashMap) || (o instanceof java.util.LinkedList))
                                        printRecursive(o);
                        }
                }
        }
        
        private static void print(Iterator iter){
                while(iter.hasNext()){
                      Map.Entry entry = (Map.Entry)iter.next();
                      System.out.println(entry.getKey() + " => " + entry.getValue());
                    }
        }
}
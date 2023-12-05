package org.nwolf.adventofcode2023;

import java.util.ArrayList;

public class Day5Map {
    
    String name;

    ArrayList<Long> destination_start = new ArrayList<Long>();
    ArrayList<Long> source_start = new ArrayList<Long>();;
    ArrayList<Long> range = new ArrayList<Long>();;

    public Day5Map(String name) {
        this.name = name;
    }   

    public void addLine(String map) {
        String[] mapArray = map.split(" ");
        try {
        destination_start.add(new Long(mapArray[0]));
        source_start.add(new Long(mapArray[1));
        range.add(new Long(mapArray[2])); 
        } catch (Exception e) {
            System.out.println("Error parsing map line: " + map);
        }
    }

    public long getDestination(long source) {
        for (int i=0; i < source_start.size(); i++) {
           Long current_source_start = source_start.get(i);
           Long current_range = range.get(i); 
           Long current_source_end = current_source_start + current_range;
           // Recherche de la source dans l'intervalle 
           if (source >= current_source_start && source <= current_source_end) {
               return source + source_start.get(i) - destination_start.get(i)
        }
        return source;
    }


}

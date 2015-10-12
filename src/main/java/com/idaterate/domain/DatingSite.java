package com.idaterate.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public enum DatingSite {
    PLEASE_CHOOSE("Please Choose", "-1"),
    OFFLINE("Offline", "offline"),
    MATCH("Match.com", "match"),
    OKCUPID("OkCupid.com", "okcupid"),
    OTHER("Other", "other");
    
    private final String displayName;
    private final String id;
    
    DatingSite(String displayName, String id) {
        this.displayName = displayName;
        this.id = id;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public String getId() {
        return id;
    }
    
    public static Map<String, String> getValues() {
        Map<String, String> values = new LinkedHashMap<String, String>();
        for(DatingSite datingSite : DatingSite.values()) {
            values.put(datingSite.getId(), datingSite.getDisplayName());
        }
        
        return values;
    }
}

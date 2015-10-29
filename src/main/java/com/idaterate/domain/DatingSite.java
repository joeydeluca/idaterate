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
    
    public static Map<String, String> getValues(boolean forSearch) {
        Map<String, String> values = new LinkedHashMap<String, String>();
        for(DatingSite datingSite : DatingSite.values()) {
            if(forSearch && DatingSite.PLEASE_CHOOSE.equals(datingSite)) {
                values.put("", "All");
            } else {
                values.put(datingSite.getId(), datingSite.getDisplayName());
            }
        }
        
        return values;
    }

    public static Map<String, String> getValues() {
        return getValues(false);
    }

    public static DatingSite getEnumFromId(String id) throws IllegalArgumentException {
        for(DatingSite datingSite : DatingSite.values()) {
            if(datingSite.getId().equals(id)) {
                return datingSite;
            }
        }

        throw new IllegalArgumentException("DatingSite enum id not found: " + id);
    }
}

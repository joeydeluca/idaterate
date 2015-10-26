package com.idaterate.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public enum DatingScore {
    PLEASE_CHOOSE("-1", "Please Choose"),
    ONE("1", "1"),
    TWO("2", "2"),
    THREE("3", "3"),
    FOUR("4", "4"),
    FIVE("5", "5"),
    SIX("6", "6"),
    SEVEN("7", "7"),
    EIGHT("8", "8"),
    NINE("9", "9"),
    TEN("10", "10");
    
    private final String displayName;
    private final String id;
    
    DatingScore(String id, String displayName) {
        this.displayName = displayName;
        this.id = id;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    public String getId() {
        return id;
    }
    
    public static Map<String, String> getDisplayNames() {
        Map<String, String> values = new LinkedHashMap<String, String>();
        for(DatingScore score : DatingScore.values()) {
            values.put(score.getId(), score.getDisplayName());
        }
        
        return values;
    }
}

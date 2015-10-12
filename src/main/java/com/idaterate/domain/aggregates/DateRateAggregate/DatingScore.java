package com.idaterate.domain.aggregates.DateRateAggregate;

import java.util.ArrayList;
import java.util.List;

public enum DatingScore {
    PLEASE_CHOOSE("Please Choose"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10");
    
    private final String displayName;
    
    DatingScore(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public static List<String> getDisplayNames() {
        List<String> displayNames = new ArrayList<String>();
        for(DatingScore datingSite : DatingScore.values()) {
            displayNames.add(datingSite.getDisplayName());
        }
        
        return displayNames;
    }
}

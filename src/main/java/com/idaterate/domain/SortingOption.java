package com.idaterate.domain;

/**
 * Created by Joe Deluca on 28/10/2015.
 */
public enum SortingOption {
    BEST_DATES("best", "Show Best Dates First"),
    WORST_DATES("worst", "Show Worst Dates First"),
    STANDARD("", "Sorting Options")
    ;

    private final String id;
    private final String display;

    SortingOption(String id, String display) {
        this.id = id;
        this.display = display;
    }

    public String getId() {
        return id;
    }
    public String getDisplay() {
        return display;
    }

    public static SortingOption getEnumFromId(String id) {
        for(SortingOption option : SortingOption.values()) {
            if(option.getId().equals(id)) {
                return option;
            }
        }

        return SortingOption.STANDARD;
    }
}

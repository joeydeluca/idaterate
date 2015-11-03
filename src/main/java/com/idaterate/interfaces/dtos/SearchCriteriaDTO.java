package com.idaterate.interfaces.dtos;

/**
 * Created by Joe Deluca on 27/10/2015.
 */
public class SearchCriteriaDTO {
    private String username;
    private String selectedDatingSite;
    private String hashtags;
    private String city;
    private String sortingOption;
    private int page;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSelectedDatingSite() {
        return selectedDatingSite;
    }

    public void setSelectedDatingSite(String selectedDatingSite) {
        this.selectedDatingSite = selectedDatingSite;
    }

    public String getHashtags() {
        return hashtags;
    }

    public void setHashtags(String hashtags) {
        this.hashtags = hashtags;
    }

    public String getSortingOption() {
        return sortingOption;
    }

    public void setSortingOption(String sortingOption) {
        this.sortingOption = sortingOption;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

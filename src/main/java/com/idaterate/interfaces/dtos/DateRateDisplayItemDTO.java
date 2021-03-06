package com.idaterate.interfaces.dtos;

import com.idaterate.domain.DateRate.DateRate;
import com.idaterate.domain.valueobejcts.DatingSite;

import java.util.List;

/**
 * Created by Joe Deluca on 03/10/2015.
 */
public class DateRateDisplayItemDTO {
    private long id;
    private String dateUsername;
    private String datingSite;
    private int score;
    private String description;
    private String city;
    private List<String> hashtags;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateUsername() {
        return dateUsername;
    }
    public void setDateUsername(String dateUsername) {
        this.dateUsername = dateUsername;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> getHashtags() {
        return hashtags;
    }
    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public String getDatingSite() {
        return datingSite;
    }

    public void setDatingSite(String datingSite) {
        this.datingSite = datingSite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public static DateRateDisplayItemDTO build(DateRate dateRate) {
        DateRateDisplayItemDTO dateRateDTO = new DateRateDisplayItemDTO();
        dateRateDTO.id = dateRate.getId();
        dateRateDTO.dateUsername = dateRate.getDateUsername();
        dateRateDTO.description = dateRate.getDescription();
        dateRateDTO.hashtags = dateRate.getHashtags();
        dateRateDTO.score = dateRate.getScore();
        dateRateDTO.city = dateRate.getCity();

        try {
            DatingSite datingSite = DatingSite.getEnumFromId(dateRate.getDatingSite());
            dateRateDTO.setDatingSite(datingSite.getDisplayName());
        } catch (IllegalArgumentException e) {
            dateRateDTO.setDatingSite(dateRate.getDatingSite());
        }

        return dateRateDTO;
    }
}

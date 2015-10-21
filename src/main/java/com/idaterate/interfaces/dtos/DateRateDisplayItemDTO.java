package com.idaterate.interfaces.dtos;

import com.idaterate.domain.DateRate;
import com.idaterate.domain.DatingSite;

import java.util.List;

/**
 * Created by Joe Deluca on 03/10/2015.
 */
public class DateRateDisplayItemDTO {
    private String dateUsername;
    private String datingSite;
    private int score;
    private String description;
    private List<String> hashtags;

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

    public static DateRateDisplayItemDTO build(DateRate dateRate) {
        DateRateDisplayItemDTO dateRateDTO = new DateRateDisplayItemDTO();
        dateRateDTO.dateUsername = dateRate.getDateUsername();
        dateRateDTO.description = dateRate.getDescription();
        dateRateDTO.hashtags = dateRate.getHashtags();
        dateRateDTO.score = dateRate.getScore();

        try {
            DatingSite datingSite = DatingSite.getEnumFromId(dateRate.getDatingSite());
            dateRateDTO.setDatingSite(datingSite.getDisplayName());
        } catch (IllegalArgumentException e) {
            dateRateDTO.setDatingSite(dateRate.getDatingSite());
        }

        return dateRateDTO;
    }
}

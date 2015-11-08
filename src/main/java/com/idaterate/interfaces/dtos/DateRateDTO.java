package com.idaterate.interfaces.dtos;

import com.idaterate.domain.DateRate;
import com.idaterate.domain.DatingSite;

import java.util.List;

/**
 * Created by Joe Deluca on 03/10/2015.
 */
public class DateRateDTO {
    private String id;
    private String dateUsername;
    private String predefinedDatingSite;
    private String userDefinedDatingSite;
    private int score = 5;
    private String description;
    private String city;
    private List<String> hashtags;
    private String recaptcha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    public String getPredefinedDatingSite() {
        return predefinedDatingSite;
    }
    public void setPredefinedDatingSite(String predefinedDatingSite) {
        this.predefinedDatingSite = predefinedDatingSite;
    }
    public String getUserDefinedDatingSite() {
        return userDefinedDatingSite;
    }
    public void setUserDefinedDatingSite(String userDefinedDatingSite) {
        this.userDefinedDatingSite = userDefinedDatingSite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRecaptcha() {
        return recaptcha;
    }

    public void setRecaptcha(String recaptcha) {
        this.recaptcha = recaptcha;
    }

    public DateRate toDateRate() {
        DateRate dateRate = new DateRate();
        dateRate.setDateUsername(dateUsername);
        dateRate.setDescription(description);
        dateRate.setHashtags(hashtags);
        dateRate.setScore(score);
        dateRate.setCity(city);
        if(DatingSite.OTHER.getId().equals(predefinedDatingSite)) {
            dateRate.setDatingSite(userDefinedDatingSite);
        } else {
            dateRate.setDatingSite(predefinedDatingSite);
        }

        return dateRate;
    }
}

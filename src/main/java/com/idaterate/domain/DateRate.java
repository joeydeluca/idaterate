package com.idaterate.domain;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DateRate {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String dateUsername;
    private String datingSite;
    private int score;
    private String description;
    @ElementCollection(targetClass=String.class)
    private List<String> hashtags;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDateUsername() {
        return dateUsername;
    }
    public void setDateUsername(String dateUsername) {
        this.dateUsername = dateUsername;
    }
    public String getDatingSite() {
        return datingSite;
    }
    public void setDatingSite(String datingSite) {
        this.datingSite = datingSite;
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
  
    
}

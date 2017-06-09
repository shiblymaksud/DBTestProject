package com.megatrendsit.dbtestproject.model;

/**
 * Created by Maksud on 6/9/2017.
 */

public class Verses {
    private String verse;
    private String bengali;
    private String english;
    private String arabic;

    public Verses(String verse, String bengali, String english, String arabic) {
        this.verse = verse;
        this.bengali = bengali;
        this.english = english;
        this.arabic = arabic;
    }

    public String getVerse() {
        return verse;
    }

    public void setVerse(String verse) {
        this.verse = verse;
    }

    public String getBengali() {
        return bengali;
    }

    public void setBengali(String bengali) {
        this.bengali = bengali;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }
}

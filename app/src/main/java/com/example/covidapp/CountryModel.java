package com.example.covidapp;

public class CountryModel {
    private String flag,deaths,country,cases,todayCases,todayDeaths,recovered,active,critical;

    public CountryModel() {
    }

    public CountryModel(String flag, String deaths, String country, String cases, String todayCases, String todayDeaths, String recovered, String active, String critical) {
        this.flag = flag;
        this.deaths = deaths;
        this.country = country;
        this.cases = cases;
        this.todayCases = todayCases;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
        this.active = active;
        this.critical = critical;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public String getFlag() {
        return flag;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getCountry() {
        return country;
    }

    public String getCases() {
        return cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getActive() {
        return active;
    }

    public String getCritical() {
        return critical;
    }
}

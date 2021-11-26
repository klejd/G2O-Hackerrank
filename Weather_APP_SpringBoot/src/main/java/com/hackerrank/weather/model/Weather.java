package com.hackerrank.weather.model;

//import org.springframework.expression.ParseException;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
   
   
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date ;

    private Float lat;
    private Float lon;
    private String city;
    private String state;

    @ElementCollection
    @CollectionTable(name = "weather_temperature")
    private List<Double> temperatures;

    public Weather(Integer id, Date date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.id = id;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

    public Weather(Date date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

    public Weather() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
    	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	  return formatter.format(date);
        
    }

    public void setDate(Date date) {
    	 
    	
        this.date = date;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Double> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<Double> temperatures) {
        this.temperatures = temperatures;
    }
}

package com.hackerrank.weather.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;

@Service
public class weatherservices {
	@Autowired
	private WeatherRepository weatherrepository;
	
	public Weather addWeather(Weather weather) {
		
		return weatherrepository.save(weather);
		
	}
	public Weather getWeatherById(int id) throws ParseException {
//	
		Weather weather = weatherrepository.findById(id).orElse(null);
		
		return weather;
	}
	public List<Weather>  getAllWeathers() {
		return weatherrepository.findAll();
		
		
	}
	public List<Weather>  getAllWeathers(String city) {
		return weatherrepository.getAllWeathersByCity(city);
		
		
	}
	public List<Weather>  getAllWeathersByDate(String date) {
		return weatherrepository.getAllWeathersByCity(date);
		
		
	}
	public List<Weather>  getAllWeathersByDateSorted(String sort) {
		return weatherrepository.findAll();
		
		
	}
}

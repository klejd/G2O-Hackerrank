package com.hackerrank.weather.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;
import com.hackerrank.weather.services.weatherservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherApiRestController {
  @Autowired
  private weatherservices weatherservice;
  @PostMapping("/weather" )
  public ResponseEntity<?> addWeather(@RequestBody Weather weather){
	  if(weather==null) {
		  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	  }
	 
	
	  return new ResponseEntity<>(weatherservice.addWeather(weather),HttpStatus.CREATED);
  }
  @GetMapping("/weather/{id}")
   public ResponseEntity<?> findWeatherById(@PathVariable int id) throws ParseException{
	 Weather weather = null;
	 
	 weather = weatherservice.getWeatherById(id); 
	 System.out.println(weather);
	 if(weather==null) {
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }else
	  return ResponseEntity.ok(weather);
	  
  }
  @GetMapping("/weather")
  public ResponseEntity<?> getAll (){
	ArrayList<Weather> list = new ArrayList<>( weatherservice.getAllWeathers());
	Collections.sort(list,new Comparator<Weather>() {

		@Override
		public int compare(Weather o1, Weather o2) {
			
			return o1.getId()-o2.getId();
		}
		
	});
	return ResponseEntity.ok(list);
	
  }
  
  
  @GetMapping(value="/weather", params = "city" )
  public ResponseEntity<?> getAllByCity (@RequestParam(required = false)String city){
	ArrayList<Weather> list = new ArrayList<>( weatherservice.getAllWeathers(city));
	Collections.sort(list,new Comparator<Weather>() {

		@Override
		public int compare(Weather o1, Weather o2) {
			
			return o1.getId()-o2.getId();
		}
		
	});
	return ResponseEntity.ok(list);
	
  }
  @GetMapping(value="/weather", params = "date" )
  public ResponseEntity<?> getAllByDate (@RequestParam(required = false) String date){
	ArrayList<Weather> list = new ArrayList<>( weatherservice.getAllWeathersByDate(date));
	Collections.sort(list,new Comparator<Weather>() {

		@Override
		public int compare(Weather o1, Weather o2) {
			
			return o1.getId()-o2.getId();
		}
		
	});
	return ResponseEntity.ok(list);
	
  }

@GetMapping(value="/weather", params = "sort" )
public ResponseEntity<?> getAllByDateSorted (@RequestParam(required = false) String sort){
	ArrayList<Weather> list = new ArrayList<>( weatherservice.getAllWeathersByDateSorted(sort));
	System.out.println(list.size());
	if(sort.equals("date")) {
		Collections.sort(list,new Comparator<Weather>() {

			@Override
			public int compare(Weather o1, Weather o2) {
				
				return o1.getDate().compareTo(o2.getDate());
			}
			
		});}
		System.out.println(list);

	if(sort.equals("-date")) {
		Collections.sort(list,new Comparator<Weather>() {

			@Override
			public int compare(Weather o1, Weather o2) {
				
				return o2.getDate().compareTo(o1.getDate());
			}
			
		});		
}

	return ResponseEntity.ok(list);
	
}

}

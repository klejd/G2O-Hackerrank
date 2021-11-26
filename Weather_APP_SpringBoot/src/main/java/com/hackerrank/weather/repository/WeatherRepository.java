package com.hackerrank.weather.repository;

import com.hackerrank.weather.model.Weather;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
	@Query(value = "select * from weather s where s.city ilike %:city% ", nativeQuery = true)
	public List<Weather>  getAllWeathersByCity(String city);
	
	@Query(value = "select * from weather s where s.date ilike %:date% ", nativeQuery = true)
	public List<Weather>  getAllWeathersByDate(String date);
	
//	@Query(value = "select * from weather s where s.date like %:sort% ", nativeQuery = true)
//	public List<Weather>  getAllWeathersByDateSorted(String sort);
}


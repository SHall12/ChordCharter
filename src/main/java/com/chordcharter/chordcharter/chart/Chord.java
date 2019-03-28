package com.chordcharter.chordcharter.chart;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Chord {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JsonBackReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Chart chart;
	
	private String name;

	@Min(value = 0, message = "Starting position cannot be negative")
	@Max(value = 30, message = "Starting position cannot be > 30")
	private int position;
	
	@ElementCollection
	@NotNull
	@Size(min = 4, max = 12)
	private List<Integer> frets; // TODO: Validate values <6

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}

	public List<Integer> getFrets() {
		return frets;
	}

	public void setFrets(List<Integer> frets) {
		this.frets = frets;
	}
}

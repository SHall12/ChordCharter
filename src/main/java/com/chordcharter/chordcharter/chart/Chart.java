package com.chordcharter.chordcharter.chart;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Chart {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long userId;
	private String name;
	
	@OneToMany(mappedBy="chart", fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JsonManagedReference
	private List<Chord> chords;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chord> getChords() {
		return chords;
	}
	
	// TODO: check is valid
	public void addChord(Chord chord) {
		this.chords.add(chord);
	}

	public void setChords(List<Chord> chords) {
		this.chords = chords;
	}
}

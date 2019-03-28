package com.chordcharter.chordcharter.chart;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/charts")
public class ChartController {
	
	@Autowired
	private ChartService chartService; 
	// TODO: Use service instead w/ transactions
	// TODO: Add initBinder
	
	@GetMapping(path="/", produces="application/json")
	public List<Chart> getCharts() {
	    return chartService.getCharts();
	}
	
	@GetMapping(path="/{id}", produces="application/json")
	public Chart getChart(@PathVariable long id) {
		Optional<Chart> chart = chartService.getChart(id);
	    return chart.get();
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteChart(@PathVariable long id) {
	    chartService.deleteChart(id);
	}
	
	@PostMapping(path="/")
	public Chart createChart(@RequestBody Chart chart) {
		return chartService.createChart(chart);
	}
	
	@GetMapping(path="/{chartId}/chords", produces="application/json")
	public List<Chord> getChordsFor(@PathVariable long chartId) {
	    return chartService.getChords(chartId);
	}
	
	@PostMapping(path="/{chartId}/chords")
	public Chart addChord(@PathVariable long chartId, @RequestBody Chord chord) {
		return chartService.addChord(chartId, chord);
	}
}

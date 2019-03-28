package com.chordcharter.chordcharter.chart;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ChartService {

	@Autowired
	private ChartRepository chartRepository;

	public List<Chart> getCharts() {
		return chartRepository.findAll();
	}

	public Optional<Chart> getChart(long id) {
		return chartRepository.findById(id);
	}

	public Chart createChart(Chart chart) {
		// TODO: Figure out why chords not including chart_id when persisting.
		for (Chord chord : chart.getChords()) {
			chord.setChart(chart);
		}
		return chartRepository.saveAndFlush(chart);
	}

	public void deleteChart(long id) {
		chartRepository.deleteById(id);
	}

	public Chart addChord(long id, Chord chord) {
		Chart chart = chartRepository.getOne(id);
		chart.addChord(chord);
		return chartRepository.saveAndFlush(chart);
	}

	public List<Chord> getChords(long id) {
		Chart chart = chartRepository.getOne(id);
		return chart.getChords();
	}
}

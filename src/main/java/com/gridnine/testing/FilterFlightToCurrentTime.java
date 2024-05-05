package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FilterFlightToCurrentTime implements FlightProcessing {
    @Override
    public List<Flight> filterProcess(List<Flight> data) {
        return data.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now())))
                .collect(Collectors.toList());
    }
}

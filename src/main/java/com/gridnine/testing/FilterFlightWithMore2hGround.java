package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterFlightWithMore2hGround implements FlightProcessing{
    @Override
    public List<Flight> filterProcess(List<Flight> data) {
        return data.stream()
                .filter(flight -> flight.getSegments().size() > 1)
                .filter(flight -> calculateTotalDuration(flight).compareTo(Duration.ofHours(2)) >= 0)
                .collect(Collectors.toList());
    }
    private Duration calculateTotalDuration(Flight flight) {
        return flight.getSegments().stream()
                .limit(flight.getSegments().size() - 1)
                .map(segment -> Duration.between(segment.getArrivalDate(), flight.getSegments().get(flight.getSegments().indexOf(segment) + 1).getDepartureDate()))
                .reduce(Duration.ZERO, Duration::plus);
    }
}

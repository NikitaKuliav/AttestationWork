package com.gridnine.testing;

public enum Filters {
    FLIGHT_TO_CURRENT_TIME("вылет до текущего момента времени"),
    FLIGHT_WITH_CONFLICT_SEGMENTS("сегменты с датой прилёта раньше даты вылета"),
    FLIGHT_WITH_MORE2H_GROUND("перелеты, где общее время, проведённое на земле, превышает два часа");

    private final String description;

    Filters(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}

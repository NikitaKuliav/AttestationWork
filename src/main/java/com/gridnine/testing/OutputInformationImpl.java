package com.gridnine.testing;

import java.util.List;

public class OutputInformationImpl implements OutputInformation {
    @Override
    public void printFlightInfo(List<Flight> data, Filters filters) {
        String header = "======\n" +
                "ФИЛЬТР (ИСКЛЮЧЕНИЕ): " + filters.getDescription() + "\n";
        String footer = "======\n";

        StringBuilder info = new StringBuilder();

        for (Flight datum : data) {
            info.append(datum.toString()).append("\n");
        }

        System.out.println(header + info + footer);
    }
}

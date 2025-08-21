package service.impl;

import java.util.Map;
import java.util.StringJoiner;
import service.ReportGenerator;
import storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        Map<String, Integer> fruitBalance = Storage.getFruitDbResult();

        StringJoiner reportBuilder = new StringJoiner(System.lineSeparator());
        reportBuilder.add("fruit,quantity");

        for (Map.Entry<String, Integer> entry : fruitBalance.entrySet()) {
            reportBuilder.add(entry.getKey() + "," + entry.getValue());
        }

        return reportBuilder.toString();
    }

}

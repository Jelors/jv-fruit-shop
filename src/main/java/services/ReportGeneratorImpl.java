package services;

import java.util.Map;
import java.util.StringJoiner;
import models.ReportGenerator;
import storage.Storage;

public class ReportGeneratorImpl implements ReportGenerator {

    @Override
    public String getReport() {
        Map<String, Integer> fruitBalance = Storage.fruitDbResult;

        StringJoiner reportBuilder = new StringJoiner(System.lineSeparator());
        reportBuilder.add("fruit,quantity");

        for (Map.Entry<String, Integer> entry : fruitBalance.entrySet()) {
            reportBuilder.add(entry.getKey() + "," + entry.getValue());
        }

        return reportBuilder.toString();
    }

}

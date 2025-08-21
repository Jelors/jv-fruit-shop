package models;

import services.FruitTransaction;

import java.util.List;

public interface CsvFileReader {
    List<FruitTransaction> read(String filePath);
}

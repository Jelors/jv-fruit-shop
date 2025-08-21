package models;

import java.util.List;
import services.FruitTransaction;

public interface CsvFileReader {
    List<FruitTransaction> read(String filePath);
}


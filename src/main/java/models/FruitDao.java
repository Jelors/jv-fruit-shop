package models;

import services.FruitTransaction;

public interface FruitDao {
    FruitTransaction getFromCsvData(String line);
}

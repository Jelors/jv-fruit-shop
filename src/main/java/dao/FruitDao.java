package dao;

import model.FruitTransaction;

public interface FruitDao {
    FruitTransaction getFromCsvData(String line);
}

package service.impl;

import model.FruitTransaction;
import service.FruitDao;

public class FruitDaoImpl implements FruitDao {
    @Override
    public FruitTransaction getFromCsvData(String line) {
        if (line == null) {
            throw new RuntimeException(
                    "Line cannot be null");
        }
        String[] fields = line.split(",");
        if (fields.length != 3) {
            throw new RuntimeException(
                    "Array length can be more or less than 3!");
        }
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        if (Integer.parseInt(fields[2]) < 0) {
            throw new RuntimeException(
                    "Quantity cannot be negative " + fields[2]);
        }
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}

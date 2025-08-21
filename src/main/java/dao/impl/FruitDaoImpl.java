package dao.impl;

import models.FruitDao;
import services.FruitTransaction;
import storage.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public FruitTransaction getFromCsvData(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        Storage.fruitDbInput.add(fruitTransaction);
        return fruitTransaction;
    }
}

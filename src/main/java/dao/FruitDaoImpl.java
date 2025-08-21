package dao;

import model.FruitTransaction;
import storage.Storage;

public class FruitDaoImpl implements FruitDao {
    @Override
    public FruitTransaction getFromCsvData(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation.valueOf(fields[0]));
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        Storage.fruitDb.add(fruitTransaction);
        return fruitTransaction;
    }
}

package models;

import services.FruitTransaction;

import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactionList);
}

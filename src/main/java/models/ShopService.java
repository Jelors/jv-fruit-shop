package models;

import java.util.List;
import services.FruitTransaction;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactionList);
}

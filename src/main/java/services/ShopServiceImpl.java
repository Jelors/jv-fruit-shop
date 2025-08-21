package services;

import models.ShopService;
import storage.Storage;
import models.OperationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        Map<String, Integer> fruitStock = new HashMap<>();

        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            String fruitName = fruitTransaction.getFruit();
            int currentAmount = fruitStock.getOrDefault(fruitName, 0);

            int updatedAmount = operationStrategy.applyOperation(fruitTransaction, currentAmount);
            fruitStock.put(fruitName, updatedAmount);
        }
        Storage.fruitDbResult.putAll(fruitStock);
    }
}

package handler.impl;

import models.OperationHandler;
import services.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public int getOperation(FruitTransaction data, int amount) {
        return data.getQuantity();
    }
}

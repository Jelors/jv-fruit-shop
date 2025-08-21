package handler;

import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public int getOperation(FruitTransaction data, int amount) {
        return data.getQuantity();
    }
}

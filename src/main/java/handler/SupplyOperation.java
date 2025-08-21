package handler;

import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public int getOperation(FruitTransaction data, int amount) {
        return data.getQuantity() + amount;
    }
}

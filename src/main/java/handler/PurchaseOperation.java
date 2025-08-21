package handler;

import model.FruitTransaction;

public class PurchaseOperation implements  OperationHandler {
    @Override
    public int getOperation(FruitTransaction data, int amount) {
        return data.getQuantity() - amount;
    }
}

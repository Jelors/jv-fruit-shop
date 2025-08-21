package handler;

import models.OperationHandler;
import services.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int getOperation(FruitTransaction data, int amount) {
        return amount - data.getQuantity();
    }
}

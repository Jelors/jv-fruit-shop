package handler;

import models.OperationHandler;
import services.FruitTransaction;

public class ReturnOperation implements OperationHandler {

    @Override
    public int getOperation(FruitTransaction data, int amount) {
        return data.getQuantity() + amount;
    }
}

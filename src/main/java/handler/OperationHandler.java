package handler;

import model.FruitTransaction;

public interface OperationHandler {
    int getOperation(FruitTransaction data, int amount);
}

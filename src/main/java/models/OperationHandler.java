package models;

import services.FruitTransaction;

public interface OperationHandler {
    int getOperation(FruitTransaction data, int amount);
}

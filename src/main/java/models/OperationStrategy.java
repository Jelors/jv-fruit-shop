package models;

import services.FruitTransaction;

public interface OperationStrategy {
    OperationHandler getOperation(FruitTransaction.Operation type);
    int applyOperation(FruitTransaction transaction, int currentAmount);
}
package handler;

import model.FruitTransaction;

public interface OperationHandler {
    FruitTransaction.Operation getOperation(FruitTransaction.Operation operation);
}

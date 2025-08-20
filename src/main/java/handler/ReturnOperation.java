package handler;

import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public FruitTransaction.Operation getOperation(FruitTransaction.Operation operation) {
        return FruitTransaction.Operation.RETURN;
    }
}

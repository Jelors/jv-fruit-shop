package handler;

import model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public FruitTransaction.Operation getOperation(FruitTransaction.Operation operation) {
        return FruitTransaction.Operation.SUPPLY;
    }
}

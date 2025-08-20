package handler;

import model.FruitTransaction;

public class PurchaseOperation implements  OperationHandler {
    @Override
    public FruitTransaction.Operation getOperation(FruitTransaction.Operation operation) {
        return FruitTransaction.Operation.PURCHASE;
    }
}

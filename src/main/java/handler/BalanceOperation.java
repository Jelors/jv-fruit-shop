package handler;

import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public FruitTransaction.Operation getOperation(FruitTransaction.Operation operation) {
        return FruitTransaction.Operation.BALANCE;
    }
}

package strategy;

import model.FruitTransaction;
import handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation type);
}

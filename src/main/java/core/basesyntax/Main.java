package core.basesyntax;

import dao.impl.FruitDaoImpl;
import models.CsvFileWriter;
import models.ReportGenerator;
import models.ShopService;
import services.ReportGeneratorImpl;
import services.ShopServiceImpl;
import storage.Storage;
import models.CsvFileReader;
import workWithFile.fromFile.impl.CsvFileReaderImpl;
import handler.impl.BalanceOperation;
import models.OperationHandler;
import handler.impl.PurchaseOperation;
import handler.impl.ReturnOperation;
import handler.impl.SupplyOperation;
import services.FruitTransaction;
import models.OperationStrategy;
import strategy.impl.OperationStrategyImpl;
import workWithFile.toFile.impl.CsvFileWriterImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvFileReader reader = new CsvFileReaderImpl(new FruitDaoImpl());
        List<FruitTransaction> transactions = reader.read("input.csv");

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        CsvFileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.write(resultingReport, "finalReport.csv");
    }
}

/*
    Привіт! Це завдання є першим таким організаційним моїм квестом,
     тому тут скоріше за все досить багато
     помилок, як би я не старався це упорядкувати (саме тому я тут пишу зараз).

     Запитання: чи потрібно та, чи радше доцільно виносити
        всі інтерфейси в окрему папку, чи все ж краще
        лишати кожен окремий інтерфейс з реалізованим класом імплементації.

        Папка "file" спочатку мала назву на подобі workWithFile
            і ділилась на fromFile та toFile
            (читання та запис відповідно),
            так не найкраще найменування, але навіть його довелось змінити через
            лінтер, тому зараз так жахливо виглядає (file.To та file.From). (sorry)

        Реалізував завдання цілком як міг,
            при цьому, не оброблено багато помилок та вийнятків які можуть траплятись;
            наскільки розумію це вже в іншому завданні, тому так.

        Дякую за увагу :)
 */

package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CsvFileReader;
import service.CsvFileWriter;
import service.ReportGenerator;
import service.ShopService;
import service.impl.CsvFileReaderImpl;
import service.impl.CsvFileWriterImpl;
import service.impl.FruitDaoImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.impl.BalanceOperation;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseOperation;
import strategy.impl.ReturnOperation;
import strategy.impl.SupplyOperation;

public class Main {
    private static final String inputPath = "src/main/resources/input.csv";
    private static final String reportPath = "src/main/resources/finalReport.csv";

    public static void main(String[] args) {
        CsvFileReader reader = new CsvFileReaderImpl(new FruitDaoImpl());

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        operationHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        List<FruitTransaction> transactions = reader.read(inputPath);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String resultingReport = reportGenerator.getReport();

        CsvFileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.write(resultingReport, reportPath);
    }
}


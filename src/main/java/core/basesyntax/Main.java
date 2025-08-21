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













/*
package core.basesyntax;

import dao.impl.FruitDaoImpl;
import models.CsvFileWriter;
import models.ReportGenerator;
import models.ShopService;
import services.ReportGeneratorImpl;
import services.ShopServiceImpl;
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
*/

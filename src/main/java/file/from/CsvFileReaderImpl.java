package file.from;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.CsvFileReader;
import models.FruitDao;
import services.FruitTransaction;

public class CsvFileReaderImpl implements CsvFileReader {
    private FruitDao fruitDao;

    public CsvFileReaderImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<FruitTransaction> read(String filePath) {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = bufferedReader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                FruitTransaction fruitTransaction = fruitDao.getFromCsvData(line);
                transactions.add(fruitTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("IOException " + e);
        }
        return transactions;
    }
}

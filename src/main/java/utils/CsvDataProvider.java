package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProvider {

    public static List<TestData> loadTestData(String filePath) {
        List<TestData> dataList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) { // skip header row
                    isHeader = false;
                    continue;
                }

                String destination = line[0];
                String checkInDate = line[1];
                String checkOutDate = line[2];

                TestData data = new TestData(destination, checkInDate, checkOutDate);
                dataList.add(data);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}

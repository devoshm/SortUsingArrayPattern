package Init;

import GenerateData.DataGenerator;
import GenerateData.RandomArray;
import SortUtils.Sort;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Initiator
{
    public static void main(String[] args) throws IOException
    {
        int size = 60;
        List<Integer> arrayList;
        RandomArray randomArray;

        File csvFile = new File("ReportAnalysis.csv");
        if (!csvFile.exists())
        {
            initializeFile(csvFile);
        }

        BufferedReader brTest = new BufferedReader(new FileReader(csvFile));
        String[] headers = brTest.readLine().split(",");

        FileWriter writer = new FileWriter(csvFile, true);
        for (Map.Entry<Integer, String> mapEntry : SortConstants.AVAILABLE_PATTERNS.entrySet())
        {
            randomArray = new RandomArray(mapEntry.getKey(), size);
            arrayList = DataGenerator.generate(randomArray);
            //System.out.println(mapEntry.getValue() + ": " + arrayList);
            Sort.sort(randomArray);
            //System.out.println(randomArray.getReportMap());

            Map<String, Object> reportMap = randomArray.getReportMap();
            StringBuilder stringBuilder = new StringBuilder();
            for (String header : headers)
            {
                stringBuilder.append(reportMap.get(header));
                stringBuilder.append(SortConstants.CSV_DELIMITER);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            writer.append(stringBuilder);
            writer.append("\n");
        }

        writer.flush();
        writer.close();
    }

    private static void initializeFile(File csvFile) throws IOException
    {
        FileWriter writer = new FileWriter(csvFile);
        writer.append(SortConstants.HEADER_DATETIME).append(SortConstants.CSV_DELIMITER);
        writer.append(SortConstants.HEADER_ARRAY_SIZE).append(SortConstants.CSV_DELIMITER);
        writer.append(SortConstants.HEADER_PATTERN).append(SortConstants.CSV_DELIMITER);
        writer.append(SortConstants.HEADER_PREDICTED).append(SortConstants.CSV_DELIMITER);
        writer.append(SortConstants.HEADER_SAMPLE_SIZE).append(SortConstants.CSV_DELIMITER);

        for (String patternStr : SortConstants.AVAILABLE_PATTERNS.values())
        {
            writer.append(patternStr);
            writer.append(SortConstants.HEADER_SCORE).append(SortConstants.CSV_DELIMITER);
        }

        writer.append(SortConstants.HEADER_TIME_TAKEN).append(SortConstants.CSV_DELIMITER);
        writer.append(SortConstants.HEADER_ACTUAL_SORT_TIME).append(SortConstants.CSV_DELIMITER);
        writer.append(SortConstants.HEADER_PREDICTED_SORT_TIME).append("\n");

        writer.flush();
        writer.close();
    }
}

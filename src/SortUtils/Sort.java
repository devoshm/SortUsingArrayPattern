package SortUtils;

import GenerateData.RandomArray;
import Init.SortConstants;
import PredictPattern.PatternPredictor;

import java.time.LocalDateTime;
import java.util.Map;

public class Sort
{
    public static void sort(RandomArray randomArray)
    {
        PatternPredictor predictor = new PatternPredictor(randomArray);
        predictor.predict();
        for (Map.Entry<String, PatternPredictor.Predictor> mapEntry1 : predictor.getPredictionMap().entrySet())
        {
            randomArray.addToReportMap(SortConstants.HEADER_PREDICTOR, mapEntry1.getKey());
            randomArray.addToReportMap(SortConstants.HEADER_DATETIME, LocalDateTime.now().toString().replace("T", " "));
            randomArray.addToReportMap(SortConstants.HEADER_ARRAY_SIZE, randomArray.getArraySize());
            randomArray.addToReportMap(SortConstants.HEADER_PATTERN, SortConstants.AVAILABLE_PATTERNS.get(randomArray.getActualPatternType()));

            PatternPredictor.Predictor predictor1 = mapEntry1.getValue();
            for (Map.Entry<Integer, Integer> mapEntry2 : predictor1.getScoreMap().entrySet())
            {
                randomArray.addToReportMap(SortConstants.AVAILABLE_PATTERNS.get(mapEntry2.getKey()) + SortConstants.HEADER_SCORE, mapEntry2.getValue());
            }
            randomArray.addToReportMap(SortConstants.HEADER_PREDICTED, SortConstants.AVAILABLE_PATTERNS.get(predictor1.getPredictedPattern()));
            randomArray.addToReportMap(SortConstants.HEADER_TIME_TAKEN, predictor1.getTimeTaken());

            if (randomArray.getActualPatternType() == predictor1.getPredictedPattern())
            {
                long timeTaken = sort(randomArray.getGeneratedArray(), randomArray.getActualPatternType());
                randomArray.addToReportMap(SortConstants.HEADER_ACTUAL_SORT_TIME, timeTaken);
                randomArray.addToReportMap(SortConstants.HEADER_PREDICTED_SORT_TIME, timeTaken);
            }
            else
            {
                long timeTaken1 = sort(randomArray.getGeneratedArray(), randomArray.getActualPatternType());
                randomArray.addToReportMap(SortConstants.HEADER_ACTUAL_SORT_TIME, timeTaken1);

                long timeTaken2 = sort(randomArray.getGeneratedArray(), predictor1.getPredictedPattern());
                randomArray.addToReportMap(SortConstants.HEADER_PREDICTED_SORT_TIME, timeTaken2);
            }
        }
    }

    private static long sort(int[] inputArr, int patternType)
    {
        long startTime = System.nanoTime();
        switch (SortConstants.PATTERNS_VS_SORT.get(patternType))
        {
            case SortConstants.SORT_COUNT:
                CountSort.sort(inputArr);
                break;
            case SortConstants.SORT_HEAP:
                HeapSort.sort(inputArr);
                break;
            case SortConstants.SORT_INSERTION:
                InsertionSort.sort(inputArr);
                break;
            case SortConstants.SORT_MERGE:
                MergeSort.sort(inputArr);
                break;
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}

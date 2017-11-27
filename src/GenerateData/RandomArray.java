package GenerateData;

import Init.SortConstants;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomArray
{
    private int arraySize;
    private Random random;
    private int sizeSqrt;
    private int[] generatedArray;
    private int actualPatternType;
    private Map<String, Object> reportMap = new HashMap<>();

    public RandomArray(int patternType, int arraySize)
    {
        this.arraySize = arraySize;
        this.actualPatternType = patternType;
        this.random = new Random();
        this.sizeSqrt = (int) Math.sqrt(arraySize);

        addToReportMap(SortConstants.HEADER_DATETIME, LocalDateTime.now().toString());
        addToReportMap(SortConstants.HEADER_ARRAY_SIZE, arraySize);
        addToReportMap(SortConstants.HEADER_PATTERN, SortConstants.AVAILABLE_PATTERNS.get(patternType));
    }

    public int getArraySize()
    {
        return arraySize;
    }

    Random getRandom()
    {
        return random;
    }

    int getSizeSqrt()
    {
        return sizeSqrt;
    }

    public int getActualPatternType()
    {
        return actualPatternType;
    }

    public int[] getGeneratedArray()
    {
        return generatedArray;
    }

    void setGeneratedArray(int[] generatedArray)
    {
        this.generatedArray = generatedArray;
    }

    void swapElementsPositionInArray(int firstIndex, int secondIndex)
    {
        int temp = this.generatedArray[firstIndex];
        this.generatedArray[firstIndex] = this.generatedArray[secondIndex];
        this.generatedArray[secondIndex] = temp;
    }

    void copyElementInArray(int toIndex, int fromIndex)
    {
        this.generatedArray[toIndex] = this.generatedArray[fromIndex];
    }

    void addToGeneratedArray(int index, int value)
    {
        this.generatedArray[index] = value;
    }

    public Map<String, Object> getReportMap()
    {
        return reportMap;
    }

    public void addToReportMap(String key, Object value)
    {
        this.reportMap.put(key, value);
    }

    public int calculateLog(int base)
    {
        return (int) Math.ceil(Math.log10(arraySize) / Math.log10(base));
    }
}

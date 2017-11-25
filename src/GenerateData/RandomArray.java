package GenerateData;

import java.util.Map;
import java.util.Random;

public class RandomArray
{
    private int arraySize;
    private Random random;
    private int sizeSqrt;
    private Integer[] generatedArray;
    private Integer[] sortedArray;
    private int actualPatternType;
    private int predictedPatternType;
    private Map<Integer, Integer> availablePatterns;

    public RandomArray(int patternType, int arraySize)
    {
        this.arraySize = arraySize;
        this.actualPatternType = patternType;
        this.random = new Random();
        this.sizeSqrt = (int) Math.sqrt(arraySize);
    }

    public int getArraySize()
    {
        return arraySize;
    }

    public Random getRandom()
    {
        return random;
    }

    public int getSizeSqrt()
    {
        return sizeSqrt;
    }

    public int getActualPatternType()
    {
        return actualPatternType;
    }

    public Map<Integer, Integer> getAvailablePatterns()
    {
        return availablePatterns;
    }

    public Integer getFromGeneratedArray(Integer index)
    {
        return generatedArray[index];
    }

    public Integer[] getGeneratedArray()
    {
        return generatedArray;
    }

    public void swapElementsPositionInArray(int firstIndex, int secondIndex)
    {
        int temp = this.generatedArray[firstIndex];
        this.generatedArray[firstIndex] = this.generatedArray[secondIndex];
        this.generatedArray[secondIndex] = temp;
    }

    public void copyElementInArray(int toIndex, int fromIndex)
    {
        this.generatedArray[toIndex] = this.generatedArray[fromIndex];
    }

    public void addToGeneratedArray(int index, int value)
    {
        this.generatedArray[index] = value;
    }

    public void setGeneratedArray(Integer[] generatedArray)
    {
        this.generatedArray = generatedArray;
    }

    public int getPredictedPatternType()
    {
        return predictedPatternType;
    }

    public void setPredictedPatternType(int predictedPatternType)
    {
        this.predictedPatternType = predictedPatternType;
    }

    public int calculateLog(int num, int base)
    {
        return (int) Math.ceil(Math.log10(num)/Math.log10(base));
    }
}

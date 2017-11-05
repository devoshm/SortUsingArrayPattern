package GenerateData;

import java.util.*;

public class DataGenerator
{
    public static final int PATTERN_REPEATED = 0;
    public static final int PATTERN_REVERSE = 1;
    public static final int PATTERN_NEARLY_SORTED = 2;
    public static final int PATTERN_RANDOM = 3;

    private static final int MAKE_DUPLICATE = 1;
    private static final int MAKE_SHUFFLE = 2;

    private int arraySize;
    private int patternType;
    private Random random;
    private int sizeSqrt;
    private Integer[] generatedArray;

    public DataGenerator(int patternType, int arraySize)
    {
        this.arraySize = arraySize;
        this.patternType = patternType;
        this.random = new Random();
        this.sizeSqrt = (int) Math.sqrt(arraySize);
    }

    private void makeDuplicatesOrShuffles(int num, int duplicateOrShuffle)
    {
        while (num > 0)
        {
            int firstIndex = random.nextInt(arraySize);
            int secondIndex = random.nextInt(arraySize);
            int firstElement = generatedArray[firstIndex];

            switch (duplicateOrShuffle)
            {
                case MAKE_DUPLICATE:
                    generatedArray[secondIndex] = firstElement;
                    break;
                case MAKE_SHUFFLE:
                    generatedArray[firstIndex] = generatedArray[secondIndex];
                    generatedArray[secondIndex] = firstElement;
            }
            num--;
        }
    }

    public List<Integer> generate()
    {
        generatedArray = new Integer[arraySize];
        for (int i = 0;i < arraySize; i++)
        {
            generatedArray[i] = i + 1;
        }
        makeDuplicatesOrShuffles(sizeSqrt, MAKE_DUPLICATE);

        switch (patternType)
        {
            case PATTERN_REPEATED:
                int num = (int) (0.75 * arraySize);
                makeDuplicatesOrShuffles(num, MAKE_DUPLICATE);
                break;
            case PATTERN_REVERSE:
                List<Integer> reverseList = Arrays.asList(generatedArray);
                Collections.reverse(reverseList);
                generatedArray = reverseList.toArray(new Integer[arraySize]);
                makeDuplicatesOrShuffles(sizeSqrt, MAKE_SHUFFLE);
                break;
            case PATTERN_NEARLY_SORTED:
                makeDuplicatesOrShuffles(sizeSqrt, MAKE_SHUFFLE);
                break;
            case PATTERN_RANDOM:
                List<Integer> randomList = Arrays.asList(generatedArray);
                Collections.shuffle(randomList);
                generatedArray = randomList.toArray(new Integer[arraySize]);
                break;
        }

        return Arrays.asList(generatedArray);
    }
}
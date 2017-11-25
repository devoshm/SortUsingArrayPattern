package GenerateData;

import Init.SortConstants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DataGenerator
{
    private static final int MAKE_DUPLICATE = 1;
    private static final int MAKE_SHUFFLE = 2;

    private static void makeDuplicatesOrShuffles(RandomArray randomArray, int num, int duplicateOrShuffle)
    {
        while (num > 0)
        {
            Random random = randomArray.getRandom();
            int firstIndex = random.nextInt(randomArray.getArraySize());
            int secondIndex = random.nextInt(randomArray.getArraySize());

            switch (duplicateOrShuffle)
            {
                case MAKE_DUPLICATE:
                    randomArray.copyElementInArray(secondIndex, firstIndex);
                    break;
                case MAKE_SHUFFLE:
                    randomArray.swapElementsPositionInArray(firstIndex, secondIndex);
            }
            num--;
        }
    }

    public static List<Integer> generate(RandomArray randomArray)
    {
        int arraySize = randomArray.getArraySize();
        randomArray.setGeneratedArray(new Integer[arraySize]);
        for (int i = 0; i < arraySize; i++)
        {
            randomArray.addToGeneratedArray(i, i + 1);
        }
        makeDuplicatesOrShuffles(randomArray, randomArray.getSizeSqrt(), MAKE_DUPLICATE);

        switch (randomArray.getActualPatternType())
        {
            case SortConstants.PATTERN_REPEATED:
                int num = (int) (0.85 * arraySize);
                makeDuplicatesOrShuffles(randomArray, num, MAKE_DUPLICATE);
                break;
            case SortConstants.PATTERN_REVERSE:
                List<Integer> reverseList = Arrays.asList(randomArray.getGeneratedArray());
                Collections.reverse(reverseList);
                randomArray.setGeneratedArray(reverseList.toArray(new Integer[arraySize]));
                makeDuplicatesOrShuffles(randomArray, randomArray.getSizeSqrt(), MAKE_SHUFFLE);
                break;
            case SortConstants.PATTERN_NEARLY_SORTED:
                makeDuplicatesOrShuffles(randomArray, randomArray.getSizeSqrt(), MAKE_SHUFFLE);
                break;
            case SortConstants.PATTERN_RANDOM:
                List<Integer> randomList = Arrays.asList(randomArray.getGeneratedArray());
                Collections.shuffle(randomList);
                randomArray.setGeneratedArray(randomList.toArray(new Integer[arraySize]));
                break;
        }

        return Arrays.asList(randomArray.getGeneratedArray());
    }
}
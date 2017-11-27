package GenerateData;

import Init.SortConstants;
import com.google.common.primitives.Ints;

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
        randomArray.setGeneratedArray(new int[arraySize]);

        if (randomArray.getActualPatternType() == SortConstants.PATTERN_REPEATED)
        {
            createDuplicateArray(randomArray);
        }
        else
        {
            for (int i = 0; i < arraySize; i++)
            {
                randomArray.addToGeneratedArray(i, i + 1);
            }
            makeDuplicatesOrShuffles(randomArray, randomArray.getSizeSqrt(), MAKE_DUPLICATE);

            switch (randomArray.getActualPatternType())
            {
                case SortConstants.PATTERN_REVERSE:
                    List<Integer> reverseList = Ints.asList(randomArray.getGeneratedArray());
                    Collections.reverse(reverseList);
                    randomArray.setGeneratedArray(Ints.toArray(reverseList));
                    makeDuplicatesOrShuffles(randomArray, randomArray.getSizeSqrt(), MAKE_SHUFFLE);
                    break;
                case SortConstants.PATTERN_NEARLY_SORTED:
                    makeDuplicatesOrShuffles(randomArray, randomArray.getSizeSqrt(), MAKE_SHUFFLE);
                    break;
                case SortConstants.PATTERN_RANDOM:
                    List<Integer> randomList = Ints.asList(randomArray.getGeneratedArray());
                    Collections.shuffle(randomList);
                    randomArray.setGeneratedArray(Ints.toArray(randomList));
                    break;
            }
        }

        //randomArray.setGeneratedArray(new Integer[]{60, 59, 58, 57, 56, 55, 54, 53, 35, 32, 50, 51, 48, 47, 46, 45, 31, 43, 42, 41, 40, 39, 38, 25, 36, 35, 12, 33, 49, 44, 30, 29, 15, 27, 26, 37, 24, 26, 9, 21, 20, 19, 18, 5, 16, 28, 14, 13, 12, 11, 10, 41, 8, 7, 6, 17, 57, 3, 2, 1});

        return Ints.asList(randomArray.getGeneratedArray());
    }

    private static void createDuplicateArray(RandomArray randomArray)
    {
        int arraySize = randomArray.getArraySize();
        int bound = (int) (arraySize - arraySize * 0.9);
        Random random = randomArray.getRandom();

        for (int i = 0; i < arraySize; i++)
        {
            randomArray.addToGeneratedArray(i, random.nextInt(bound));
        }
    }
}
package PredictPattern;

import GenerateData.RandomArray;
import Init.SortConstants;

import java.util.*;

class RandomSampling implements Sampling
{
    private static final Random random = new Random();

    private static Integer generateRandomIndex(int lowerBound, int threshold)
    {
        return random.nextInt(threshold) + lowerBound;
    }

    private static void modifyPredictionCount(PatternPredictor.Predictor predictionData, Integer patternType, Integer value)
    {
        Integer count = predictionData.getFromScoreMap(patternType);
        count += value;
        predictionData.addToScoreMap(patternType, count);
        //System.out.println("Pattern Change Modification: " + patternStr + " ;; " + value + " ;; " + count);
    }

    private static boolean checkPatternChange(PatternPredictor.Predictor predictionData, List<Integer> patternedArray, boolean isAsc, int prevValue, int value)
    {
        Integer[] patterns = getPatterns(isAsc);

        if (isPatternChanged(prevValue, value, isAsc))
        {
            doCountModification(predictionData, patterns, patternedArray);

            isAsc = !isAsc;
            patternedArray.clear();
            patternedArray.add(prevValue);
            patternedArray.add(value);
        }
        else
        {
            patternedArray.add(value);
        }

        return isAsc;
    }

    private static boolean isPatternChanged(int firstVal, int secondVal, boolean isAsc)
    {
        if (isAsc)
        {
            return firstVal > secondVal;
        }
        else
        {
            return firstVal < secondVal;
        }
    }

    private static Integer[] getPatterns(boolean isAsc)
    {
        Integer[] patterns = new Integer[2];
        if (isAsc)
        {
            patterns[0] = SortConstants.PATTERN_NEARLY_SORTED;
            patterns[1] = SortConstants.PATTERN_REVERSE;
        }
        else
        {
            patterns[0] = SortConstants.PATTERN_REVERSE;
            patterns[1] = SortConstants.PATTERN_NEARLY_SORTED;
        }
        return patterns;
    }

    private static void doCountModification(PatternPredictor.Predictor predictionData, Integer[] patterns, List<Integer> patternedArray)
    {
        modifyPredictionCount(predictionData, patterns[0], patternedArray.size());
        modifyPredictionCount(predictionData, SortConstants.PATTERN_RANDOM, 1);
        modifyPredictionCount(predictionData, patterns[1], -1);
        //System.out.println(predictionData);
    }

    public void doSampling(PatternPredictor predictor)
    {
        long startTime = System.nanoTime();
        RandomArray randomArray = predictor.getArray();
        int arraySize = randomArray.getArraySize();
        int noOfSets = randomArray.calculateLog(2);
        int setSize = randomArray.calculateLog(5);
        int[] unsortedArray = randomArray.getGeneratedArray();
        Map<Integer, Integer> uniqueArray = new HashMap<>();
        List<Integer> patternedArray = new ArrayList<>();
        PatternPredictor.Predictor predictionData = predictor.getFromPredictionMap(RandomSampling.class.getSimpleName());

        int randomThreshold = arraySize / noOfSets;
        int lowerBound = 0;
        int upperBound = randomThreshold - 1;
        Set<Integer> randomIndices = new TreeSet<>();

        while (lowerBound + upperBound < arraySize)
        {
            int i = 0;
            while (i < setSize)
            {
                Integer randomIndex = generateRandomIndex(lowerBound, upperBound);
                if (randomIndices.contains(randomIndex))
                {
                    continue;
                }
                i++;
                randomIndices.add(randomIndex);
            }
            lowerBound += randomThreshold;
        }

        Boolean isAsc = null;
        Integer prevValue = null, currValue;
        int repeatCount = 0;

        for (Integer index : randomIndices)
        {
            currValue = unsortedArray[index];

            if (uniqueArray.size() <= noOfSets && random.nextBoolean())
            {
                double indexRange = (double) index / (double) randomThreshold;
                int floorValRange = (int) Math.floor(indexRange);
                lowerBound = randomThreshold * floorValRange;
                upperBound = randomThreshold * (floorValRange + 1);

                Integer valCount = uniqueArray.getOrDefault(currValue, 0);
                for (int i = lowerBound; i < upperBound; i++)
                {
                    if (unsortedArray[i] == currValue)
                    {
                        valCount++;
                        if (valCount > 1)
                        {
                            if (valCount == 2)
                            {
                                repeatCount++;
                            }
                            repeatCount++;
                        }
                    }
                }
                uniqueArray.put(currValue, valCount);
            }

            if (prevValue != null)
            {
                if (isAsc == null)
                {
                    isAsc = currValue >= prevValue;
                }
                isAsc = checkPatternChange(predictionData, patternedArray, isAsc, prevValue, currValue);
            }
            else
            {
                patternedArray.add(currValue);
            }
            prevValue = currValue;
        }

        Integer[] patterns = getPatterns(isAsc);
        doCountModification(predictionData, patterns, patternedArray);
        predictionData.addToScoreMap(SortConstants.PATTERN_REPEATED, (repeatCount / uniqueArray.size()) * randomIndices.size());
        long endTime = System.nanoTime();
        predictionData.setTimeTaken(endTime - startTime);
    }
}

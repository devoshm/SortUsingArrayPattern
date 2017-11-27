package PredictPattern;

import GenerateData.RandomArray;
import Init.SortConstants;

import java.util.HashMap;
import java.util.Map;

public class PatternPredictor
{
    private RandomArray randomArray;
    private Map<String, Predictor> predictionMap;

    public PatternPredictor(RandomArray randomArray)
    {
        this.randomArray = randomArray;
        this.predictionMap = new HashMap<>();
    }

    RandomArray getArray()
    {
        return randomArray;
    }

    Predictor getFromPredictionMap(String className)
    {
        if (!predictionMap.containsKey(className))
        {
            Predictor predictor = new Predictor(className);
            predictionMap.put(className, predictor);
        }
        return predictionMap.get(className);
    }

    public Map<String, Predictor> getPredictionMap()
    {
        return predictionMap;
    }

    public void predict()
    {
        Sampling sampling;

        sampling = new RandomSampling();
        sampling.doSampling(this);
    }

    public class Predictor
    {
        String predictorName;
        Map<Integer, Integer> scoreMap = new HashMap<>();
        int predictedPattern, maxScore = 0;
        long timeTaken, ttForActualSort, ttForPredictedSort;

        Predictor(String name)
        {
            this.predictorName = name;
            for (Integer patternType : SortConstants.AVAILABLE_PATTERNS.keySet())
            {
                addToScoreMap(patternType, 0);
            }
        }

        Integer getFromScoreMap(Integer patternType)
        {
            return scoreMap.get(patternType);
        }

        public Map<Integer, Integer> getScoreMap()
        {
            return scoreMap;
        }

        void addToScoreMap(Integer patternType, Integer score)
        {
            if (score > this.maxScore)
            {
                this.predictedPattern = patternType;
                this.maxScore = score;
            }
            this.scoreMap.put(patternType, score);
        }

        public int getPredictedPattern()
        {
            return predictedPattern;
        }

        public long getTimeTaken()
        {
            return timeTaken;
        }

        void setTimeTaken(long timeTaken)
        {
            this.timeTaken = timeTaken;
        }

        public long getTtForActualSort()
        {
            return ttForActualSort;
        }

        public void setTtForActualSort(long ttForActualSort)
        {
            this.ttForActualSort = ttForActualSort;
        }

        public long getTtForPredictedSort()
        {
            return ttForPredictedSort;
        }

        public void setTtForPredictedSort(long ttForPredictedSort)
        {
            this.ttForPredictedSort = ttForPredictedSort;
        }
    }
}

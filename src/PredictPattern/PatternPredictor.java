package PredictPattern;

import GenerateData.DataGenerator;
import GenerateData.RandomArray;
import Init.SortConstants;

import java.util.HashMap;
import java.util.Map;

public class PatternPredictor
{
    private RandomArray randomArray;
    private Map<String, Map<Integer, Integer>> predictionMap;

    public PatternPredictor(RandomArray randomArray)
    {
        this.randomArray = randomArray;
        this.predictionMap = new HashMap<>();
    }

    RandomArray getArray()
    {
        return randomArray;
    }

    Map<Integer, Integer> getFromPredictionMap(String className)
    {
        if (!predictionMap.containsKey(className))
        {
            Map<Integer, Integer> predictionData = new HashMap<>();
            for (Integer patterType : SortConstants.AVAILABLE_PATTERNS)
            {
                predictionData.put(patterType, 0);
            }
            predictionMap.put(className, predictionData);
        }
        return predictionMap.get(className);
    }

    public Map<String, Map<Integer, Integer>> getPredictionMap()
    {
        return predictionMap;
    }

    public void predict()
    {
        RandomSampling.doSampling(this);
    }
}

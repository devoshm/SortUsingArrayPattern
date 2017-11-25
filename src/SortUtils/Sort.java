package SortUtils;

import GenerateData.RandomArray;
import PredictPattern.PatternPredictor;

public class Sort
{
    static int counter;

    public static void sort(RandomArray randomArray)
    {
        PatternPredictor predictor = new PatternPredictor(randomArray);
        predictor.predict();
        System.out.println(predictor.getPredictionMap());
    }
}

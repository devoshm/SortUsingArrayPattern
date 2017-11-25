package Init;

import GenerateData.DataGenerator;
import GenerateData.RandomArray;
import SortUtils.Sort;

import java.util.List;

public class Initiator
{
    public static void main(String[] args)
    {
        int size = 60;

        RandomArray randomArray = new RandomArray(SortConstants.PATTERN_REPEATED, size);
        List<Integer> arrayList = DataGenerator.generate(randomArray);
        System.out.println(arrayList);
        Sort.sort(randomArray);

//        dataGenerator = new DataGenerator(DataGenerator.PATTERN_REVERSE, size);
//        System.out.println(dataGenerator.generate());
//        Integer[] sortedArr = Sort.sort(dataGenerator.getIfNotPresentGenerateArray());
//
//        dataGenerator = new DataGenerator(DataGenerator.PATTERN_NEARLY_SORTED, size);
//        System.out.println(dataGenerator.generate());
//        Integer[] sortedArr = Sort.sort(dataGenerator.getIfNotPresentGenerateArray());
//
//        dataGenerator = new DataGenerator(DataGenerator.PATTERN_RANDOM, size);
//        System.out.println(dataGenerator.generate());
//        Integer[] sortedArr = Sort.sort(dataGenerator.getIfNotPresentGenerateArray());
    }
}

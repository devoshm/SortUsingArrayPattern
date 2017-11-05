import GenerateData.DataGenerator;

public class Initiator
{
    public static void main(String[] args)
    {
        int size = 30;

        DataGenerator dataGenerator = new DataGenerator(DataGenerator.PATTERN_REPEATED, size);
        System.out.println(dataGenerator.generate());

        dataGenerator = new DataGenerator(DataGenerator.PATTERN_REVERSE, size);
        System.out.println(dataGenerator.generate());

        dataGenerator = new DataGenerator(DataGenerator.PATTERN_NEARLY_SORTED, size);
        System.out.println(dataGenerator.generate());

        dataGenerator = new DataGenerator(DataGenerator.PATTERN_RANDOM, size);
        System.out.println(dataGenerator.generate());
    }
}

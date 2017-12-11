package Init;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public interface SortConstants
{

    int PATTERN_REPEATED = 0;
    int PATTERN_REVERSE = 1;
    int PATTERN_NEARLY_SORTED = 2;
    int PATTERN_RANDOM = 3;

    String PATTERN_REPEATED_STR = "Repeated";
    String PATTERN_REVERSE_STR = "Reverse";
    String PATTERN_NEARLY_SORTED_STR = "Nearly Sorted";
    String PATTERN_RANDOM_STR = "Random";

    Map<Integer, String> AVAILABLE_PATTERNS = ImmutableMap.of(PATTERN_REPEATED, PATTERN_REPEATED_STR, PATTERN_REVERSE, PATTERN_REVERSE_STR, PATTERN_NEARLY_SORTED, PATTERN_NEARLY_SORTED_STR, PATTERN_RANDOM, PATTERN_RANDOM_STR);

    int SORT_BUBBLE = 1;
    int SORT_QUICK = 2;
    int SORT_MERGE = 3;
    int SORT_HEAP = 4;
    int SORT_INSERTION = 5;
    int SORT_COUNT = 6;

    Map<Integer, Integer> PATTERNS_VS_SORT = ImmutableMap.of(PATTERN_REPEATED, SORT_COUNT, PATTERN_REVERSE, SORT_HEAP, PATTERN_NEARLY_SORTED, SORT_INSERTION, PATTERN_RANDOM, SORT_MERGE);

    String HEADER_PREDICTOR = "Predictor Name";
    String HEADER_DATETIME = "Date & Time";
    String HEADER_ARRAY_SIZE = "Array Size";
    String HEADER_PATTERN = "Actual Pattern";
    String HEADER_SCORE = " Score";
    String HEADER_PREDICTED = "Predicted Pattern";
    String HEADER_SAMPLE_SIZE = "Sampled Size";
    String HEADER_TIME_TAKEN = "Time Taken";
    String HEADER_ACTUAL_SORT_TIME = "Sort Time With Actual Pattern";
    String HEADER_PREDICTED_SORT_TIME = "Sort Time With Predicted Pattern";

    String CSV_DELIMITER = ",";
}

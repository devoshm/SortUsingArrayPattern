package Init;

public interface SortConstants
{

    int PATTERN_REPEATED = 0;
    int PATTERN_REVERSE = 1;
    int PATTERN_NEARLY_SORTED = 2;
    int PATTERN_RANDOM = 3;

    Integer[] AVAILABLE_PATTERNS = new Integer[]{PATTERN_REPEATED, PATTERN_REVERSE, PATTERN_NEARLY_SORTED, PATTERN_RANDOM};
}

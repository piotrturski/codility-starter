package codility.tools;

import static org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY;

import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class ArrayCoercer {

	
	// "a b c" -> ["a", "b", "c"]
    public String[] toStringArray(String input) {
		return whitespaceSeparatedStream(input).toArray(String[]::new);
    }

    // "1 2 -3" -> [1,2,-3]
    public int[] toIntArray(String input) {
    	return whitespaceSeparatedStream(input).mapToInt(Integer::parseInt).toArray();
    }
    
	/**
     * handles empty string different than String::split 
     */
    public static Stream<String> whitespaceSeparatedStream(String input) {
    	String trimmed = StringUtils.trimToEmpty(input);
		return Arrays.stream(
    			StringUtils.isEmpty(trimmed)? EMPTY_STRING_ARRAY : trimmed.split("\\s+")
    			);
    }
	
}

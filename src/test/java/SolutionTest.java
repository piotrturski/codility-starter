
import static org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@RunWith(ZohhakRunner.class)
public class SolutionTest {

	
	@TestWith({
		"1, 1",
		" '', '' ",
	})
	public void solution(String s1, String expected) {
		assertThat(new Solution().solution()).isEqualTo(expected);
	}
	
	@TestWith({
		"1, 1",
	})
	public void solution_exception(String s1, String expected) {
		assertThatThrownBy(() -> {throw new RuntimeException();})
									.isInstanceOf(RuntimeException.class);
	}
	
	// "1 2 -3" -> [1,2,-3]
    @Coercion
    public int[] toArray(String input) {
    	return spaceSeparatedStream(input).mapToInt(Integer::parseInt).toArray();
    }
    
    @TestWith({
    	"1 2 -3"
    })
    public void toArray_should_build_an_array_of_ints(int[] a1) {
    	assertThat(a1).isEqualTo(new int[]{1, 2, -3});
    }

    @TestWith({
    	" ' ' ",
    	""
    })
    public void toArray_should_build_empty_array_of_ints(int[] a1) {
    	assertThat(a1).isEmpty();
    }
    
    // "a b c" -> ["a", "b", "c"]
    @Coercion
    public String[] toArray2(String input) {
		return spaceSeparatedStream(input).toArray(String[]::new);
    }
    
    @TestWith({
    	"ad b c "
    })
    public void toArray2_should_build_an_array_of_strings(String[] a1) {
    	assertThat(a1).isEqualTo(new String[]{"ad", "b", "c"});
    }

    @TestWith({
    	" ' ' ",
    	""
    })
    public void toArray_should_build_empty_array_of_strings(String[] a1) {
    	assertThat(a1).isEmpty();
    }
    
    /**
     * handles empty string different than String::split 
     */
    private Stream<String> spaceSeparatedStream(String input) {
    	return Arrays.stream(
    			StringUtils.isEmpty(input)? EMPTY_STRING_ARRAY : input.split(" ")
    			);
    }
    
}

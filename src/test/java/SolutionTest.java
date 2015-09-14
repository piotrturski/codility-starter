
import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

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
		assertThatThrownBy(() -> {});
	}
	
	// "123" -> [1,2,3]
    @Coercion
    public int[] toArray(String input) {
    	return input.chars().map(c -> Integer.parseInt(""+((char)c))).toArray();
    }
    
    @TestWith({
    	"123, "
    })
    public void toArray_should_build_an_array_of_1_digit_ints(int[] a1, int[] a2) {
    	assertThat(a1).isEqualTo(new int[]{1, 2, 3});
    	assertThat(a2).isEmpty();
    }

    // "abc" -> ["a", "b", "c"]
    @Coercion
    public String[] toArray2(String input) {
		Object[] array = input.chars().mapToObj(c -> ""+(char)c).toArray(String[]::new);
		String[] array2 = (String[]) array;
		return array2;
    }
    
    @TestWith({
    	"abc, "
    })
    public void toArray2_should_build_an_array_of_1_character_strings(String[] a1, String[] a2) {
    	assertThat(a1).isEqualTo(new String[]{"a", "b", "c"});
    	assertThat(a2).isEmpty();
    }
	
}

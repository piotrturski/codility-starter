package codility;

import static codility.tools.TreeBuilder.t;
import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.Coercion;
import com.googlecode.zohhak.api.Configure;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

import codility.tools.ArrayCoercer;
import codility.tools.Rand;

@RunWith(ZohhakRunner.class)
@Configure(coercers=ArrayCoercer.class)
public class SolutionTest {

	Solution1 solution = new Solution1();
	
	@TestWith({
    	"1 4 7 3 3 5, 0",
    	"1, 0",
    	
    })
	public void solution1(int[] a, int expected) {
		assertThat(solution.solution(a))
										.isEqualTo(solution.solutionNaive(a))
										.isEqualTo(expected)
										;
	}
	
	@Test
	public void solution1qc() {
		
		for (int i=0; i < 2000; i++) {
			int[] a = Rand.arrayOfSize(1, 3, 30, 31).of(-8, 8);
			assertThat(solution.solution(a))
								.as("result of %s", ArrayUtils.toString(a))
								.isEqualTo(solution.solutionNaive(a))
			;
			
		}
		
	}
	
	
	@Test
	public void solution2() {
				t(5, 
					t(8, 
						t(12), 
						t(2)), 
					t(9, 
						t(7,
							t(1),
							null),
						t(4, 
							t(3),
							null))
				);
				
	}
	
	@TestWith({
		"1, 1",
	})
	public void solution_exception(String s1, String expected) {
		assertThatThrownBy(() -> {throw new RuntimeException();})
									.isInstanceOf(RuntimeException.class);
	}
    
}

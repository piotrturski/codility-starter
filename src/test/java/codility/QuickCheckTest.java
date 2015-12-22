package codility;

import static codility.tools.Rand.*;
import static org.assertj.core.api.StrictAssertions.assertThat;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import codility.tools.AbstractIntArrayGenerator;

//@RunWith(Theories.class)
public class QuickCheckTest {

	Solution1 solution = new Solution1();
	
	@Theory
	public void solution0(@ForAll(sampleSize=2000) @From(IntArrayGenerator.class) int[] a) {
		
		assertThat(a.length)
						.as("result of %s", ArrayUtils.toString(a))
						.isEqualTo(20);
	}

	public static class IntArrayGenerator extends AbstractIntArrayGenerator {

		@Override
		public int[] generate(SourceOfRandomness random, GenerationStatus status) {
			return arrayOfSize(1, 6, 31, 37).of(-8, 8);
		}
	}
	
}

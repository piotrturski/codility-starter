package codility.tools;

import com.pholser.junit.quickcheck.generator.Generator;

public abstract class AbstractIntArrayGenerator extends Generator<int[]> {

	protected AbstractIntArrayGenerator() {
		super(int[].class);
	}

}

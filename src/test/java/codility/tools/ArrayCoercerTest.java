package codility.tools;

import static org.assertj.core.api.StrictAssertions.assertThat;

import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.Configure;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@RunWith(ZohhakRunner.class)
@Configure(coercers=ArrayCoercer.class)
public class ArrayCoercerTest {
    
    @TestWith({
    	"1 2 -3"
    })
    public void toArray_should_build_an_array_of_ints(int[] a1) {
    	assertThat(a1).isEqualTo(new int[]{1, 2, -3});
    }

    @TestWith({
    	" ' ' ",
    	" '  \t  ' ",
    	""
    })
    public void toArray_should_build_empty_array_of_ints(int[] a1) {
    	assertThat(a1).isEmpty();
    }
    
    @TestWith({
    	"ad b c ",
    	" '  ad \t  b  c  ' "
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

}

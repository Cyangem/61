import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('{', 'o'));
        assertTrue(offByOne.equalChars('I', 'i'));
        assertTrue(offByOne.equalChars('j', 'k'));
        assertTrue(offByOne.equalChars('p', 'z'));
        assertTrue(offByOne.equalChars(',', '.'));
        assertTrue(offByOne.equalChars('W', 'w'));
        assertTrue(offByOne.equalChars('t', 's'));
        assertTrue(offByOne.equalChars('A', 'A'));


    }
}
//Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
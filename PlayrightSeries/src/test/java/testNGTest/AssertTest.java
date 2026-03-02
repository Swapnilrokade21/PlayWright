package testNGTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {

    @Test
    public void titleVerify() {
        String actual_title = "Gmail";
        String expected_title = "Gmail1"; // Correct title

        // Using assertEquals
        Assert.assertEquals(actual_title, expected_title, "Title did not match!");

        // Optional: using assertTrue
        Assert.assertTrue(actual_title.equals(expected_title), "Title check failed!");
    }
}

package runnerTestNG;
import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;


public class RunnerTestNG {
	

	    public static void main(String[] args) {

	        TestNG testng = new TestNG();

	        List<String> suites = new ArrayList<>();
	        suites.add("src/test/resources/runner/testng.xml");  // path to xml

	        testng.setTestSuites(suites);
	        testng.run();
	    }
	}

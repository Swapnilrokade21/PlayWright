package testNGTest;


	import org.testng.TestNG;
	import java.util.Collections;

	public class TestRunnerUsingXML {
	    public static void main(String[] args) {
	    	
	        TestNG testng = new TestNG();
	        testng.setTestSuites(Collections.singletonList("TestNG4.xml"));

	        testng.run();
	        
	    }
	}


//package testNGTest;
//
//import org.testng.TestNG;
//import java.util.Arrays;
//import java.util.List;
//
//public class TestRunnerUsingXML {
//    public static void main(String[] args) {
//
//        TestNG testng = new TestNG();
//
//        List<String> suites = Arrays.asList(
//                "TestNG.xml",
//                "RegressionTestNG.xml"
//    
//        );
//
//        testng.setTestSuites(suites);
//        testng.run();
//    }
//}

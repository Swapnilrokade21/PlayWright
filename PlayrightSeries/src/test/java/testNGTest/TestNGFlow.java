package testNGTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class TestNGFlow {
    // ANSI colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    @BeforeSuite
    public void suit1() {
        System.out.println(BLUE + " Before suite " + RESET);
    }

    @BeforeTest
    public void launchBrowser() {
        System.out.println(GREEN + "launch browser - Before Test" + RESET);
    }

    @BeforeClass
    public void class1() {
        System.out.println(YELLOW + " Before Class" + RESET);
    }

    @BeforeMethod
    public void login() {
        System.out.println(GREEN + "Log in - Before Method" + RESET);
    }

    @Test(priority = 1)
    public void fillTheForm() {
        System.out.println(RED + "Fill the form 1 - Test1" + RESET);
    }

    @Test(priority = 2)
    public void fillTheForm2() {
        System.out.println(RED + "Fill the form 2 - Test2" + RESET);
    }

    @AfterMethod
    public void logout() {
        System.out.println(YELLOW + "log out - After Method" + RESET);
    }

    @AfterClass
    public void class2() {
        System.out.println(BLUE + " After Class" + RESET);
    }

    @AfterTest
    public void closeBrowser() {
        System.out.println(GREEN + "Close browser - After Test" + RESET);
    }

    @AfterTest
    public void suit2() {
        System.out.println(BLUE + " After Suite " + RESET);
    }
}

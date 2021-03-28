package lesson7;

public class TestClass {
    @BeforeSuite
    public void methodBefore() {
        System.out.println("BeforeMethod");
    }
    @AfterSuite
    public void methodAfter() {
        System.out.println("AfterMethod");
    }

    @Test()
    public void testMethod1() {
        System.out.println("Method priority 1");
    }

    @Test(priority = 5)
    public void testMethod2() {
        System.out.println("Method priority 5");
    }

    @Test(priority = 2)
    public void testMethod3() {
        System.out.println("Method priority 2");
    }

}
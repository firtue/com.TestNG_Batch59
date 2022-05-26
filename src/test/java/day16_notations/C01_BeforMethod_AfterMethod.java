package day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforMethod_AfterMethod extends TestBase {

    // @BeforMethod ve @AfterMethod notasyonlari
    // JUnit'teki @Before @After gibidir
    // her test method'undan once ve sonra calisirlar

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproedTest() {
        driver.get("https://techproeducation.com/");
    }
}

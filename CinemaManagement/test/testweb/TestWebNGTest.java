/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testweb;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Admin
 */
public class TestWebNGTest {

    public String baseURL = "http://localhost:8080/cinemaManagement/auth.html";
    public WebDriver driver;

    public TestWebNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "E:\\Chuyên Ngành\\Software Testing\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseURL);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterClass
    public void tearDownMethod() throws Exception {
        driver.close();
    }

    @DataProvider(name = "AdminTest")
    public Object[][] AdminAuthTest() {

        Object[][] obj = new Object[4][3];
        obj[0][0] = "";
        obj[0][1] = "123";
        obj[0][2] = null;

        obj[1][0] = "admin@123";
        obj[1][1] = "";
        obj[1][2] = null;

        obj[2][0] = "admin@123";
        obj[2][1] = "456";
        obj[2][2] = null;

        obj[3][0] = "admin@123";
        obj[3][1] = "123";
        obj[3][2] = "Admin";

        return obj;
    }

    @Test(dataProvider = "AdminTest", priority = 0)
    public void AdminLogin(String user, String password, String expect) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.id("email")).sendKeys(user);
//        Thread.sleep(500);

        driver.findElement(By.id("password")).sendKeys(password);
//        Thread.sleep(500);

        driver.findElement(By.id("signIn")).click();

//        WebElement fList = driver.findElement(By.id("flist"));
//        fList.click();
        WebElement uID;
        try {
            uID = driver.findElement(By.id("Admin"));
            assertEquals(uID.getText(), expect);
        } catch (Exception ex) {
            uID = null;
            assertNull(uID);
        }

    }

    @DataProvider(name = "AdminTestUpdateBlll")
    public Object[][] AdminTestUpdateBlll() {

        Object[][] obj = new Object[2][4];
        obj[0][0] = "";
        obj[0][1] = "";
        obj[0][2] = false;
        obj[0][3] = "nghi";
        obj[1][0] = "ce140186";
        obj[1][1] = "9";
        obj[1][2] = true;
        obj[1][3] = "nghice140186";
        return obj;
    }

    @Test(dataProvider = "AdminTestUpdateBlll", priority = 1)
    public void AdminUpdateBill(String bName, String bPhone, boolean status, String expect) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("DSHD")).click();
        Thread.sleep(500);
        driver.findElement(By.id("image_update_bill")).click();
        Thread.sleep(500);
        driver.findElement(By.name("bName")).sendKeys(bName);
        Thread.sleep(500);
        driver.findElement(By.name("bPhone")).sendKeys(bPhone);
        Thread.sleep(500);

        if (status) {
            driver.findElement(By.id("male")).click();
        } else {
            driver.findElement(By.id("female")).click();
        }
        Thread.sleep(500);
        driver.findElement(By.id("update_bill")).click();
        Thread.sleep(500);
        WebElement uID;
        try {
            uID = driver.findElement(By.id("id_BillName"));
            assertEquals(uID.getText(), expect);
        } catch (Exception ex) {
            uID = null;
            assertNull(uID);
        }

    }

    @DataProvider(name = "AdminTestUpdateBlllException")
    public Object[][] AdminTestUpdateBlllException() {
        Object[][] obj = new Object[1][2];
        obj[0][0] = "111111111111111111111111";
        obj[0][1] = "";

        return obj;
    }

    @Test(dataProvider = "AdminTestUpdateBlllException", priority = 2, expectedExceptions = Exception.class)
    public void AdminUpdateBillException(String bPhone, String expect) throws InterruptedException {
        WebElement uID;
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            driver.findElement(By.id("image_update_bill")).click();
            Thread.sleep(500);
            driver.findElement(By.name("bPhone")).sendKeys(bPhone);
            Thread.sleep(500);
            driver.findElement(By.id("update_bill")).click();
        } catch (Exception ex) {
            fail();
        }

    }

//    @DataProvider(name = "UserTest")
//    public Object[][] UserAuthTest() {
//        Object[][] obj = new Object[4][3];
//        obj[0][0] = "nhana";
//        obj[0][1] = "123";
//        obj[0][2] = null;
//        obj[3][0] = "admin@123";
//        obj[3][1] = "123";
//        obj[3][2] = "Nhan";
//        return obj;
//    }
//
//    @Test(dataProvider = "UserTest")
//    public void UserLogin(String user, String password, String expect) throws InterruptedException {
//        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//       
//        email.sendKeys(user);
//        Thread.sleep(500);
//       
//        pass.sendKeys(password);
//        Thread.sleep(500);
//       
//        login.click();
////        WebElement fList = driver.findElement(By.id("flist"));
////        fList.click();
//        WebElement uID;
//        try {
//            uID = driver.findElement(By.id("Nhan"));
//        } catch (Exception ex) {
//            uID = null;
//        }
//        assertEquals(uID, expect);
//    }
}

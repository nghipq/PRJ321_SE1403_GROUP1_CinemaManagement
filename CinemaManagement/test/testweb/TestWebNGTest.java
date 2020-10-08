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
        Thread.sleep(500);

        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(500);

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
//
//    @DataProvider(name = "AdminTestUpdateBlllException")
//    public Object[][] AdminTestUpdateBlllException() {
//        Object[][] obj = new Object[1][2];
//        obj[0][0] = "111111111111111111111111";
//        obj[0][1] = "";
//
//        return obj;
//    }
//
//    @Test(dataProvider = "AdminTestUpdateBlllException", priority = 3, expectedExceptions = Exception.class)
//    public void AdminUpdateBillException(String bPhone, String expect) throws InterruptedException {
//        WebElement uID;
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        try {
//            driver.findElement(By.id("image_update_bill")).click();
//            Thread.sleep(500);
//            driver.findElement(By.name("bPhone")).sendKeys(bPhone);
//            Thread.sleep(500);
//            driver.findElement(By.id("update_bill")).click();
//        } catch (Exception ex) {
//            fail();
//        }
//
//    }

    @Test(priority = 2)
    public void AdminDeleteBill() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("image_delete_bill")).click();
        Thread.sleep(500);
        WebElement uID;
        try {
            uID = driver.findElement(By.id("id_BillName"));
            assertNull(uID);
        } catch (Exception ex) {

        }
    }

    @Test(priority = 3)
    public void AdminLogoutTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("logout")).click();
        Thread.sleep(500);
        WebElement uID;
        try {
            uID = driver.findElement(By.id("carouselExampleIndicators"));
            assertNotNull(uID);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test(priority = 4)
    public void HomePageTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("1")).click();
        Thread.sleep(500);
        WebElement uID;
        try {
            uID = driver.findElement(By.className("title"));
            assertEquals(uID.getText(), "SROOB!");
        } catch (Exception ex) {
            fail();
        }
    }

    @Test(priority = 5)
    public void FilmPageTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("2")).click();
        Thread.sleep(500);
        WebElement uID;
        try {
            uID = driver.findElement(By.id("signIn"));
            assertNotNull(uID);
        } catch (Exception ex) {
            fail();
        }
    }

    @DataProvider(name = "UserRes")
    public Object[][] UserRes() {
        Object[][] obj = new Object[1][7];
        obj[0][0] = "toan";
        obj[0][1] = "toan@gmail.com";
        obj[0][2] = "123";
        obj[0][3] = "123";
        obj[0][4] = "14/08/2000";
        obj[0][5] = "Can Tho";
        obj[0][6] = "0975789765";
        return obj;
    }

    @Test(dataProvider = "UserRes", priority = 6)
    public void UserResgirter(String user, String email, String pass, String confirm, String date, String Address, String SDT) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("signUp")).click();
        Thread.sleep(500);
        driver.findElement(By.id("id_Name")).sendKeys(user);
        Thread.sleep(500);

        driver.findElement(By.id("id_Email")).sendKeys(email);
        Thread.sleep(500);
        driver.findElement(By.id("id_Pass")).sendKeys(pass);
        Thread.sleep(500);

        driver.findElement(By.id("id_ConfirmPass")).sendKeys(confirm);
        Thread.sleep(500);
        driver.findElement(By.id("id_Date")).sendKeys(date);
        Thread.sleep(500);

        driver.findElement(By.id("id_Address")).sendKeys(Address);
        Thread.sleep(500);
        driver.findElement(By.id("id_SDT")).sendKeys(SDT);
        Thread.sleep(500);

        driver.findElement(By.id("id_RES")).click();
        Thread.sleep(500);
        driver.findElement(By.id("id_DangNhap")).click();
        Thread.sleep(500);
        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys(pass);
        Thread.sleep(500);
        driver.findElement(By.id("signIn")).click();
//        WebElement fList = driver.findElement(By.id("flist"));
//        fList.click();
        WebElement uID;
        try {
            uID = driver.findElement(By.id("idTICKET"));
            assertNotNull(uID);
        } catch (Exception ex) {
            uID = null;
            assertNull(uID);
        }
    }

    @Test(priority = 7)
    public void HomePageTest2() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("1")).click();
        Thread.sleep(500);
        WebElement uID;
        try {
            uID = driver.findElement(By.className("title"));
            assertEquals(uID.getText(), "SROOB!");
        } catch (Exception ex) {
            fail();
        }
    }

    @Test(priority = 8)
    public void FilmPageTest2() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("2")).click();
        Thread.sleep(500);
        WebElement uID;
        try {
            uID = driver.findElement(By.id("65"));
            assertNotNull(uID);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test(priority = 9)
    public void OrderTicket() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("68")).click();
        driver.findElement(By.id("69")).click();
        driver.findElement(By.id("70")).click();

        driver.findElement(By.id("cont")).click();
        Thread.sleep(500);
        WebElement uID;
        try {
            uID = driver.findElement(By.id("order"));
            assertNotNull(uID);
        } catch (Exception ex) {
            fail();
        }
    }

    @Test(priority = 10)
    public void BillForm() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("Name")).sendKeys("nghi");
        driver.findElement(By.id("Phone")).sendKeys("12345678");

        driver.findElement(By.id("order")).click();
        Thread.sleep(500);
        WebElement uID;
        try {
            uID = driver.findElement(By.id("totals"));
            assertNotNull(uID);
        } catch (Exception ex) {
            fail();
        }
    }
}

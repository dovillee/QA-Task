import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseTest {
    WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void seUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qacamp.online/?page_id=2");

    }
//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }

    @DisplayName("Light bulb grey while opening the page and is yellow when clicking turn on the light button 1 time")
    @Test
    void turnOnAndOffTheLight() {
        WebElement lightBulb = driver.findElement(By.xpath("//img[@id='myImage']"));
        Assertions.assertEquals("https://www.w3schools.com/js/pic_bulboff.gif", lightBulb.getAttribute("src"), "The light is not turned off");
// Click Turn ON the light
        driver.findElement(By.xpath("//button[text()='Turn on the light']")).click();
        Assertions.assertEquals("https://www.w3schools.com/js/pic_bulbon.gif", lightBulb.getAttribute("src"), "The light is not turned on");
// Click Turn OFF the light
        driver.findElement(By.xpath("//button[text()='Turn off the light']")).click();
        Assertions.assertEquals("https://www.w3schools.com/js/pic_bulboff.gif", lightBulb.getAttribute("src"), "The light is not turned off");
    }

    @DisplayName("Light bulb is yellow while double-clicking")
    @Test
    void turnOnAndOffTheLightWithDoubleClick() {
        WebElement lightBulb = driver.findElement(By.xpath("//img[@id='myImage']"));
        Actions act = new Actions(driver);

// Double-click Turn ON the light
        WebElement turnOnBtn = driver.findElement(By.xpath("//button[text()='Turn on the light']"));
        act.doubleClick(turnOnBtn).perform();
        Assertions.assertEquals("https://www.w3schools.com/js/pic_bulbon.gif", lightBulb.getAttribute("src"), "The light is not turned on");
// Double-click Turn OFF the light
        WebElement turnOffBtn = driver.findElement(By.xpath("//button[text()='Turn off the light']"));
        act.doubleClick(turnOffBtn).perform();
        Assertions.assertEquals("https://www.w3schools.com/js/pic_bulboff.gif", lightBulb.getAttribute("src"), "The light is not turned off");
    }
    @DisplayName("Light bulb is yellow after refreshing the page")
    @Test
    void afterRefreshLightIsTheSame() {
        WebElement lightBulb = driver.findElement(By.xpath("//img[@id='myImage']"));

// Click Turn ON the light
        driver.findElement(By.xpath("//button[text()='Turn on the light']")).click();
        Assertions.assertEquals("https://www.w3schools.com/js/pic_bulbon.gif", lightBulb.getAttribute("src"), "The light is not turned on");
// Refresh the page
        driver.navigate().refresh();

// Assert that light status is the same as it was left
        Assertions.assertEquals("https://www.w3schools.com/js/pic_bulbon.gif", lightBulb.getAttribute("src"), "The light is not turned on");
    }
}

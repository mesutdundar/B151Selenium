package techproed.day04_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.jar.Attributes;

public class C01_getTagNameGetAttribute {
    public static void main(String[] args) {
        System.setProperty("web-driver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");
        // arama kutusunu locate ediniz
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        // arama kutusunun tagName'inin "input" oldugunu test edin
        //alttaki benim yaptigim
//        if (searchBox.getTagName().equals("input")){
//            System.out.println("TEST PASSED");
//        }else System.out.println("TEST FAILED");
//alttaki hocanin yaptigi
        String actualTagName=searchBox.getTagName();
        String expectedTagName ="input";
        if (actualTagName.equals(expectedTagName)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");
        // arama kutusunun name attribute'nun degerinin "field-keywords" oldugunu test edin
        String actualAttribute = searchBox.getAttribute("name");
        String expectedAttribute = "field-keywords";
        if (actualAttribute.equals(expectedAttribute)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");

        // sayfayı kapatın
        driver.close();
    }
}

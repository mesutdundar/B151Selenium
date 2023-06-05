package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_cssSelector {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //Add Element butonuna basin
       /* ilk olarak xpath ile yaptim
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
         */
        driver.findElement(By.cssSelector("button[onclick='addElement()']")).click();
        //Delete butonu'nun gorunur oldugunu test edin
        System.out.println(driver.findElement(By.cssSelector("button[class='added-manually']")).isDisplayed());//true
        //Delete butonuna basin
        driver.findElement(By.cssSelector("button[class='added-manually']")).click();
        //"Add/Remove Elements" yazisinin gorunur oldugunu test edin
        System.out.println(driver.findElement(By.cssSelector("h3")).isDisplayed());//true
        //Sayfayı kapatın
        driver.close();
             /*

        Xpath ve cssSelector arasındaki farklar:

        - Xpath text ile calısır.
        - cssSelector text ile calısmaz
        - Xpath index'e göre arama yapabilir.Daha fazla kombinasyona sahiptir.
        - cssSelector index'e göre arama yapamaz. Daha hızlı calısır

         */
    }
}

package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_WebelementLocators {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //Arama kutusunu locate edelim
        driver.findElement(By.id("twotabsearchtextbox"));
        /*
        Bir webelement locate'ni birden fazla kullanacaksaniz bir WebElement'te degisken olarak atayabilirsiniz.
        Webelement aramakutusu = driver.findElement(By.id("twotabsearchtextbox")); seklinde kullanabiliriz.
       1) Locate islemi bittikten sonra eger webelemente bir metin gondereceksek sendKeys() methodu kullaniriz
        2)webelemente tiklayacaksak click() methodu kullaniriz
        3) webelementin uzerindeki yaziyi almak istiyorsak getText() methodu kullaniriz
        4) sendKeys() methodundan sonra (yani Webelemente metin gonderdikten sonra ) Keys.ENTER ile ya da submit() methodu ile manuel
        olarak enter yaptigimiz gibi otomasyonda da yapabiliriz.
       */
        //Arama kutusuna iphone yazdıralım ve aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sayfayı kapatalım
        driver.close();
        //Bir webelementin locate'ini birden fazla kullanacaksanız bir Webelement'e değişken olarak atayabilirsiniz.

    }
}

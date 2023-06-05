package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");
        // arama kutusuna "city bike"  yazıp aratın
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("city bike");
        searchBox.submit();

       // Hybrid Bikes bölümüne tıklayın
        driver.findElement(By.xpath("//span[text()='hybrid bike']")).click();
        // sonuc sayısını yazdırın
      String sonucYazisi[]= driver.findElement(By.xpath("//span[text()='1-16 of 70 results for']")).getText().split(" ");
        System.out.println(Arrays.toString(sonucYazisi));
        System.out.println(sonucYazisi[2]);
        // ilk ürününe tıklayın
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        //xpath ile secimimiz unique degilse yukaridaki gibi index verip secebiliyoruz icinden
       //Sayfayı kapatınız
        Thread.sleep(3000);
      driver.close();
    }
}

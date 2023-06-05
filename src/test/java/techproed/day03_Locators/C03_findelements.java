package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_findelements {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        
        //Sayfadaki linklerin sayısını ve linkleri yazdıralım
        /*
        findelement ile bir webelemente ulasabilirken , birden fazla webelement icin findelements() methodunu kullaniriz.
        Bu webelementlerin sayisina ulasmak icin yada bu webelementlerin yazisini konsola yazdirabilmek icin 
        List<Webelement> linklerListersi = driver.findElements(By.locator("Locator degeri")) olarak kullaniriz.
        Olusturdugumuz oldugumuz listi loop ile konsola yazdirabiliriz.
       
          */
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("linklerListesi.size() = " + linklerListesi.size());
//        for (WebElement w: linklerListesi ) {
//            if (!w.getText().isEmpty()){
//            System.out.println(w.getText());// getText() methodu webelementin ismini almak icin kullaniriz
//        }
//        }
    //lambda ile yazdiralim
        linklerListesi.forEach(link -> {if(!link.getText().isEmpty())
            {System.out.println(link.getText());}});
        System.out.println("##############################");
        //Shop dealsin Electronik webElementinin yazisini yazdiralim
        System.out.println(driver.findElement(By.linkText("Shop great deals now")).getText());
        //sayfayi kapatalim
        driver.close();


    }
}

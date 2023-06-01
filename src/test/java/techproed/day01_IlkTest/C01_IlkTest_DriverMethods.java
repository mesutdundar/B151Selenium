package techproed.day01_IlkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTest_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resources/drivers/chromedriver.exe");
        //Java uygulamalarinda system ozelliklerini ayarlamak icin setProperty() methodu ile kullaniriz
        //setProperty() methodu ile classimiza driverin fiziki yolunu belirtiriz

        System.out.println(System.getProperty("chromeDriver"));
        //getProperty() methodu ile "Key" degerini girerek "value" ya ulasabilirim.

        WebDriver driver = new ChromeDriver();
        //chromeDriver turunde yeni bir obje olusturduk
        driver.get("https://techproeducation.com");//get() methodu ile String olarak girilen url'ye gider


    }
}

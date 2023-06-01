package techproed.day02_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ManageMethods_ImplicitlyWait {
    public static void main(String[] args) {
        //Thread.sleep Javadan gelir kac saniye dersek kodu bekletir ama
        // implicitlyWait() methodu Selenium dan gelir ve istenilen sayfa acilincaya kadar bekleme suresini belirtir.
        // implicitlyWait() methodu ile istedigimiz kadar bekleme suresi koyabiliriz.
        // Web elementini gordugu anda bir alt satira gecerek kodu okumaya devam eder

        System.setProperty("web-driver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        /*
        implicitlyWait(Duration.ofSeconds(20)) Sayfadaki webElementleri gorunur olana kadar(sayfada olusana kadar)
        maximum 20saniye bekler. Eger webElementler 2 saniyede olusursa 2 saniye bekler ve alt satira gecer.Fakat
        belirttigimiz maximum sure boyunca internetten yada sayfadan kaynakli olarak webElementler olusmazsa testimiz
        fail verir

         Thread.sleep() java kodlarını bizim belirttiğimiz süre kadar bekler. 30 saniye beklemesini belirtirsem
         30 saniye bekler ve alt satıra geçer.
         */
        String techproUrl ="https://techproeducation.com";
        String amazonUrl = "https://amazon.com";
        //techproed sayfasina gidelim

        driver.get(techproUrl);
        //amazona gidelim
        driver.navigate().to(amazonUrl);
        //techpro sayfasina geri donelim
        driver.navigate().back();
        //sayfa basliginin Techpro icerdigini test edelim
        String actualTitle =driver.getTitle();
        String arananKelime ="Techpro";
        if (actualTitle.contains(arananKelime)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED ==>"+actualTitle );

        //tekrar amazon sayfasina gidelim
        driver.navigate().forward();
        //sayfa basliginin Amazon icerdigini test edelim
        if (driver.getTitle().contains("Amazon")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //sayfayi kapatiniz
        driver.close();

    }
}

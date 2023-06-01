package techproed.day01_IlkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");//key ilk classtaki gibi de bu sekildeki gibi de girilebilir.
        WebDriver driver = new ChromeDriver();

        //getTitle() = Sayfa basligini verir
        driver.get("https://amazon.com");
        System.out.println("Amazon Actual Title ="+driver.getTitle());
        System.out.println("Amazon actual url ="+driver.getCurrentUrl());
        String amazonWindowHandle =driver.getWindowHandle();
        System.out.println("Amazon Window Handle Degeri ="+amazonWindowHandle);


        driver.get("https://techproeducation.com");
        System.out.println("Techproeducation Actual Title ="+ driver.getTitle());//getTitle() methodu Sayfa basligini verir.

        //getCurrrentUrl() = Gidilen sayfanin (en son) Url'sini verir.
        System.out.println("Techproed actual url ="+driver.getCurrentUrl());//en son gittigi sayfanin url'sini verir.

        //getPageSource() methodu icinde olunan sayfanin kaynak kodlarini verir
      //  System.out.println(driver.getPageSource()); bilerek yoruma aldik her calistiridgimizda butun kaynak kodlarini verecegi icin

        //getWindowHandle() gidilen sayfanin handle degerini(hashKod) verir.Bu handle degerini sayfalar arasi gecis icin kullaniriz
        System.out.println("Techproed Window handle deger ="+driver.getWindowHandle());


    }
}

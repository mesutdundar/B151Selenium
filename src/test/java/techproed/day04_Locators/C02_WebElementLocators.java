package techproed.day04_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_WebElementLocators {
    public static void main(String[] args) {
        System.setProperty("chromeDriver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike" + Keys.ENTER);
        //amazon sayfasinin sol ust kosesinde su sonucu gorduk: 1-16 of 177 results for "city bike"

        //sonuc yazisini yazdiralim
        //sonuc(1-16 of 177 results for "city bike") uzerine gelip sag click yaptik ve bu sonuc yazisinin
        //HTML kodlarini gorduk. span tagi yaninda 154 sonuc yaziliydi, oysa asagi cubukta 189 sonuc oldugunu
        // degerin uzerine tiklayinca gormustuk. Bizim sonucun tamamini almaya ihtiyacimiz vardi.
        // Tagi <div attribute'u class olan ve degeri "sg-col-inner"> kismini secmeye
        //karar verdik cunku class tum sonuclari kapsayacaktir. class'in degeri uzerine cift tikladik ve
        //CTRL C, CTRL F ile bu degeri asagi cubuk icinde yazdirdik. Biz bu degeri tiklayinca asagida 1 of 120
        //kadar bu degerin oldugunu gorduk. Bircok sonuc yazisindan ilk elementi almak istedik, bunu
        //kendimiz unique yapmak istedik.
        List<WebElement> sonucYazilari=driver.findElements(By.className("sg-col-inner")); //120 tane ayni deger var ve biz bunu bir liste
        //assign ettik. class'in degerini aldigimizdan className ile elementi arariz.
        //ilk sonuc yazisini bulacagiz cunku ilk sonuc yazisi tarali olacak ve bu unique olacak
        WebElement sonucYazisi=sonucYazilari.get(0);    //Listlerde index 0'dan baslar.
        // Ilk sonuc yazisini almak icin 0. index'i sectik.
        //System.out.println(sonucYazisi); bu sekilde yazinca String olarak sonucu gormeyiz, sonucYazisinin
        // hashcode/unu verir. String olarak yazdirmak icin getText()'i kullaniriz
        System.out.println(sonucYazisi.getText()); //1-16 of 186 results for "city bike"


        //sonuc sayisini yazdiralim
        String sonucSayisi []=sonucYazisi.getText().split(" ");
        System.out.println(Arrays.toString(sonucSayisi));//[1-16, of, 189, results, for, "city, bike"]
        System.out.println(sonucSayisi[2]);//189  bosluklardan alinca 2.index'te 189'ya ulasiriz
        /*
        sonuc sayimiz 186. Biz bunu kodumuzu calistirinca console'da gorduk. 1-16 of 189 olarak. Bu 186'yi almak
        icin split methodu ile 1-16 of 189 daki bosluklari alsak ve 186'yi yazdirsak olur
        Bunun icin sonucYazisi webelementini aldik
        sonucYazisi.getText() ile String'e cevirdik ve yanina split(" ") yazarak bosluklardan ayirma yaptik.
        split kullaninca Array return edeceginden, String bir Array'e assign ederiz.Array ile ilgili yazdirma
        yapilinca Arrays.toString yazmak zorundayiz. Boylece sonucu alabiliriz.

         */
        //ilk urunun locateni alin
       List<WebElement> sonuclar = driver.findElements(By.className("s-image"));
       WebElement ilkUrun =sonuclar.get(0);
        //ilk urunun gorunur olup olmadigini true, false seklinde yazdirin
        System.out.println(ilkUrun.isDisplayed());
        //ilk urunun erisilebilir olup olmadigini true,false seklinde yazdiriniz
        System.out.println(ilkUrun.isEnabled());
        //ilk urunun secilebilir olup olmadigini true,false seklinde yazdiriniz.
        boolean secilebilirMi=ilkUrun.isSelected();
        System.out.println(secilebilirMi);
        //ilk urune tiklayiniz
        ilkUrun.click();
        //sayfayi kapatiniz
        driver.close();
        /*
        Inceledigimiz HTML kodunda div, table, tbody taglarini ustten alta dogru sirali halde gorduk.Parent olanlar
ustte, child'lar kendi parent'larinin altinda siralanmis.
td taglari ise ayni hizada alt alta sirali idi ve td taglari birbirinin kardesleridir.

Tags: < > şeklinde görülen komutlara etiket (tag) adı verilir.
parent-child-sibling relationship(Ebeveyn-çocuk-kardeş ilişkisi) hakkında konuştuğumuzda, yalnızca tag adları önemlidir
<table>, <div> in çocuğudur(child) ve <tbody>, <tr> in ebeveyndir (parent)
<td> taglari ise siblings (kardes)'dir
         */
/*
Absolute xpath:

Bizim nereden baslayacagimiz tamamen inceledigimiz HTML koduna bagli olup, ilgili webelement icin en tepesindeki parent tagi neyse onunla baslariz. bastaki tag oncesinde // koyariz ve sonrasinda her tag arasina
bir slash / isareti koyariz.
Absolute xpath yazmak icin en basa // sonraki her adimda / yazarak hedef web element'e kadar tum
tag'lar yazilir.
Eger ayni path'e sahip birden fazla element varsa index kullanilabilir. [2] gibi
Eger bir parent'in grand child'lari icinde unique bir tag varsa parent // grand child yazilabilir
// div/ table/ tbody  Bizim ulasmak istedigimiz tbody ise div ile basliyoruz, sonra gelen table ve tbody'e
geldik inceledigimiz HTML kodunda
// tbody / tr / td[3] // span //HTML kodunda 3 tane sirasiyla td tagi vardi bu nedenle td[3] yazildi
td tagi altinda bir a tagi vardi onu atlamak isteyince onu yazmadan // yaziyoruz
// tbody / tr / td[3] / a / span
 */
        //asagidaki de relative xpath ornegi
        //tagName[@attributeIsmi='attributeValue'] Ornek //input[@id='twotabsearchtextbox']
    }
}

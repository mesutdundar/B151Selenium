package techproed.Utils;
public class Utils {
    public static void sleeping(int milisecond){
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
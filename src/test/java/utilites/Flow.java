package utilites;

import org.openqa.selenium.interactions.Actions;

public class Flow {

    public static void wait(int milSec){
        try{
            Thread.sleep(milSec);
        }catch (InterruptedException e){
            System.out.println("Interruption happened");
        }

    }
    public static void scrollDown(int deltaY){
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0, deltaY ).perform(); //-200 scroll up 200 scroll down


    }
    public static void scrollUp(int deltaY){
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollByAmount(0,-deltaY).perform();

    }
}

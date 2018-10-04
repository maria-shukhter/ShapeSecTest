import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicContentPage extends AbstractPage {

    public final String dynamicContentUrl = "https://the-internet.herokuapp.com/dynamic_content";
    private HashMap<String, String> mapImages = new HashMap<String, String>();
    String linkToImages= "https://the-internet.herokuapp.com";
    {
        mapImages.put(linkToImages + "/img/avatars/Original-Facebook-Geek-Profile-Avatar-3.jpg", "Punisher");
        mapImages.put(linkToImages + "/img/avatars/Original-Facebook-Geek-Profile-Avatar-1.jpg", "Child");
        mapImages.put(linkToImages + "/img/avatars/Original-Facebook-Geek-Profile-Avatar-2.jpg", "Warrior");
        mapImages.put(linkToImages + "/img/avatars/Original-Facebook-Geek-Profile-Avatar-5.jpg","Demon");
        mapImages.put(linkToImages + "/img/avatars/Original-Facebook-Geek-Profile-Avatar-6.jpg", "Soldier");
        mapImages.put(linkToImages + "/img/avatars/Original-Facebook-Geek-Profile-Avatar-7.jpg", "Jester");

    }

    public void initTest(){
        setDriver(new ChromeDriver());
        getDriver().navigate().to(dynamicContentUrl);
    }

    public boolean imageTest(){
        List<WebElement> image=((ChromeDriver)getDriver()).findElementsByCssSelector
                (".large-2.columns >img");
        boolean result= true;
        for(int i =0; i<image.size(); i++) {
            String key = image.get(i).getAttribute("src");
            //System.out.println(key);
            System.out.println(mapImages.get(key));
            if(key.equals(linkToImages+"/img/avatars/Original-Facebook-Geek-Profile-Avatar-3.jpg")){
                result = false;
            }
        }
        return result;
    }

    public void seleniumClose() {
        getDriver().close();
        getDriver().quit();

    }

    public boolean dynamicContentTest() {
        List<WebElement> elementsList= ((ChromeDriver)getDriver()).findElementsByCssSelector(".large-10.columns:not(.large-centered)");
        ArrayList<String> textsList = new ArrayList<String>();
        for(WebElement element : elementsList){
            textsList.add(element.getText());
        }
        int max=0;
        String  longestWord ="";

        boolean test = false;
        for(int i =0; i<textsList.size(); i++ ){
            String text = textsList.get(i);
            String[] words = text.split("(,|\\.)?\\s+");
            words[words.length-1] = words[words.length-1].substring(0,words[words.length-1].length()-1 );
            for(String str: words){
                if(str.length() >=10 ){
                    test = true;
                }

                if(str.length()>max){
                    max = str.length();
                    longestWord=str;
                }
            }

        }
        System.out.println(longestWord + "is a  longest word");
        return test;
    }
}

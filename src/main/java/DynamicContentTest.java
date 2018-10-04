import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicContentTest {

    DynamicContentPage page = new DynamicContentPage();


    @BeforeEach
    public void selemiunIn (){
        page.initTest();
    }

    @Test
    public void assertDynamicText(){
        boolean test = page.dynamicContentTest();
        assertTrue(test);
    }
    @Test
    public void assertTheImage() {
        boolean result = page.imageTest();
        assertTrue(result);
    }

   @AfterEach
    public void seleniumClose(){
        page.seleniumClose();

   }




}

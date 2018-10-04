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
    public void assertTextHas10CharWord(){
        boolean test = page.dynamicContentTest();
        assertTrue(test);
    }
    @Test
    public void assertPunisherImageDoesntAppear() {
        boolean result = page.imageTest();
        assertTrue(result);
    }

   @AfterEach
    public void seleniumClose(){
        page.seleniumClose();

   }




}

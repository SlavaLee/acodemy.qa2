package hooks;

import io.cucumber.java.After;
import utils.LocalDriverManager;

public class hook {
    
    @After
    public void tearDown() {
        LocalDriverManager.closeDriver();
    }
}

package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;


public class baseclass {
    public WebDriver driver;

    public Logger logger;

    public ResourceBundle rb;

    @BeforeClass
    @Parameters("browser")
    public void setup(String br) {

        rb = ResourceBundle.getBundle("config");
        logger = LogManager.getLogger(this.getClass());
        //WebDriverManager.chromedriver().setup();

        if(br.equals("chrome"))
        {
        driver = new ChromeDriver();
        }
        else if (br.equals("edge"))
        {
            driver = new EdgeDriver();
        }
        else {
            driver = new FirefoxDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(rb.getString("appURL"));
        //driver.get("http://localhost/opencartproject/index.php");
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }
    public String randomNumber(){
        String generatedString2 = RandomStringUtils.randomNumeric(3);
        return (generatedString2);

    }
    public String randomAlphaNumeric(){
        String st = RandomStringUtils.randomAlphabetic(5);
        String num = RandomStringUtils.randomNumeric(2);
        return (st + "@" +num);
    }
    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.clearProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (Exception e) {
            e.getMessage();
        }
        return destination;
    }
    }


}

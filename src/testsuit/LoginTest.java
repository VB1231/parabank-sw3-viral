package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityTest;

public class LoginTest extends UtilityTest {
    @Before
    public void setUp(){openBrowser();}
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //* Enter valid username
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "viral4");
        //* Enter valid password
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "Welcome123");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //* Verify the ‘Accounts Overview’ text is display
        String vAccountOver = "Accounts Overview";
        Assert.assertEquals(vAccountOver, getTextOnElement(By.xpath("//h1[@class='title']")));
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
    }

    //2.verifyTheErrorMessage
    @Test
    public void verifyTheErrorMessage() {
        //* Enter invalid username
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "viral");
        //* Enter invalid password
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "Welcome");
        //* Click on Login button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //* Verify the error message ‘The username and password could not be verified.’
        String vErrorMsg = "An internal error has occurred and has been logged.";
        Assert.assertEquals(vErrorMsg, getTextOnElement(By.xpath("//p[@class='error']")));
    }
    @Test
    //3.userShouldLogOutSuccessfully
    public void userShouldLogOutSuccessfully(){

       //* Enter valid username
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[1]/input[1]"), "viral4");
        //* Enter valid password
        setTextOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[2]/input[1]"), "Welcome123");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//body/div[@id='mainPanel']/div[@id='bodyPanel']/div[@id='leftPanel']/div[@id='loginPanel']/form[1]/div[3]/input[1]"));
        //* Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        //* Verify the text ‘Customer Login’
        String vAccountOver = "Customer Login";
       Assert.assertEquals(vAccountOver, getTextOnElement(By.xpath("//h2[contains(text(),'Customer Login')]")));
    }
    @After
    public void tearDown(){closeBrowser();}
}

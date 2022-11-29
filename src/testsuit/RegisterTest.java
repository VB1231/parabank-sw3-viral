package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.UtilityTest;

public class RegisterTest extends UtilityTest {
    //1.verifyThatSigningUpPageDisplay
    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    //1.verifyThatSigningUpPageDisplay
    public void verifyThatSigningUpPageDisplay() {
        //* click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //* Verify the text ‘Signing up is easy!’
        String vSignUp = "Signing up is easy!";
        Assert.assertEquals(vSignUp, getTextOnElement(By.xpath("//h1[contains(text(),'Signing up is easy!')]")));
    }

    //2.userSholdRegisterAccountSuccessfully
    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //* click on the ‘Register’ link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        //         * Enter First name
        setTextOnElement(By.xpath("//input[@id='customer.firstName']"), "viral");
        //* Enter Last name
        setTextOnElement(By.xpath("//input[@id='customer.lastName']"), "brahm");
        //       * Enter Address
        setTextOnElement(By.xpath("//input[@id='customer.address.street']"), "15 The Avenue");
        //     * Enter City
        setTextOnElement(By.xpath("//input[@id='customer.address.city']"), "United Kingdom");
        //   * Enter State
        setTextOnElement(By.xpath("//input[@id='customer.address.state']"), "London");
        // * Enter Zip Code
        setTextOnElement(By.xpath("//input[@id='customer.address.zipCode']"), "wd23 3ab");
        //* Enter Phone
        setTextOnElement(By.xpath("//input[@id='customer.phoneNumber']"), "01923 630 555");
        //* Enter SSN
        setTextOnElement(By.xpath("//input[@id='customer.ssn']"), "12345");
        //* Enter Username
        driver.findElement(By.xpath("//input[@id='customer.username']")).clear();
        setTextOnElement(By.xpath("//input[@id='customer.username']"), "viral4");
        //* Enter Password
        setTextOnElement(By.xpath("//input[@id='customer.password']"), "Welcome123");
        //* Enter Confirm
        setTextOnElement(By.xpath("//input[@id='repeatedPassword']"), "Welcome123");
        //* Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        //* Verify the text 'Your account was created successfully. You are now logged in.’
        String vYourLogin = "Your account was created successfully. You are now logged in.";
        Assert.assertEquals(vYourLogin, getTextOnElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]")));
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
    }
    @After
    public void tearDown(){closeBrowser();}


}

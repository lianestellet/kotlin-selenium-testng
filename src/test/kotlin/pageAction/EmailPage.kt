package PageAction.Outlook

import utils.Generate
import utils.SeleniumEngine
import utils.Wait
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class EmailPage {

    constructor() {
        this.newUsername = Generate.username()
    }

    constructor(username: String) {
        this.newUsername = username
    }

    init {
        PageFactory.initElements(SeleniumEngine.driver, this)
    }

    private val newUsername: String

    @FindBy(name="MemberName")
    private val emailInput: WebElement? = null

    @FindBy(id="iSignupAction")
    private val nextButton: WebElement? = null

    fun nextStep() {
        emailInput?.sendKeys(newUsername)
        nextButton?.click()
        Wait.visibilityByElementId("Password")
    }

    fun getMessage(): String {
        return SeleniumEngine.driver.findElement(
                By.xpath("//*[@id='CredentialsInputPane']/div")).text
    }

}
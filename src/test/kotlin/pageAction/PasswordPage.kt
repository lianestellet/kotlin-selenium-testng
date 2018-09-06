package PageAction.Outlook

import utils.Generate
import utils.SeleniumEngine
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import utils.Wait

class PasswordPage {

    constructor () {
        newPassword = Generate.password()
    }

    constructor (password: String) {
        newPassword = password
    }

    init {
        PageFactory.initElements(SeleniumEngine.driver, this)
    }

    private val newPassword: String

    @FindBy(id = "PasswordInput")
    private val passwordInput: WebElement? = null

    @FindBy(tagName = "label")
    private val emailsOptionsCheckbox: WebElement? = null

    @FindBy(id="iSignupAction")
    private val nextButton: WebElement? = null

    fun nextStep() {
        passwordInput?.sendKeys(newPassword)
        emailsOptionsCheckbox?.click()
        nextButton?.click()
        Wait.visibilityByElementId("FirstName")
    }

    fun getPageMessage(): String {
        return SeleniumEngine.driver.findElement(
                By.xpath("//*[@id='CredentialsInputPane']/div")).text
    }

}
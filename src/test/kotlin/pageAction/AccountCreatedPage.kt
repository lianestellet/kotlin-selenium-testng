package PageAction.Outlook

import utils.SeleniumEngine
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class AccountCreatedPage {

    init {
        PageFactory.initElements(SeleniumEngine.driver, this)
    }

    @FindBy(tagName = "h2")
    private val welcomeMessage: WebElement? = null

    fun getWelcomeMessage():String {
        return welcomeMessage?.text.toString()
    }

}
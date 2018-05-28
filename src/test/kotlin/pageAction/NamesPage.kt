package PageAction.Outlook

import utils.Generate
import utils.SeleniumEngine
import utils.Wait
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class NamesPage {

    constructor() {
        newFirstName = Generate.name()
        newLastName = Generate.name()
    }

    private val newFirstName: String
    private val newLastName: String

    @FindBy(id= "FirstName")
    private val firstNameInput: WebElement? = null

    @FindBy(id= "LastName")
    private val lastNameInput: WebElement? = null

    @FindBy(id= "iSignupAction")
    private val nextButton: WebElement? = null

    init {
        PageFactory.initElements(SeleniumEngine.driver, this)
    }

    fun nextStep() {
        firstNameInput?.sendKeys(newFirstName)
        lastNameInput?.sendKeys(newLastName)
        nextButton?.click()
        waitPageTitleChange()
    }

    fun getPageMessage(): String {
        return SeleniumEngine.driver.findElement(
                By.xpath("//*[@id='ProfileAccrualInputPane']/div[2]")).text
    }

    fun waitPageTitleChange() {
        Wait.elementByPathShowText("//div[@id='iPageTitle']", "Add details")
    }

}//*[@id="ProfileAccrualInputPane"]/div[2]/text()
package PageAction.Outlook

import utils.Generate
import utils.SeleniumEngine
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.Select
import utils.Wait

class DetailsPage {

    init {
        PageFactory.initElements(SeleniumEngine.driver, this)
    }

    @FindBy(id = "Country")
    private val country: WebElement? = null

    @FindBy(id = "BirthDay")
    private val birthDay: WebElement? = null

    @FindBy(id = "BirthMonth")
    private val birthMonth: WebElement? = null

    @FindBy(id = "BirthYear")
    private val birthYear: WebElement? = null

    @FindBy(id = "iSignupAction")
    private val nextButton: WebElement? = null

    private fun birthDayList(): Select {
        return Select(birthDay)
    }

    private fun birthMonthList(): Select {
        return Select(birthMonth)
    }

    private fun birthYearList(): Select {
        return Select(birthYear)
    }

    private fun countryList(): Select {
        return Select(country)
    }

    fun nextStep() {
        val newYear = Generate.randomNumberBetween(1980, 1999).toString()
        val newMonth = Generate.randomNumberBetween(1,12).toString()
        val newDay = Generate.randomNumberBetween(1, 28).toString()

        countryList()?.selectByVisibleText("Canada")
        birthYearList()?.selectByValue(newYear)
        birthMonthList()?.selectByValue(newMonth)
        birthDayList()?.selectByValue(newDay)

        nextButton?.click()
        waitCaptchaPage()
    }

    private fun waitCaptchaPage() {
         Wait.visibilityByElementId("hipDesc")
    }

    fun getPageMessage(): String {
        return SeleniumEngine.driver.findElement(
                By.xpath("//*[@id='iPageTitle']")).text
    }

}
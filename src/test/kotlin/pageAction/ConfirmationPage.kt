package PageAction.Outlook

import utils.SeleniumEngine
import utils.Wait
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class ConfirmationPage {

    @FindBy(css = "alert.alert-error.floatLeft")
    private val captchaError: WebElement? = null

    private var isSmsDone: Boolean = true
    private var isCaptchaDone: Boolean = true

    fun manualConfirmationStep() {
        `get actual confirmation option`()
    }

    private fun `get actual confirmation option`() {
        if(`check if is sms page`()){
            `wait user finish sms step`()
        }
        else {
            `wait user finish captcha step`()
        }
    }

    private fun `wait user finish sms step`() {
        while (isSmsDone){
            Wait.seconds(3)
            `check if is sms page`()
        }
    }

    private fun `wait user finish captcha step`() {
        while(isCaptchaDone){
            Wait.seconds(3)
            checkCaptchaSuccess()
        }
    }

    private fun `check if is sms page`(): Boolean {
        try {
            val smsMessageForm = SeleniumEngine.driver.findElement(By.id("wlspispHipChallengeContainer"))
        }
        catch (e: Exception){
            isSmsDone = false
        }

        return isSmsDone
    }

    private fun checkCaptchaSuccess() {
        try {
            val captchaButton = SeleniumEngine.driver.findElement(
            By.ByCssSelector(".btn.btn-block.captchaHIPLinks"))
        }
        catch(e: Exception) {
            isCaptchaDone = false
        }

    }

    fun getPageMessage(): String {

        var messageCssPath = when {
            `check if is sms page`() -> ".col-md-24.text-title.forSmsHip"
            else -> ".btn.btn-block.captchaHIPLinks"
        }

        return SeleniumEngine.getTextFromElementWithCss(messageCssPath)

    }
}
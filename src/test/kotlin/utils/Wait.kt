package utils

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class Wait (){

    companion object {

        fun visibilityByElementId(id: String): ExpectedCondition<WebElement>? {
            return ExpectedConditions.visibilityOfElementLocated(By.id(id))
        }

        fun visibilityByXpath(path: String): ExpectedCondition<WebElement>? {
            return ExpectedConditions.visibilityOfElementLocated(By.xpath(path))
        }

        fun elementByPathShowText(path: String, text: String): Boolean? {
            return wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(path), text));
        }

        private val wait = WebDriverWait(SeleniumEngine.driver, 1)

        fun seconds(seconds: Long){
            Thread.sleep(seconds * 1000)
        }
    }
}
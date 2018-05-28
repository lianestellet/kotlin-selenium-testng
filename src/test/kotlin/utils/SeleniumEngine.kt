package utils

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit
import javax.naming.Context

object SeleniumEngine {

    lateinit var driver: WebDriver

    fun getTextFromElementWithCss(cssSelector: String): String{
        return driver.findElement(
                By.ByCssSelector(cssSelector)).text
    }

    fun defaultChromeSetup() {
        val options = ChromeOptions()
        options.addArguments("--start-maximized")
        setupDriver(options)
    }

    private fun setupDriver(options: ChromeOptions) {
        println("Configurando o Chrome")
        System.setProperty("webdriver.chrome.driver", Constants.Config.driverPath)
        driver = ChromeDriver(options)
        driver?.manage()?.timeouts()?.implicitlyWait(5, TimeUnit.SECONDS)
        println("Chrome inicializado")
    }

    fun closeDriver() {
        driver.close()
    }

}
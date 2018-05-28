package utils

import java.net.URI

object Redirect {

    val driver = SeleniumEngine.driver

    fun accessUrl(url: String){
        driver.get(URI(Resources.value(url)).toString())
    }
}
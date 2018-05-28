package utils

object Constants {

    object Config {
        private val rootPath = System.getProperty("user.dir")!!
        val driverPath = "$rootPath/drivers/chromedriver.exe"
        val propertyPath = "$rootPath/src/test/resources/config.properties"
    }

}
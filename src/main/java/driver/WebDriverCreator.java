package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverCreator {

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDiver();
        }

        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDiver();
        }
    }

    public static WebDriver createChromeDiver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    public static WebDriver createYandexDriver() {
        // Указываем путь к yandexdriver
        System.setProperty("webdriver.chrome.driver", "D:\\Diplom_3\\yandex driver\\yandexdriver.exe");

        // Настройки для ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Жеконя\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--disable-features=DarkMode"); // Отключение темной темы
        options.addArguments("--disable-notifications");    // Отключение уведомлений

        // Создаем драйвер и переходим на страницу
        return new ChromeDriver(options);
    }
}
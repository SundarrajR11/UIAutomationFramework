package com.ecom.factoryutils;

import com.ecom.enums.EwaitStrategy;
import com.ecom.constants.FrameConstants;
import com.ecom.exceptions.InValidWaitStrategyException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.ecom.driver.DriverManager.getDriver;

/**
 * Factory class for performing explicit waits on web elements.
 *
 * <p>This class provides a factory method to perform explicit waits on web elements based on
 * the specified wait strategy. It supports strategies such as waiting for element presence,
 * clickable state, visibility, or no wait at all.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * By elementLocator = By.id("example");
 * WebElement element = WaitFactory.performExplicitWait(EwaitStrategy.CLICKABLE, elementLocator);
 * }
 * </pre>
 */
public final class WaitFactory {

    // Private constructor to prevent instantiation of this class
    private WaitFactory() {}

    /**
     * Performs an explicit wait on the specified web element based on the given wait strategy.
     *
     * @param ewaitStrategy the wait strategy to be applied (e.g., CLICKABLE, PRESENCE, VISIBLE, NONE).
     * @param by the By locator for the web element to wait for.
     * @return the WebElement after the wait operation.
     * @throws InValidWaitStrategyException if an invalid wait strategy is provided.
     */
    public static WebElement performExplicitWait(EwaitStrategy ewaitStrategy, By by) {
        switch (ewaitStrategy) {
            case CLICKABLE -> {
                return new WebDriverWait(getDriver(), Duration.ofSeconds(FrameConstants.getExplicitWait()))
                        .until(ExpectedConditions.elementToBeClickable(by));
            }
            case PRESENCE -> {
                return new WebDriverWait(getDriver(), Duration.ofSeconds(FrameConstants.getExplicitWait()))
                        .until(ExpectedConditions.presenceOfElementLocated(by));
            }
            case VISIBLE -> {
                return new WebDriverWait(getDriver(), Duration.ofSeconds(FrameConstants.getExplicitWait()))
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
            }
            case NONE -> {
                return getDriver().findElement(by);
            }
            default -> throw new InValidWaitStrategyException("Invalid wait strategy: " + ewaitStrategy);
        }
    }
}

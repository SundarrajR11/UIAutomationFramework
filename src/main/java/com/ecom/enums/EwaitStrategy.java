package com.ecom.enums;
/**
 * Enum representing different wait strategies for web element synchronization.
 *
 * <p>This enum provides options for specifying the wait strategy used to synchronize
 * with web elements. It includes strategies such as waiting for element presence,
 * clickable state, visibility, or no wait at all.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * // to do
 * }
 * </pre>
 */
public enum EwaitStrategy {
    /**
     * Waits for the presence of the element.
     */
    PRESENCE,

    /**
     * Waits for the element to be clickable.
     */
    CLICKABLE,

    /**
     * Waits for the element to be visible.
     */
    VISIBLE,

    /**
     * Does not apply any waiting strategy.
     */
    NONE
}
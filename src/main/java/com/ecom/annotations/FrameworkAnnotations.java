package com.ecom.annotations;


import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Annotation to provide metadata for framework methods.
 *
 * <p>This annotation can be applied to methods to specify the authors,
 * categories, and devices relevant to the method. It is primarily used for
 * documentation and organizational purposes within the framework.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @FrameworkAnnotations(
 *     authors = {EAuthors.JOHN_DOE, EAuthors.JANE_DOE},
 *     categories = {ECategories.REGRESSION, ECategories.SMOKE},
 *     devices = {EDevices.MOBILE, EDevices.DESKTOP}
 * )
 * public void testMethod() {
 *     // test implementation
 * }
 * }
 * </pre>
 *
 * @see com.ecom.enums.EAuthors
 * @see com.ecom.enums.ECategories
 * @see com.ecom.enums.EDevices
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotations {

    /**
     * Specifies the authors of the annotated method.
     *
     * <p>This element is used to indicate who wrote or contributed to the method.
     * It helps in tracking contributions and maintaining accountability.</p>
     *
     * @return an array of {@link EAuthors} enums representing the authors.
     */
    EAuthors[] authors();

    /**
     * Specifies the categories of the annotated method.
     *
     * <p>This element is used to classify the method into specific categories
     * such as regression tests, smoke tests, etc. It aids in organizing and
     * filtering test methods based on their categories.</p>
     *
     * @return an array of {@link ECategories} enums representing the categories.
     */
    ECategories[] categories();

    /**
     * Specifies the devices applicable to the annotated method.
     *
     * <p>This element is used to indicate which devices (e.g., mobile, desktop)
     * the method is intended to be tested on. It helps in targeting the method
     * to relevant devices for testing purposes.</p>
     *
     * @return an array of {@link EDevices} enums representing the devices.
     */
    EDevices[] devices();
}
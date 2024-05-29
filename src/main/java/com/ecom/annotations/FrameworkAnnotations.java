package com.ecom.annotations;


import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import org.testng.annotations.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotations {

    EAuthors[] authors();
    ECategories[] categories();
    EDevices[] devices();
}
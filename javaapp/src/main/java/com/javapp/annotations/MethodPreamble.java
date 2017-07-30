package com.javapp.annotations;

import java.lang.annotation.Documented;

@Documented
public @interface MethodPreamble {

  String description();

  String[] variables() default "";

  String returnVar();

}

package com.javapp.annotations;

import java.lang.annotation.Documented;

/**
 * java.annotations
 * Created by lusinabrian on 25/12/16.
 * Description: preamble Annotation for each class
 */

@Documented
public @interface ClassPreamble{
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    // Note use of array
    String[] reviewers();
}

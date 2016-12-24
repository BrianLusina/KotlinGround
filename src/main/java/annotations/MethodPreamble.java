package annotations;

/**
 * annotations
 * Created by lusinabrian on 25/12/16.
 * Description:Pre-amble for methods
 */
public @interface MethodPreamble {
    String description();
    String[] variables() default "";
    String returnVar();

}

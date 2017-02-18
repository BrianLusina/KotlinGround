package annotations;

import java.lang.annotation.Documented;

/**
 * annotations
 * Created by lusinabrian on 25/12/16.
 * Description:Pre-amble for methods
 */
@Documented
public @interface MethodPreamble {
    String description();
    String[] variables() default "";
    String returnVar();

}

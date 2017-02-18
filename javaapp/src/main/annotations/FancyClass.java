package main.annotations;

/**
 * annotations
 * Created by lusinabrian on 25/12/16.
 * Description:
 */
@ClassPreamble(
        author = "Brian Lusina",
        date = "",
        currentRevision = 1,
        lastModified = "",
        lastModifiedBy = "Brian Lusina",
        reviewers = {"Brian Lusina"}
)
public class FancyClass {


    @MethodPreamble(
            description = "Some fancy method",
            returnVar = "String"
    )
    public String fancyMethod(){
        return "Hello";
    }

    public void clean(){}
}

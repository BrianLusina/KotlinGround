package com.javapp.annotations;

@ClassPreamble(
    author = "Brian Lusina",
    date = "",
    lastModified = "",
    lastModifiedBy = "Brian Lusina",
    briefDescription = "Demonstration of usage of annotations",
    reviewers = {"Brian Lusina"}
)
public class FancyClass {

  @MethodPreamble(
      description = "Some fancy method",
      returnVar = "String"
  )
  public String fancyMethod() {
    return "Hello";
  }

  public void clean() {
  }
}

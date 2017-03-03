# Enum Types

An enum type is a special data type that enables for a variable to be a set of predefined constants.
The variable must be equal to one of the values that have been predefined for it.
Common examples include compass directions (values of NORTH, SOUTH, EAST, and WEST) and the days of the week.

Because they are constants, the names of an enum type's fields are in uppercase letters.

This package is simply a show for what enums are and how they can be used in Java.

## Usage

You should use enum types any time you need to represent a fixed set of constants.
That includes natural enum types such as the planets in our solar system and data sets where you know
all possible values at compile time—for example, the choices on a menu, command line flags, and so on.

Java programming language enum types are much more powerful than their counterparts in other languages.
The enum declaration defines a class (called an `enum` type).
The enum class body can include methods and other fields.
The compiler automatically adds some special methods when it creates an enum.

For example, they have a static values method that returns an array containing all of the values of the enum
in the order they are declared. This method is commonly used in combination with the `for-each` construct to
iterate over the values of an enum type.

For example, this code from the Planet class example below iterates over all the planets in the solar system.

``` java
for (Planet p : Planet.values()) {
    System.out.printf("Your weight on %s is %f%n",
                      p, p.surfaceWeight(mass));
}
```

> All enums implicitly extend `java.lang.Enum`. Because a class can only extend one parent the Java language
> does not support multiple inheritance of state therefore an enum cannot extend anything else.


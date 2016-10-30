package Groovy;

class Example {
    static void main(String[] args) {
        // Using a simple println statement to print output to the console
        println 'Hello World'
        // defining variables
        def x = 42
        println x.getClass()

        // change the variable type
        x = "Hello"
        println x.getClass()
        
    }
}
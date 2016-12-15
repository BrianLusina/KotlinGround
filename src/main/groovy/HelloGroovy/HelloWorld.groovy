// This is a skeleton file for the Groovy "Hello World" exercise.

class HelloWorld {

    static hello(name) {
        if(name == "" || name == null){
            return "Hello, World!"
        }else{
            return "Hello, $name!"
        }
    }

}

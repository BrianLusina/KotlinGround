public class HelloWorld {
  public static String hello(String name){
    if(name.isEmpty() || name.equals("")){
      return "Hello, World!";
    }else{
      return "Hello, " + name + "!";
    }
  }
}

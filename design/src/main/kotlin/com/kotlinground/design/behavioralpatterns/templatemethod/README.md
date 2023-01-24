# Template Method

Template Method is a behavioral design pattern that allows you to defines a skeleton of an algorithm in a base class and
let subclasses override the steps without changing the overall algorithm’s structure.

Usage examples: The Template Method pattern is quite common in Java frameworks. Developers often use it to provide
framework users with a simple means of extending standard functionality using inheritance.

Here are some examples of Template Methods in core Java libraries:

- All non-abstract methods of java.io.InputStream, java.io.OutputStream, java.io.Reader and java.io.Writer.

- All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and java.util.AbstractMap.

- In javax.servlet.http.HttpServlet class, all the doXXX() methods send the HTTP 405 “Method Not Allowed” error by
  default. However, you can override any of those methods to send a different response.

Identification: Template Method can be recognized if you see a method in base class that calls a bunch of other methods
that are either abstract or empty.
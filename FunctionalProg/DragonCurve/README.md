With the release of Java 8, Java has finally added support for "lambda functions", that is, variables that contain a function which can operate on data just as class methods can (well, not just as class methods can...)

Let's learn about lambdas. This is part 4 in a series.

Part 1: http://www.codewars.com/kata/java-functional-programming-part-1-the-beginning/java
Part 2: http://www.codewars.com/kata/java-functional-programming-part-2-multiline-functions
Part 3: http://www.codewars.com/kata/java-functional-programming-part-3-closured-for-business
With some experience with Java closures, let's start doing something useful. Namely, streaming.

What's a stream?

In Java, at a basic level, a stream is a sequence of objects that you perform a chain of functions upon. Streams are most recognizable when map, reduce, and filter functions are used on Collection streams, though there are many operations one can execute over a stream.

How do streams work?

int sum = widgets.stream()
                 .filter(b -> b.getColor() == RED)
                 .mapToInt(b -> b.getWeight())
                 .sum();
Any Collection (such as widgets) can be turned into a stream (or a parallel stream with parallelStream()). Then, you chain functions onto the stream: filter, mapToInt, sum. So, this stream is calculating the sum of all the weights of the red widgets.

We're going to be calculating the Dragon's Curve (and a few metrics about it) using Java streams. (Pre-existing kata: http://www.codewars.com/kata/dragons-curve).

The Dragon's Curve is a fractal, the path of which can be easily determined programmatically.

Start with the string "Fa"
Replace all "a" with "aRbFR" and all "b" with "LFaLb"
That is (spaces added for clarity):

Iteration 0: Fa
Iteration 1: Fa -> F aRbFR
Iteration 2: FaRbFR -> F aRbFR R LFaLb FR
You will do this "n" times. Then, remove all "a" and "b". The remaining string will contain only FRL (the commands go Forward, turn Right, and turn Left). On a grid, tracing the series of commands results in the Dragon's Curve.

You will create a series of streams that create the Dragon's Curve, then analyze the Dragon's Curve.

First, you'll want to create a mapping IntFunction to turn 'a' and 'b' into "aRbFR" and "LFaLb". The tests count how many times the mapFunction is used during createCurve, so make sure to actually use your mapFunction and don't just implement a different solution (that's why mapFunction is public; don't make it private).

You'll also want to create a filterFactory method to generate IntPredicate functions. The factory will accept a char (to filter) and a boolean (whether we are keeping that char or excluding that char) and return an IntPredicate that filters appropriately.

Finally, you need a howMany function that takes a char and a Dragon's Curve String and returns how many instances of char are in the curve (hint: use the filterFactory you just made).

IntFunction/IntPredicate? I'm working with Strings and Characters!

Funny thing about Java: all Strings are CharSequences (close cousin to char[]). And all chars are ints (don't believe me? 'a' == 97. Try it out.) So, when Oracle was deciding what special functions to include by default in Java 8, instead of adding char-specific functions--like they did for the other primitives--they assume you'll be using the int-specific functions.

What you do is use the String function chars() (e.g., "Fa".chars()) to generate an IntStream. You can then use this IntStream like you would any other, and map, filter, and collect to your heart's content. But, since you're playing with ints, you do need to make sure you're converting your ints back to chars when needed ('a' == 97 might be true, but "" + 97 is still "97" and not "a").

There are some streams in the Example Test Cases, but not quite in the way you'll be using them.

Java streams: http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html

Java functions: http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

You'll pobably want to reference the IntStream in particular: http://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html

Collectors are also quite useful (stream.collect()):

http://docs.oracle.com/javase/8/docs/api/java/util/stream/Collector.html
http://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html

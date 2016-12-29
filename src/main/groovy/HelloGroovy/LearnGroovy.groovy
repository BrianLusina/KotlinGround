package HelloGroovy

/**
 * HelloGroovy
 * Created by lusinabrian on 29/12/16.
 * Description: A quick fire course in Groovy
 */
class LearnGroovy {
    static void main(String[] args){
        // single line comment
        /*
        * Multi line comments*/
        // printing
        println "Hello Groovy"

        // assigning variables
        def x = 1
        println x

        x = new Date()
        println "Date object $x"

        /*Collections, maps*/
        // empty list
        def technologies = []

        // adding elements
        technologies.add("Java")

        // left shift adds and returns the list
        technologies << "Groovy"

        // add multiple elements
        technologies.addAll(["Gradle", "Spring"])

        /**Removing elements*/
        technologies.remove("Gradle")

        //subtraction works
        technologies -= "Spring"

        println "Technologies: $technologies"

        /**Iteration*/
        technologies.each {println "Technology: $it"}
        technologies.eachWithIndex{ it, i -> println "$i: $it"}

        // checking list contents

        //evaluate it a list contains an item
        def hasGriffon = technologies.contains("Griffon")
        //or
        def hasSpring = "Spring" in technologies

        println "Has spring?> $hasSpring, Griffon?> $hasGriffon"

        // Check for multiple contents
        technologies.containsAll(["Spring", "Griffon"])

        /**Sorting lists*/
        // mutates original list
        technologies.sort()

        //sort without mutating original
        def sortedTech = technologies.sort(false)

        /**Manipulating lists*/

        // replace all elements in the list
        Collections.replaceAll(technologies, "Gradle", "Android")

        // shuffle
        Collections.shuffle(technologies, new Random())

        // clear list
        technologies.clear()

        
    }
}

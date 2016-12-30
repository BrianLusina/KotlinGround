package HelloGroovy

import groovy.transform.TypeChecked

/**
 * HelloGroovy
 * Created by lusinabrian on 30/12/16.
 * Description:
 TypeChecked and CompileStatic
 Groovy, by nature, is and will always be a dynamic language but it supports
 typechecked and compilestatic
 More info: http://www.infoq.com/articles/new-groovy-20
 * */
class TypeCheck {
    static void main(String[] args){
        test()
    }

    static void testMethod() {}

    @TypeChecked
    static void test() {
        testMethod()

        def name = "Roberto"
        println name
    }
}

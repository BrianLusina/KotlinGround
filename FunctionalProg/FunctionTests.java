/**
 * Created by lusinabrian on 10/06/16.
 * Tests Functions
 */
public class FunctionTests {
    private static FunctionTests ourInstance = new FunctionTests();

    public static FunctionTests getInstance() {
        return ourInstance;
    }

    private FunctionTests() {

    }

    /**OVERLOADING Tests*/

    public boolean Test(Object obj1,Object obj2){
        return obj1 == obj2;
    }

    public boolean Test(String string1,String string2){
        return string1.equals(string2);
    }

    public boolean Test(float float1,int float2){
        return float1 == float2;
    }

    public boolean Test(double double1,double double2){
        return double1 == double2;
    }

    public boolean Test(long long1,long long2){
        return long1 == long2;
    }

    public boolean Test(int int1,int int2){
        return int1 == int2;
    }


}

import java.util.Arrays;

/**
 * Package: PACKAGE_NAME
 * Created by lusinabrian on 24/07/16 or 24 Jul of 2016,
 * Time: 22:08.
 * Project: binary
 * Description:
 */
public class Binary {
    /*FIELDS*/
    private String binaryString;

    /*CONSTRUCTOR*/
    public Binary(String binaryString){
        this.binaryString = binaryString;
    }

    public int getDecimal(){
        int result = 0;
        int len = getBinaryString().length();
        for(String s: getBinaryString().split("")){
            result += Integer.parseInt(s) * Math.pow(2, len-1);
            len -= 1;
        }
        return result;
    }

    /*GETTERS AND SETTERS*/
    public String getBinaryString() {
        return binaryString;
    }

    public void setBinaryString(String binaryString) {
        this.binaryString = binaryString;
    }
/*CLASS END*/
}

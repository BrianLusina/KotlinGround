package main.java.binary;

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

package CryptoSquare.src.main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lusinabrian on 12/08/16 or 12 Aug of 2016,
 * Time: 18:31.
 * Project: CryptoSquare
 * Description: Remove the spaces and punctuation marks, and lower the case
 */
public class Crypto {
    /*fields*/
    private String plain;

    /*constructor*/
    public Crypto(String plain){
        this.plain = plain;
    }


    /*normalize the string and remove the punctuations*/
    public  String getNormalizedPlaintext(){
        String out = "";
        for(char c : getPlain().toCharArray()){
            if(Character.isLetterOrDigit(c)){
                out += c;
            }
        }
        return out.toLowerCase();
    }

    public int getSquareSize(){
        return (int) Math.ceil(Math.sqrt(getNormalizedPlaintext().length()));
    }

    public List<String> getPlaintextSegments(){
        List<String> outList = new ArrayList<String>();
        int indx = 0;

        while(indx < getNormalizedPlaintext().length()){
            outList.add(
                    (indx + getSquareSize() < getNormalizedPlaintext().length())
                    ? getNormalizedPlaintext().substring(indx, indx + getSquareSize())
                            :getNormalizedPlaintext().substring(indx));
            indx += getSquareSize();
        }
        return outList;

    }

    public String getCipherText(){
        return getNormalizedCipherText().replaceAll("\\s", "");
    }

    public String getNormalizedCipherText(){
        StringBuilder sb = new StringBuilder(getNormalizedPlaintext().length());

        for(int indx = 0; indx < getSquareSize(); indx++){
            for(String segment : getPlaintextSegments()){
                if(indx < segment.length()){
                    sb.append(segment.charAt(indx));
                }
            }

            if(indx < getSquareSize() - 1){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    /*getters and setters*/
    public String getPlain() {
        return plain;
    }

/*CLASS END*/
}
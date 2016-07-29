package ControlFlow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by lusinabrian on 08/07/16.
 * Class demonstrating the use of if statements
 */
public class ifstatements {
    public static void main(String[] args){
        System.out.println(reportCard(75));
    }

//Write a program that assigns a grade based on the value of a mean score: E.g: an A for a score of 90% or above, a B for a score of 80% or above,
    public static String reportCard(float score){
        String grade;

        HashMap<String,List<Float>> hashMap = new HashMap<>();
        ArrayList<Float> scoreList = new ArrayList<>();

        hashMap.put("A", scoreList);
        hashMap.put("B+", scoreList);
        hashMap.put("B", scoreList);
        hashMap.put("B-", scoreList);
        hashMap.put("C+", scoreList);
        hashMap.put("C", scoreList);
        hashMap.put("C-", scoreList);
        hashMap.put("D+", scoreList);
        hashMap.put("D", scoreList);
        hashMap.put("D-", scoreList);
        hashMap.put("E", scoreList);
        hashMap.put("F", scoreList);

        /*evaluate for A*/
        for(float n: IntStream.rangeClosed(90, 100).toArray()){
            scoreList.add(n);
        }
        if(score >= 90){
            grade = "A";
            return grade;
        }else if(score >= 80 || score <= 89){
            grade = "B";
            return grade;
        }else if(score >= 70 || score <= 79){
            grade = "C";
            return grade;
        }else if(score >= 60 || score <= 69){
            grade = "D";
            return grade;
        }else if(score >= 50 || score <= 59){
            grade = "E";
            return grade;
        }else {
            grade = "F";
            return grade;
        }
    }
}

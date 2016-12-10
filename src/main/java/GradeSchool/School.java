package main.java.GradeSchool;

import java.util.*;

public class School {

    public HashMap<Integer, List<String>> database = new HashMap<Integer, List<String>>();
    public List<String> emptyDatabase = new ArrayList<String>();

    /*Database*/
    public HashMap<Integer, List<String>> db() {
        return database;
    }

    /*add students to the db*/
    public HashMap<Integer, List<String>> add(String name, int grade) {
        List<String> studentList = new ArrayList<String>();
        /*check if the db has the grade*/

        if (database.containsKey(grade)) {
            /*if it does, get the list and add the name*/
            db().get(grade).add(name);
        } else {
            studentList.add(name);
            database.put(grade, studentList);
        }
        return db();
    }

    /*get students in a grade*/
    public List<String> grade(int gr) {
        return db().containsKey(gr) ? db().get(gr) : emptyDatabase;
    }

    /*sort the students*/
    public Map<Integer, List<String>> sort() {
        /*for each key in the keySet*/
        for (Integer g : db().keySet()) {
            Collections.sort(db().get(g));
        }
        return db();
    }
/*CLASS END*/
}

package allergies.src.main.java;

import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Package: PACKAGE_NAME
 * Created by lusinabrian on 04/08/16 or 04 Aug of 2016,
 * Time: 19:40.
 * Project: allergies
 * Description:
 */
public class Allergies {
    int score;
    public Allergies(int score){
        this.score = score;
    }

    public boolean isAllergicTo(Allergen allergen){
        return (allergen.getScore() & score) == allergen.getScore();
    }/*method end*/

    public List<Allergen> getList(){
        return EnumSet.allOf(Allergen.class).stream().filter(this::isAllergicTo).collect(Collectors.toList());
    }/*method end*/
/*CLASS END*/
}

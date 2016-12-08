package main.java.Math.PopulationGrowth;

/**
 * Package: Math.PopulationGrowth
 * Created by lusinabrian on 12/08/16 or 12 Aug of 2016,
 * Time: 06:02.
 * Project: JxProjects
 */
public class PopulationGrowth {

    public int nbYear(int p0, double percent, int aug, int p) {
        int n = 0;
        while(p0 < p){
            p0 += p0 * (percent/100) + aug;
            n++;
        }
        return n;
    }
/*class end*/
}

package main.java.Spaceage;

/**
 * Created by lusinabrian on 11/07/16.
 * Earth: orbital period 365.25 Earth days, or 31557600 seconds
 * Mercury: orbital period 0.2408467 Earth years
 * Venus: orbital period 0.61519726 Earth years
 * Mars: orbital period 1.8808158 Earth years
 * Jupiter: orbital period 11.862615 Earth years
 * Saturn: orbital period 29.447498 Earth years
 * Uranus: orbital period 84.016846 Earth years
 * Neptune: orbital period 164.79132 Earth years
 */
public class SpaceAge {

    public static final float earthYrsSec = 31557600L;
    public static final float mercuryYrsSec = (float) (earthYrsSec * 0.2408467);
    public static final float venusYrsSec = (float) (earthYrsSec * 0.61519726);
    public static final float marsYrsSec = (float) (earthYrsSec * 1.8808158);
    public static final float jupiterYrsSec = (float) (earthYrsSec * 11.862615);
    public static final float saturnYrsSec = (float) (earthYrsSec * 29.447498);
    public static final float uranusYrsSec = (float) (earthYrsSec * 84.016846);
    public static final float neptuneYrsSec = (float) (earthYrsSec * 164.79132);

    /*field*/
    private float age;

    /*constructor*/
    public SpaceAge(float age) {
        this.age = age;
    }

    /*setters and getters*/
    public float getSeconds() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    /*years on earth*/
    public float onEarth() {
        return getSeconds() / (float) earthYrsSec;
    }

    /*years on mercury*/
    public float onMercury() {
        return getSeconds() / mercuryYrsSec;
    }

    /*years on venus*/
    public float onVenus() {
        return getSeconds() / venusYrsSec;
    }

    /*years on mars*/
    public float onMars() {
        return getSeconds() / marsYrsSec;
    }

    /*on Jupiter*/
    public float onJupiter() {
        return getSeconds() / jupiterYrsSec;
    }

    /*on Saturn*/
    public float onSaturn() {
        return getSeconds() / saturnYrsSec;
    }

    /*on Uranus*/
    public float onUranus() {
        return getSeconds() / uranusYrsSec;
    }

    /*on Neputune*/
    public float onNeptune() {
        return getSeconds() / neptuneYrsSec;
    }
}/*CLASS END*/

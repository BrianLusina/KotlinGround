package com.javapp.datetime.gigasecond;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    //A java.javapp.gigasecond is one billion (10**9) seconds.
    public static final Long GIGASECOND = BigInteger.valueOf(10).pow(9).longValue();
    private LocalDateTime localDate;

    /*constructor*/
    public Gigasecond(LocalDate localDate) {
        this(localDate.atStartOfDay());
    }

    /*constructor*/
    public Gigasecond(LocalDateTime localDate) {
        this.localDate = localDate;
    }

    public LocalDateTime getDate() {
        return localDate.plusSeconds(GIGASECOND);
    }
/*CLASS END*/
}

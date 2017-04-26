package com.javapp.cryptography.SecretHandshake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandshakeCalculator {

    private static final int REVERSE_SIGNAL_BIT_POSITION = 4;

    List<Signal> calculateHandshake(final int number){
        final List<Signal> result = new ArrayList<>();
        for(Signal signal: Signal.values()){
            if( isBitSet(signal.ordinal(), number)){
                result.add(signal);
            }
        }

        if(isBitSet(REVERSE_SIGNAL_BIT_POSITION, number)){
            Collections.reverse(result);
        }

        return result;
    }

    private boolean isBitSet(final int position, int number){
        return ((number >> position) & 1) == 1;
    }
}

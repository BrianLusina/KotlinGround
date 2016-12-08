package main.java.NucleotideCount;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DNA {
    //field
    public String dnaStrand;

    /**constructor*/
    public DNA(String dnaStrand){
        this.dnaStrand = dnaStrand;
    }

    /**counts how many nucleotides are in the dna strand*/
    public int count(char nucleotide){
        if("AGCT".indexOf(nucleotide) > -1){
                return (int) dnaStrand.chars().filter(nuc -> nuc == nucleotide).count();
            }else
                throw new IllegalArgumentException("Invalid nucleotides");
    }

    /**count how many of each nucleotide is in the dna strand*/
    public Map<Character, Integer> nucleotideCounts(){
     return Stream.of('A','C','G','T').map(c -> new AbstractMap.SimpleImmutableEntry<>(c, count(c)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

/*END*/
}
import java.util.stream.Collectors;

public class RnaTranscriptionV2 {

    public static String ofDna(String dna){
        return dna.chars().mapToObj(x -> (char) x).map(RnaTranscriptionV2::transcribe).map(String::valueOf).collect(Collectors.joining());
    }

    public static char transcribe(char nucleotide){
        switch (nucleotide) {
            case 'G' : return 'C';
            case 'C' : return 'G';
            case 'T' : return 'A';
            case 'A' : return 'U';
            default: throw new IllegalArgumentException("Must Be G C T or A");
        }
    }
}

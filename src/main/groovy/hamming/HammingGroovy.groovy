package hamming

class HammingGroovy {
    static compute(String strand1, String strand2){
        int count = 0
        String dna1 = strand1.split("")
        String dna2 = strand2.split("")
        if(dna1.length() != dna2.length()){
            throw new IllegalArgumentException(dna1 +" and " +dna2 + " are different lengths")
        }else{
            for(int x = 0; x < dna1.length(); x++){
                if(dna1[x] != dna2[x]){
                    count+=1
                }
            }
        }
        return count
    }
}

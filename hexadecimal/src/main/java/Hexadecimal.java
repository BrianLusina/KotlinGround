import java.util.Arrays;

public class Hexadecimal {
    private static final String HEX = "0123456789abcdef";
    public static int toDecimal(String hexa){
        boolean is_hex = hexa.matches("^[0-9a-f]+");
        return (!is_hex) ? 0 : Arrays.stream(hexa.split("")).map(HEX::indexOf)
                .reduce(0, (dec, hex) -> dec * 16 + hex);
    }
}

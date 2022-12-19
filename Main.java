public class Main {
    public static void main(String[] args) {
        CaeserCipher cipher3 = new CaeserCipher(3);
        System.out.println(cipher3.Encode("hello world"));
    }
}

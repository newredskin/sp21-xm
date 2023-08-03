package flik;

public class FilkTest {

    public static void main(String[] args) {
        int i = 128;
        int j = 128;

        boolean filkResult = Flik.isSameNumber(i, j);

        System.out.println(filkResult);
        System.out.println(i == j);

    }
}

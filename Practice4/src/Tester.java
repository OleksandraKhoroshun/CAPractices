import java.io.IOException;

public class Tester {

    private static String str = new String();

    public static void main(String[] args) throws IOException {
        System.out.println("Введіть стрічку: ");
        str = DataInput.getString();
        Cipher.setString(str);
        while (!str.equals("-1")) {

            System.out.println("1 - шифрувати, 2 - дешифрувати, -1 - вийти: ");
            int i = DataInput.getInt();

            while (i != -1) {

                switch (i) {
                    case 1:
                        System.out.println("Введіть число,на яке будемо шифрувати:  ");
                        int s = DataInput.getInt();
                        Cipher.cipher(s);
                        str = Cipher.getString();
                        System.out.println(str);
                        break;
                    case 2:
                        System.out.println("Введіть число,на яке будемо дешифрувати:  ");
                        int s1 = DataInput.getInt();
                        Cipher.decipher(s1);
                        str = Cipher.getString();
                        System.out.println(str);
                        break;
                    default:
                        System.out.println("?");

                }
                System.out.println("1 - шифрувати, 2 - дешифрувати, -1 - вийти: ");
                i = DataInput.getInt();
            }
            System.out.println("Введіть стрічку: ");
            str = DataInput.getString();
            Cipher.setString(str);
        }

    }
}
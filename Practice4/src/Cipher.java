public class Cipher {

    private static String str=new String();

   public static String encrypt(String msg, int shift){
        String s = "";
        int len = msg.length();
        for(int x = 0; x < len; x++){
            char c = (char)(msg.charAt(x) + shift);
            if(isLatinLetter(c)) {
                if (c > 'z')
                    s += (char) (msg.charAt(x) - (26 - shift));
                else
                    s += (char) (msg.charAt(x) + shift);
            }
            else {
                if (c > 'я')
                    s += (char) (msg.charAt(x) - (33 - shift));
                else
                    s += (char) (msg.charAt(x) + shift);
            }
        }
        return s;
    }
    public static String decrypt(String msg, int shift){
        String s = "";
        int len = msg.length();
        for(int x = 0; x < len; x++){
            char c = (char)(msg.charAt(x) + shift);
            if(isLatinLetter(c)) {
                if (c > 'z')
                    s += (char) (msg.charAt(x) + (26 - shift));
                else
                    s += (char) (msg.charAt(x) - shift);
            }
            else {
                if (c > 'я')
                    s += (char) (msg.charAt(x) + (33 - shift));
                else
                    s += (char) (msg.charAt(x) - shift);
            }
        }
        return s;
    }
    public static String getString(){
        return str;
    }
    public static void setString(String st){
        str = st;
    }
    public static void cipher(int s){
        str = encrypt(str,s).toString();
    }
    public static void decipher(int s){
        str = decrypt(str,s).toString();
    }
    public static boolean isLatinLetter(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
            return true;
        else
        return false;
    }

}

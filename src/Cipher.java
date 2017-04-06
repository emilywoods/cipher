public class Cipher {

    private String encryptText(String keyStr, String plainText) {
        int key = Integer.parseInt(keyStr);

        String encryptedString = "";
        for (int i = 0; i <  plainText.length(); i++) {
            char c = plainText.charAt(i);
            char encryptedChar = encrypt(c,key);
            encryptedString += encryptedChar;
        }
        return encryptedString;
    }

    private char encrypt(char c, int key) {
        if (!Character.isAlphabetic(c)){
            return c;
        }
        return (char) (c + key);
    }


    public static void main (String[] args) {
        Cipher cipher = new Cipher();
        System.out.println("Enter an encryption key:");
        String keyStr = System.console().readLine();
        System.out.println("Enter text to encrypt:");
        String plainText = System.console().readLine();
        String encryptedText = cipher.encryptText(keyStr, plainText);
        System.out.println("Encrypted text:" + encryptedText);

    }
}

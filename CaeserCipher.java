public class CaeserCipher implements ICipher{

    private int history;
    private int limitIndex;
    private String[] letters;

    public CaeserCipher(int history){
        this.history = history;
        letters = FillLetters();
        limitIndex = letters.length - history;
    }



    @Override
    public String Encode(String message) {

        String encoded = "";

        for (int i = 0; i < message.length(); i++) {
            encoded += EncodeLetter(message.substring(i, i + 1));
        }
        return encoded;
    }

    private String EncodeLetter(String letter){

        int index = -1;
        int loc = 0;
        while (loc < letters.length && index == -1) {
            if(letters[loc].equals(letter)){
                index = loc;
            }

            loc++;
        }

        if (index == -1) {
            return " ";
        } else {
            return letters[TranslateIndex(index)];
        }
    }

    private int TranslateIndex(int index){

        if(index >= limitIndex){
            index = index - limitIndex;
        } else {
            index = index + history;
        }

        return index;
    }


    private String[] FillLetters(){
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String[] letters = new String[26];
        for (int i = 0; i < abc.length(); i++) {
            letters[i] = abc.substring(i, i + 1);
        }

        return letters;
    }
}

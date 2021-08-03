package task1SimplifyEnglish;

public class SimplifyingEnglishText {

    /**
     * Executes all simplifying methods of this class: simplifies the letter "c", removes double letters, removes "e" in
     * the end of the words and removes articles from the given text in English.
     *
     * @param text text to simplify
     * @return simplified text
     */
    public String simplify(String text) {
        return removeLastE(removeDoubleChar(removeCLetter(removeArticle(text))));
    }

    /**
     * Simplifies the letter "c" in the text: replaces "ce" and "ci" by "se" and "si", changes "ck" to "k" and changes
     * "c" to "k" in other cases.
     *
     * @param text given text to simplify
     * @return text with simplified "c" letter
     */
    public String removeCLetter(String text) {
        char[] textChars = text.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < textChars.length; i++) {
            if (textChars[i] == 'c') {
                if (i == textChars.length - 1) {
                    str.append("k");
                } else if (textChars[i + 1] == 'e' || textChars[i + 1] == 'i') {
                    str.append("s");
                } else if (textChars[i + 1] != 'k') {
                    str.append("k");
                }
            } else {
                str.append(textChars[i]);
            }
        }
        return str.toString();
    }

    /**
     * Simplifies double letters in the text: replaces "ee" by simple "i", replaces "oo" by "u", replaces any other
     * double letter by one letter in other cases.
     *
     * @param text given text to simplify
     * @return text with simplified double letters
     */
    public String removeDoubleChar(String text) {
        String withoutEE = text.replaceAll("(?ui)e{2}", "i");
        String withoutEEOO = withoutEE.replaceAll("(?ui)o{2}", "u");
        return withoutEEOO.replaceAll("(.)\\1", "$1");
    }

    /**
     * Removes "e" letter at the end of each word in given text, if the word length > 1.
     * Case insensitive.
     * @param text given text to simplify
     * @return text without "e" at the end of each word
     */
    public String removeLastE(String text) {
        return text.replaceAll("\\B(?ui)e\\b", "");
    }

    /**
     * Removes articles (a, an, the) from given text (String), strictly taking into account the beginning and the end of
     * the word. So, after executing the method on "the theory" the result is "theory".
     * Case insensitive.
     * @param text a text, where search is executed
     * @return text without the given word
     */
    public String removeArticle(String text) {
        return text.replaceAll("\\b(?ui)(the|a|an)\\b ", "");
    }
}


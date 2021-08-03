package task1;

public class SimplifyingEnglishText {

    /**
     * Executes all simplifying methods of this class: simplifies the letter "c", removes double letters, removes "e" in
     * the end of the words and removes articles from the given text in English.
     *
     * @param text text to simplify
     * @return simplified text
     */
    public String simplify(String text) {
        text = removeArticle(text);
        text = removeC(text);
        text = removeDoubleChar(text);
        text = removeLastE(text);
        return text;
    }

    /**
     * Simplifies the letter "c" in the text: replaces "ce" and "ci" by "se" and "si", changes "ck" to "k" and changes
     * "c" to "k" in other cases.
     *
     * @param text given text to simplify
     * @return text with simplified "c" letter
     */
    public String removeC(String text) {
        text = text.replaceAll("ce", "se");
        text = text.replaceAll("ci", "si");
        text = text.replaceAll("ck", "k");
        text = text.replaceAll("c", "k");
        return text;
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
     *
     * @param text given text to simplify
     * @return text without "e" at the end of each word
     */
    public String removeLastE(String text) {
        return text.replaceAll("\\B(?ui)e\\b", "");
    }

    /**
     * Removes articles (a, an, the) from given text (String) in English, strictly taking into account the beginning and the end of
     * the word. So, after executing the method on "the theory" the result is "theory".
     * Case insensitive.
     *
     * @param text a text, where search is executed
     * @return text without the given word
     */
    public String removeArticle(String text) {
        return text.replaceAll("\\b(?ui)(the|a|an)\\b ", "");
    }
}


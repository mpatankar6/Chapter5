package FRQ;

public class Sentence {

    private String currSent;

    /** Constructs a new Sentence object. */
    public Sentence(String p) {
        currSent = p;
    }

    /** Returns a string containing the current sentence. */
    public String toString() {
        return currSent;
    }

    /** Returns the index of the nth occurrence of str in the current sencence;
     * returns -1 of the nth occurrence does not exist.
     * Precondition:  str.length() > 0 and n > 0
     * Postcondition: the current sentence if not modified.
     */
    public int findNthTime(String str, int n) {
        int newIndex = 0;
        for (int i = 0; i < n; i++) {
            if (currSent.contains(" ")) {
                if (newIndex != -1) {
                    newIndex = currSent.indexOf(str, newIndex + (str.length() - 1));
                } else {
                    return -1;
                }
            } else {
                if (newIndex != -1) {
                    newIndex = currSent.indexOf(str, newIndex + i * (str.length()));
                } else {
                    return -1;
                }
            }
        }
        return newIndex;
    }

    /** Modifies the current sentence by replacing the nth occurrence of str with repl
     * If the nth occurrence does not exist, the current sentence is unchanged.
     * Precondition: str.length() > 0 and n > 0
     *
     */
    public void replaceNthTime(String str, int n, String repl) {
        int index = findNthTime(str, n);
        if (index != -1) {
            currSent = (currSent.substring(0, index)) + (currSent.substring(index, index + str.length()).replace(str, repl)) + (currSent.substring(index + str.length()));
        }

    }

    /** Returns the index of the last occurrence of str in the current sentence:
     * returns -1 if str is not found.
     * Precondition:  str.length() > 0
     * Postcondition: the current sentence is not modified.
     */
    public int findLastTime(String str) {
        int i = 1;
        if(findNthTime(str, i) != -1) {
            while(findNthTime(str, i) != -1){
                i++;
            }
            return findNthTime(str, i - 1);

        }
        return -1;
    }

    public static void main(String[] args) {
        Sentence sentence1 = new Sentence("A cat ate late.");
        System.out.println(sentence1.findNthTime("at",1));
        sentence1.replaceNthTime("at", 1, "rane");
        System.out.println(sentence1);

        Sentence sentence2 = new Sentence("A cat ate late.");
        System.out.println(sentence2.findNthTime("at",6));
        sentence2.replaceNthTime("at", 6, "xx");
        System.out.println(sentence2);

        Sentence sentence7 = new Sentence("A cat ate late.");
        System.out.println(sentence7.findNthTime("at",3));
        sentence7.replaceNthTime("at", 3, "xx");
        System.out.println(sentence7);

        Sentence sentence3 = new Sentence("A cat ate late.");
        System.out.println(sentence3.findNthTime("bat",2));
        sentence3.replaceNthTime("bat", 2, "xx");
        System.out.println(sentence3);

        Sentence sentence4 = new Sentence("aaaa");
        sentence4.replaceNthTime("aa", 1, "xx");
        System.out.println(sentence4);

        Sentence sentence5 = new Sentence("aaaa");
        sentence5.replaceNthTime("aaa", 2, "bbb");
        System.out.println(sentence5);

        Sentence sentence6 = new Sentence("A cat ate late.");
        System.out.println(sentence6.findLastTime("at"));
        System.out.println(sentence6.findLastTime("cat"));
        System.out.println(sentence6.findLastTime("bat"));
    }

}

/*
3
A crane ate late.
-1
A cat ate late.
11
A cat ate lxxe.
-1
A cat ate late.
xxaa
aaaa
11
2
-1
 */
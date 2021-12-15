public class Main {

    private static String scroll(String str) {
        return str.substring(1) + str.charAt(0);
    }

    private static String convertName(String name) {
        int index = name.indexOf(",");
        return name.substring(index+1).trim() + " " + name.substring(0, index).trim();
    }

    private static String negative(String str) {
        return str.replaceAll("0", "A").replaceAll("1","0").replaceAll("A", "1");
    }

    private static String convertDate(String origDate) {
        String newDate = "";
        int firstSlash = origDate.indexOf("/");
        int lastSlash = origDate.lastIndexOf("/");

        newDate += origDate.substring(firstSlash + 1, firstSlash + 3); //day
        newDate += "-";
        newDate += origDate.substring(0, 2); //month
        newDate += "-";
        newDate += origDate.substring(lastSlash + 1, lastSlash + 5); //year
        return newDate;
    }

    private static String convertDate2(String origDate) {
        String newDate = "";
        int firstSlash = origDate.indexOf("/");
        int lastSlash = origDate.lastIndexOf("/");

        newDate += origDate.substring(firstSlash + 1, lastSlash); //day
        newDate += "-";
        newDate += origDate.substring(0, firstSlash); //month
        newDate += "-";
        newDate += origDate.substring(lastSlash + 1); //year
        return newDate;
    }

    private static boolean startsWith(String s, String prefix) {
        if (s.length() >= prefix.length()) {
            if (s.substring(0, prefix.length()).equals(prefix)) {
                return true;
            }
        }
        return false;
    }

    private static boolean endsWith(String s, String suffix) {
        if (s.length() >= suffix.length()) {
            if (s.substring(s.length() - suffix.length()).equals(suffix)) {
                return true;
            }
        }
        return false;
    }

    private static String removeTag(String str, String tag) {
        String tag1 = "<" + tag + ">";
        String tag2 = "</" + tag + ">";
        if (str.contains(tag1) && str.contains(tag2)) {
            int a = str.indexOf(">");
            int b = str.lastIndexOf("<");
            int c = str.indexOf("<");
            int d = str.lastIndexOf(">");
            return str.substring(0, c) + str.substring(a+1, b) + str.substring(d+1);
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(scroll("Hello World"));
        System.out.println(scroll("happy"));
        System.out.println(scroll("h"));

        System.out.println(convertName(" Reubenstein, Lori Renee "));
        System.out.println(convertName("Biden,Joe"));
        System.out.println(convertName("the Clown, Bozo"));

        System.out.println(negative("0010111001"));
        System.out.println(negative("11111111"));

        System.out.println("04/20/2014 becomes " + convertDate("04/20/2014"));

        System.out.println("04/20/2014 becomes " + convertDate2("04/20/2014"));
        System.out.println("4/20/2014 becomes " + convertDate2("4/20/2014"));
        System.out.println("04/2/2014 becomes " + convertDate2("04/2/2014"));
        System.out.println("4/2/2014 becomes " + convertDate2("4/2/2014"));

        System.out.println("\nstartsWith");
        System.out.println(startsWith("architecture", "arch"));
        System.out.println(startsWith("architecture", "a"));
        System.out.println(startsWith("arch", "architecture"));
        System.out.println(startsWith("architecture", "rch"));
        System.out.println(startsWith("architecture", "architecture"));

        System.out.println("\nendsWith");
        System.out.println(endsWith("astronomy", "nomy"));
        System.out.println(endsWith("astronomy", "y"));
        System.out.println(endsWith("astronomy", "nom"));
        System.out.println(endsWith("nomy", "astronomy"));
        System.out.println(endsWith("astronomy", "astronomy"));

        System.out.println("\nremoveTag");
        System.out.println(removeTag("<b>Hello World</b>", "b"));
        System.out.println(removeTag("<b>Hello World</b>", "head"));
        System.out.println(removeTag("Hello World</b>", "b"));
        System.out.println(removeTag("<b>Hello World", "b"));
        System.out.println(removeTag("</img>Hello World<img>", "img"));
        System.out.println(removeTag("Happy Birthday <b>Hello World</b>", "b"));
        System.out.println(removeTag("<title>Hello World</title> Happy Birthday", "title"));
        System.out.println(removeTag("Happy <b>Hello World</b> Birthday", "b"));
    }
}

/** Output
 * ello WorldH
 * appyh
 * h
 * Lori Renee Reubenstein
 * Joe Biden
 * Bozo the Clown
 * 1101000110
 * 00000000
 * 04/20/2014 becomes 20-04-2014
 * 04/20/2014 becomes 20-04-2014
 * 4/20/2014 becomes 20-4-2014
 * 04/2/2014 becomes 2-04-2014
 * 4/2/2014 becomes 2-4-2014
 *
 * startsWith
 * true
 * true
 * false
 * false
 * true
 *
 * endsWith
 * true
 * true
 * false
 * false
 * true
 *
 * removeTag
 * Hello World
 * <b>Hello World</b>
 * Hello World</b>
 * <b>Hello World
 * Hello World
 * Happy Birthday Hello World
 * Hello World Happy Birthday
 * Happy Hello World Birthday
 */
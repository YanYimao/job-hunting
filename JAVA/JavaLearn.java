public class JavaLearn {
    public static void main(String[] args) {
        // String
        String str = "abc";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String[] strArray = str.split("b");
        for (String str2 : strArray) System.out.println(str2);
        Integer i = 10;
        String s = i.toString();
        System.out.println(s);
        char c = 'a';
        System.out.println(Character.isDigit(c)); 
        String str2 = "134";
        System.out.println(Integer.parseInt(str2));
        String str3 = str2.substring(1);
        System.out.println(str3);
    }
}

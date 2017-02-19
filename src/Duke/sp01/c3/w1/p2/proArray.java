package Duke.sp01.c3.w1.p2;

/**
 * Created by a on 1/27/17.
 */
public class proArray {
    public static void main(String[] args) {
        String[] s = new String[12];
        s[3]="hello";
        s[2]=s[3]+4;
        System.out.println(s[2]);
        int lArr=s.length;
        System.out.println(lArr);
        int lStr=s[3].length();
        System.out.println(lStr);
    }
}

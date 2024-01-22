package MyStringBuilderHW;

public class MyStringBuilderTest {
    public static void main(String[] args) {

        //everything works

        // MyStringBuilderHW.MyStringBuilderArray Test
        MyString str = new MyString("hello");
        MyString str2 = new MyString("world");
        MyStringBuilder test = new MyStringBuilderArray(str);
        MyStringBuilder test2 = new MyStringBuilderArray(str2);

        
        System.out.println(test.append(test2));
        System.out.println(test.append(str2));
        System.out.println(test.length());
        System.out.println(test.charAt(3));
        System.out.println(test.delete(1, 3));
        System.out.println(test.reverse());
        test.setCharAt(2, 'f');
        System.out.println(test);

        System.out.println(" ");

        //MyStringBuilderHW.MyStringBuilderList Test
        MyString str3 = new MyString("hello");
        MyString str4 = new MyString("world");
        MyStringBuilder test3 = new MyStringBuilderList(str3);
        MyStringBuilder test4 = new MyStringBuilderList(str4);


        System.out.println(test3.append(test4));
        System.out.println(test3.append(str4));
        System.out.println(test3.length());
        System.out.println(test3.charAt(3));
        System.out.println(test3.reverse());
        test3.setCharAt(2, 'f');
        System.out.println(test3);
        System.out.println(test3.delete(1, 3));

    }
}


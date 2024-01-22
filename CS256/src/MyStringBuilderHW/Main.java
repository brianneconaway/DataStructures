package MyStringBuilderHW;

public class Main {
        public static void main(String[] args) {
            MyString emptyString = new MyString("");
            MyString sluString = new MyString("SLU");
            MyString computerString = new MyString("Computer");

            //System.out.println(sluString.indexof('K')); // using my own indexof because we defined it that way

            System.out.println(emptyString.length());
            System.out.println(sluString.length());
            System.out.println(computerString.length());

        }

    }



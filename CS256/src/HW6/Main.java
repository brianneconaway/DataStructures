package HW6;

public class Main {
    public static void main(String[] args) {
        Directory D = new Directory("D");
        Directory E = new Directory("E");
        Directory F = new Directory("F");
        Directory G = new Directory("G");
        File a = new File("a", "exe", 1);
        File b = new File("b", "exe", 2);
        File c = new File("c", "exe", 3);
        File z = new File("z", "cde", 4);

        D.addDirectory(E);
        D.addDirectory(F);
        F.addDirectory(G);

        E.addFile(a);
        E.addFile(b);
        G.addFile(c);
        F.addFile(z);


        System.out.println(D.size());
        System.out.println(E.size());

        System.out.println(D.countFileType("exe"));
        System.out.println(F.countFileType("exe"));
        System.out.println(D.countFileType("abc"));

        System.out.println(D.findFileByName("b"));
        System.out.println(D.findFileByName("c"));

        System.out.println(E.findLargestFile());


    }
}

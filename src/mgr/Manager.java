package mgr;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager<T extends Manageable> {
    public static Scanner fileIn;
    public ArrayList<T> mList = new ArrayList<>();

    protected Scanner openFile(String filename) {

        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.printf("파일 오픈 실패: %s\n", filename);
            System.exit(0);
        }

        return filein;
    }

    public void readAll(String filename, Factory<T> fac) {

        fileIn = openFile(filename);

        T b = null;
        while (fileIn.hasNext()) {
            b = fac.create();
            b.read(fileIn);
            mList.add(b);
        }
        fileIn.close();
    }

    public void printAll() {
        for (int i = 0; i < mList.size(); i++) {
            System.out.format("\n(%d) ", i + 1);
            mList.get(i).print();
        }
    }

    public void search(String kwd) {
        for (T m : mList) {
            m.matches(kwd);
        }
    }
}

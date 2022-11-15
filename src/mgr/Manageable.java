package mgr;

import java.util.Scanner;

public interface Manageable {
    void read(Scanner scan);

    void print();

    void matches(String kwd);

}
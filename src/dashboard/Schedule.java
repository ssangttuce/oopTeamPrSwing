package dashboard;

import mgr.Manageable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Schedule implements Manageable {
    public String name;
    public HashSet<Task> taskList = new HashSet<>();
    public int schCateNum;//1, 2, 3, 4 중에서만 받아야 함. 1:wtList, 2:to do, 3:inpro, 4:done

    @Override
    public void read(Scanner scan) {
        this.name = scan.nextLine();
        this.schCateNum = scan.nextInt();
        scan.nextLine();
        classify();
    }

    void classify() {
        for (Task t : Dashboard.taskMgr.mList) {
            if (schCateNum == t.progressLvl())
                taskList.add(t);
            else
                taskList.remove(t);
        }
        List<Task> removed = new ArrayList<>();
        for (Task t : taskList) {
            if (!Dashboard.taskMgr.mList.contains(t))
                removed.add(t);
        }
        taskList.removeAll(removed);//taskMgr에 없는 Task를 가진 경우 모두 삭제
    }

    @Override
    public void print() {
        System.out.format("<%s>\n", name);
        System.out.println("-".repeat(80));
        for (Task t : taskList) {
            t.print();
        }
        System.out.println("-".repeat(80));
    }

    @Override
    public void matches(String kwd) {
        System.out.format("<%s>\n", name);
        System.out.println("-".repeat(80));
        for (Task t : taskList) {
            t.matches(kwd);
        }
        System.out.println("-".repeat(80));
    }
}
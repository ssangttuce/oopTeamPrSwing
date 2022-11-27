package dashboard;

import mgr.Factory; 
import mgr.Manager;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JFrame;

import gui_Main.DashboardPanel;


public class Dashboard {
    public static String today;
    Scanner scan;
    static Manager<Task> taskMgr = new Manager<>();
    public static Manager<Schedule> scheduleMgr = new Manager<>();

    String getToday() {
        // 현재 날짜 구하기
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd");
        // 포맷 적용
        return now.format(formatter);
    }

    void run() {
        System.out.format("<오늘 날짜: %s >\n\n", today = getToday());
        taskMgr.readAll("task.txt", new Factory<Task>() {
            @Override
            public Task create() {
                return new Task();
            }
        });
        scheduleMgr.readAll("schedule.txt", new Factory<Schedule>() {
            @Override
            public Schedule create() {
                return new Schedule();
            }
        });
        createAndShowGUI();
        //scheduleMgr.printAll();
        //menu();
    }

    void menu() {
        scan = new Scanner(System.in);
        int menuNum;
        while (true) {
            System.out.format("\n\t0. 종료\n");
            System.out.format("\t1. 전체 출력\n");
            System.out.format("\t2. 일정 검색\n");
            System.out.format("\t3. 일정 수정\n");
            System.out.format("\t4. 일정 추가\n");
            System.out.format("\t5. 일정 삭제\n");
            menuNum = scan.nextInt();
            scan.nextLine();
            if (menuNum == 0)
                break;
            switch (menuNum) {
                case 1 -> scheduleMgr.printAll();
                case 2 -> search();
                case 3 -> modify();
                case 4 -> {
                    scan.nextLine();
                    Task t = new Task();
                    t.read(scan);
                    taskMgr.mList.add(t);
                    classify();
                }
                case 5 -> {
                    taskMgr.printAll();
                    System.out.print("\n삭제할 Task 번호 선택: ");
                    int tskNum = scan.nextInt();
                    scan.nextLine();
                    taskMgr.mList.remove(tskNum - 1);
                    System.out.println("삭제되었습니다.");
                    classify();
                }
            }
        }
    }

    void search() {
        System.out.format("검색 키워드 입력: ");
        String kwd = scan.nextLine();
        System.out.println();
        scheduleMgr.search(kwd.strip());
    }

    void modify() {
        taskMgr.printAll();
        System.out.print("\n수정할 Task 번호 선택: ");
        int tskNum = scan.nextInt();
        scan.nextLine();
        taskMgr.mList.get(tskNum - 1).print();

        System.out.format("\n\t0. 수정 종료\n");
        System.out.format("\t1. 이름 재설정\n");
        System.out.format("\t2. 날짜 변경\n");
        System.out.format("\t3. 태그 변경\n");
        System.out.format("\t4. 내용 변경\n");
        taskMgr.mList.get(tskNum - 1).modify(scan.nextInt(), scan);
        classify();
    }

    void classify() {
        for (Schedule s : Dashboard.scheduleMgr.mList) {
            s.classify();
        }//설계원칙에 따라 리팩토링 필요
    }

    private static void createAndShowGUI() {
    	
        JFrame frame = new JFrame("Dashboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1440, 800));
        frame.setSize(1440, 800);
        frame.setLocationRelativeTo(null);

        DashboardPanel newContentPane = new DashboardPanel();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        Dashboard d = new Dashboard();
        d.run();
    }
}
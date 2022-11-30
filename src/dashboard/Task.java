package dashboard;

import java.awt.*;
import java.util.HashSet;
import java.util.Scanner;

public class Task extends Daily {
    public String start_Date;
    public String end_Date;
    HashSet<String> tag = new HashSet<>();
    int progressPercent = 0;
    String importanceLabel = "보통";
    Color importanceColor = new Color(192, 224, 230);


    @Override
    public void read(Scanner scan) {
        super.read(scan);//name, content input
        setDate(scan);
        while (setTag(scan)) {
        }
        scan.nextLine();
    }

    public void setDate(Scanner scan) {
        System.out.format("시작 날짜 입력: ");
        this.start_Date = scan.next();
        System.out.print("\b".repeat("시작 날짜 입력: ".length()));
        if (start_Date.equals("-"))
            this.end_Date = "-";
        else {
            System.out.format("마감 날짜 입력: ");
            this.end_Date = scan.next();
            System.out.print("\b".repeat("마감 날짜 입력: ".length()));
        }
        scan.nextLine();
    }

    public boolean setTag(Scanner scan) {// #tag는 태그 추가 -tag는 태그 삭제
        System.out.format("\'#태그\'를 입력하세요: ");
        String hashtag = scan.next();
        System.out.print("\b".repeat("\'#태그\'를 입력하세요: ".length()));
        return switch (hashtag.charAt(0)) {
            case '#' -> {
                if (tag.size() > 5) {
                    System.out.println("태그 수가 5개 이상입니다.");
                    yield false;
                }
                tag.add(hashtag);
                yield true;
            }
            case '-' -> {
                tag.remove("#" + hashtag.substring(1));
                yield false;
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + hashtag.charAt(0));
        };
    }

    public void setProgressPercent(int progressPercent) {
        this.progressPercent = progressPercent;
    }

    public void setImportance(String label, Color color) {
        this.importanceLabel = label;
        this.importanceColor = color;
    }

    @Override
    public void print() {
        System.out.format("|");
        System.out.println(getName());
        System.out.format("| ");
        System.out.print(getDate());
        System.out.format("| ");
        System.out.print(getTag());
        System.out.format("| ");
        System.out.print(getContent());
        System.out.println();
    }


    public String getDate() {
        return String.format("%s-%s ", start_Date, end_Date);
        // 출력 자릿수 맞추기
    }

    public String getTag() {
        StringBuilder tagString = new StringBuilder();
        for (String hashtag : tag) {
            if (hashtag == null || hashtag.length() == 0)
                continue;
            tagString.append(hashtag + " ");
        }
        return tagString.toString();
    }

    public int getProgressPercent() {
        return progressPercent;
    }

    public String getImportanceLabel() {
        return this.importanceLabel;
    }

    public Color getImportanceColor() {
        return this.importanceColor;
    }

    public int progressLvl() {
        if (start_Date == null)
            return -1;
        if (start_Date.equals("-"))
            return 1;// waitingList
        if (start_Date.compareTo(Dashboard.today) > 0)
            return 2;//todo
        else {
            if (end_Date.compareTo(Dashboard.today) >= 0)
                return 3;// inProgress
            else
                return 4;// done
        }
    }

    @Override
    public void modify(int menuChk, Scanner scan) {
        scan.nextLine();
        switch (menuChk) {
            case 0 -> System.out.println("종료");
            case 1 -> {
                System.out.print("이름 입력: ");
                setName(scan);
            }
            case 2 -> {
                System.out.println("*날짜 입력 양식");
                System.out.format("*| 시작일: mm.dd 마감일: mm.dd|\n");
                System.out.format(" | 날짜 지정 해제 시 \"-\" 입력  |\n");
                System.out.print("날짜 입력: ");
                setDate(scan);
            }
            case 3 -> {
                System.out.println("*태그 입력 양식");
                System.out.format("*| #'태그' 입력 시 태그 생성    |\n");
                System.out.format(" | -'태그' 입력 시 해당 태그 삭제|\n");
                System.out.print("태그 입력: ");
                setTag(scan);
            }
            case 4 -> {
                System.out.println("\'다시쓰기\' 입력 시 삭제 후 입력");
                System.out.println("그 외 입력 시 덧붙이기");
                System.out.print("내용 입력: ");
                setContent(scan);
            }
        }
    }

    @Override
    public void matches(String kwd) {
        if (this.name.contains(kwd) || matchesTag(kwd) || this.content.toString().contains(kwd))
            print();
    }

    boolean matchesTag(String kwd) {
        for (String t : tag) {
            if (t.substring(1).equals(kwd))
                return true;
        }
        return false;
    }

    public String[] getTexts() {
        String date = start_Date + " - " + end_Date;
        StringBuilder tagString = new StringBuilder();
        for (String s : tag) {
            if (s == null || s.length() == 0)
                continue;
            tagString.append(s);
        }
        return new String[]{name, date, tagString.toString(), content.toString()};
    }
}
package phj20240798;
import java.util.Random;
import java.util.Scanner;

public class phj20240798_Mid1 {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("게임을 시작하시겠습니까? (1: 시작, 2: 종료): ");
            int menu = 0;

            try {
                menu = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("숫자만 입력하세요.");
                scanner.nextLine(); // 잘못된 입력 제거
                continue;
            }

            if (menu == 1) {
                play(scanner);
            } else if (menu == 2) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("1 또는 2를 입력해주세요.");
            }
        }
        scanner.close();
    }

    public static void play(Scanner scanner) {
        Random random = new Random();
        String[] choices = {"가위", "바위", "보"};

        System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택하세요: ");

        int user = -1;
        try {
            user = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("숫자만 입력하세요.");
            scanner.nextLine();
            return;
        }

        if (user < 0 || user > 2) {
            System.out.println("0~2 사이 숫자만 입력하세요.");
            return;
        }

        int computer = random.nextInt(3);

        System.out.println("당신: " + choices[user] + ", 컴퓨터: " + choices[computer]);

        if (user == computer) {
            System.out.println("비겼습니다!");
        } else if ((user == 0 && computer == 2) ||
                   (user == 1 && computer == 0) ||
                   (user == 2 && computer == 1)) {
            System.out.println("이겼습니다!");
        } else {
            System.out.println("졌습니다!");
        }
    }
}


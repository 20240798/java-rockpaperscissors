package phj20240798;
import java.util.Random;
import java.util.Scanner;

public class phj20240798_Mid2 {
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
                scanner.nextLine();
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

        int[] userHands = new int[2];
        System.out.println("당신의 두 가지 패를 선택하세요 (가위:0, 바위:1, 보:2)");

        for (int i = 0; i < 2; i++) {
            System.out.print((i + 1) + "번째 선택: ");
            try {
                userHands[i] = scanner.nextInt();
                if (userHands[i] < 0 || userHands[i] > 2) {
                    System.out.println("0~2 사이 숫자만 입력하세요.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("숫자만 입력하세요.");
                scanner.nextLine();
                return;
            }
        }

        // 컴퓨터도 두 장 선택
        int compHand1 = random.nextInt(3);
        int compHand2 = random.nextInt(3);
        int compFinal = choose(compHand1, compHand2, random);

        System.out.println("컴퓨터의 두 패: " + choices[compHand1] + ", " + choices[compHand2]);
        System.out.println("컴퓨터가 선택한 패: " + choices[compFinal]);

        // 사용자 선택
        System.out.println("당신의 두 패: " + choices[userHands[0]] + ", " + choices[userHands[1]]);
        System.out.print("당신이 낼 패의 인덱스를 입력하세요 (0 또는 1): ");

        int userIndex = -1;
        try {
            userIndex = scanner.nextInt();
            if (userIndex != 0 && userIndex != 1) {
                System.out.println("0 또는 1만 입력하세요.");
                return;
            }
        } catch (Exception e) {
            System.out.println("숫자만 입력하세요.");
            scanner.nextLine();
            return;
        }

        int userFinal = userHands[userIndex];

        System.out.println("최종 대결: 당신(" + choices[userFinal] + ") vs 컴퓨터(" + choices[compFinal] + ")");

        if (userFinal == compFinal) {
            System.out.println("비겼습니다!");
        } else if ((userFinal == 0 && compFinal == 2) ||
                   (userFinal == 1 && compFinal == 0) ||
                   (userFinal == 2 && compFinal == 1)) {
            System.out.println("당신이 이겼습니다!");
        } else {
            System.out.println("컴퓨터가 이겼습니다!");
        }
    }

    // 컴퓨터가 두 장 중 하나 선택
    public static int choose(int a, int b, Random random) {
        return random.nextBoolean() ? a : b;
    }
}

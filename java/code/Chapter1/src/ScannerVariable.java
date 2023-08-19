/*
Scanner을 사용하여 키보드로부터 입력된 데이터를 읽고 변수에 저장하는 방법을 알아보자

1. Scanner scanner : 변수 선언
2. new Scanner(System.in) Scanner : 객체 생성
3. Scanner scanner = new Scanner(System.in) : 생성된 객체를 변수에 대입

자바는 기본 타입(byte, int, short, long, float, double, boolean) 값이 동일한지 비교할 때는 ==를 사용하고
참조 타입 값이 동일한지 비교할 때는 equals()를 사용한다.

 */

import java.util.Scanner;

public class ScannerVariable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("x 값을 입력하세요: ");
        String strx = sc.nextLine();
        int x = Integer.parseInt(strx);

        System.out.print("y 값을 입력하세요: ");
        String stry = sc.nextLine();
        int y = Integer.parseInt(stry);

        int result = x + y;
        System.out.println("x + y: " + result);
        System.out.println();

        while(true){
            System.out.println("입력 문자열: ");
            String data = sc.nextLine();
            if (data.equals("q")){ // 입력 문장이 q인 경우 중지
                break;
            }
            System.out.println("출력 문자열: " + data);
            System.out.println();
        }
        System.out.println("종료");
    }
}

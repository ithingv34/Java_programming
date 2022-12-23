/*
Switch문을 활용한 조건문 연습

if 문을 사용했을 떄 복잡하다면 switch 문 사용을 고려해보자

switch 문의 괄호에는 정수 타입(byte, char, int, long)과 문자열(String) 변수를 상ㅇ할 수 있다.

 */

public class Switch {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 6) + 1; // 주사위 1 ~ 6

        switch (num) {
            case 1:
                System.out.println("1번");
                break;
            case 2:
                System.out.println("2번");
                break;
            case 3:
                System.out.println("3번");
                break;
            case 4:
                System.out.println("4번");
                break;
            case 5:
                System.out.println("5번");
                break;
            default:
                System.out.println("6번");
        }
    }
}

/*
문자열 타입

char: 작은 따옴표로 감싼 한 개의 문자, 큰 따옴표로 감싼 여러 개의 문자들은 유니코드로 변환되지 않는다.
String: 큰 따옴표로 감싼 문자열, 기본 타입이 아닌 '참조' 타입이다.

기억해야할 이스케이프 문자
\t : 출력시 탭
\n : 줄바꿈
\r : 출력 시 캐리지 리턴

 */

public class StringLiteral {
    public static void main(String[] args) {

        char ch = 'a';
        String s = "ab";

        System.out.println("문자형 리터럴 학습\n" +  ch + "\t" + s);
        //        문자형 리터럴 학습
        //        a	ab
    }
}

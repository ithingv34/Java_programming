/*
비트 논리 연산자

비트 논리 연산자는 byte, short, char 타입 피연산자를 int 타입으로 자동 변환 후 연산을 수행한다.
연산 결과가 int가 되므로 int 변수에 대입해야한다.

byte num1 = 45;
byte num2 = 25;
byte result = num1 & num2 // 컴파일 에러
int result = num1 & num2
 */

public class BitLogic {
    public static void main(String[] args) {
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));

        byte receiveData = -128;

        // 방법1: 비트 논리곱 연산으로 Unsigned 정수 얻기
        int unsignedInt1 = receiveData & 255;
        System.out.println(unsignedInt1);

        // 방법2: 자바 API를 이용해서 Unsigned 정수 얻기
        int unsignedInt2 = Byte.toUnsignedInt(receiveData);
        System.out.println(unsignedInt2);

        int test = 136;
        byte btest = (byte) test;
        System.out.println(btest);
    }
}

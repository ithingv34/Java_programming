/*
정수 타입
정수형: byte, char, short, int, long

문제
char 유니코드 값이 콘솔에 정상적으로 출력되지 않는 현상
1. file -> editor -> utf-8
2. Help -> vm settings utf-8 해봤지만 실패
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntegerLiteral {

    public static void printBinToDec(int dec) {
        /*
        2진수: 0b 또는 0B로 시작하고 0과 1로 작성한다.
        [10진수 -> 2진수로 변환] Integer.toBinaryString(int);
        [2진수 -> 10진수로 변환] Integer.valueOf(binaryVal, 2);
        */
        System.out.println("10진수: " + dec + " -> " + "2진수: " + Integer.toBinaryString(dec));
    }

    public static void printOctToDec(int dec) throws InputMismatchException {
        /*
        2진수: 0b 또는 0B로 시작하고 0과 1로 작성한다.
        [10진수 -> 2진수로 변환] Integer.toBinaryString(int);
        [2진수 -> 10진수로 변환] Integer.valueOf(binaryVal, 2);
        */
        System.out.println("10진수: " + dec + " -> " + "8진수: " + Integer.toOctalString(dec));
    }

    public static void printHexDec(int dec) throws InputMismatchException {
        /*
        2진수: 0b 또는 0B로 시작하고 0과 1로 작성한다.
        [10진수 -> 2진수로 변환] Integer.toBinaryString(int);
        [2진수 -> 10진수로 변환] Integer.valueOf(binaryVal, 2);
        */
        System.out.println("10진수: " + dec + " -> " + "16진수: " + Integer.toHexString(dec));
    }

    public static void main(String[] args) {

        System.out.println("정수형 타입 범위 확인하기");

        // byte // -128 ~ 127
        byte byteMinNum = -128;
        byte byteMaxNum = 127;
        System.out.println("byteMinNum: " + byteMinNum);
        System.out.println("byteMaxNum: " + byteMaxNum);

        // char // 0 ~ 65535 (유니코드), char를 2byte의 공간을 사용하여 유니코드 값을 참조
        char charMinNum = 0;
        char charMaxNum = 65535;
        System.out.println("charMinNum: " + charMinNum);
        System.out.println("charMaxNum: " + charMaxNum);

        // short // -32.768 ~ 32.767
        short shortMinNum = -32768;
        short shortMaxNum = 32767;
        System.out.println("shortMinNum: " + shortMinNum);
        System.out.println("shortMaxNum: " + shortMaxNum);

        // int // -2,147,483,648 ~ 2,147,483,647
        int intMinNum = -2147483648;
        int intMaxNum = 2147483647;
        System.out.println("intMinNum: " + intMinNum);
        System.out.println("intMaxNum: " + intMaxNum);

        // long // -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
        long longMinNum = -9223372036854775808L;
        long longMaxNum = 9223372036854775807L;
        System.out.println("longMinNum: " + longMinNum);
        System.out.println("longMaxNum: " + longMaxNum);

        ////////////////////////////////////////////////////////////////////

        System.out.println();
        System.out.println("변수에 대입할 정수 리터널을 진수에 따라 작성하기");
        System.out.println("// ex) 10진수 11");

        System.out.println("10진수: " + 11);
        System.out.println("2진수로 11을 표현하기: " + 0b1011);
        System.out.println("11을 2진수로 변환하기: " + Integer.toBinaryString(11));
        System.out.println("8진수로 11을 표현하기: " + 013);
        System.out.println("11을 2진수로 표현하기: " + Integer.toOctalString(11));
        System.out.println("16진수로 11을 표현하기: " + 0xB);
        System.out.println("11을 2진수로 표현하기: " + Integer.toHexString(11));

        ////////////////////////////////////////////////////////////////////////
        System.out.println();
        System.out.println("진법 변환하여 출력하기 \n 10진수를 입력받아 2진수, 8진수, 16진수로 출력한다.");
        Scanner sc = new Scanner(System.in);

        System.out.printf("0보다 큰 숫자를 입력해주세요:");
        int dec = sc.nextInt();

        printBinToDec(dec); // 2진수 출력
        printOctToDec(dec); // 8진수 출력
        printHexDec(dec); // 16진수 출력
    }
}

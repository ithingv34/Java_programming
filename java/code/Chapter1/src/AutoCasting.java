/*
자동 타입 변환

값의 허용 범위

기본 타입을 허용 범위 순으로 나열
byte < char, short < int < long < float < double

byte byteVal = 10; |00001010|
int intVal = byteVal // byte -> int로 자동 변환됨 //

|00000000|00000000||00000000||00001010| <-----|00001010|

* 정수 타입이 실수 타입으로 변환되는 경우 무조건 자동 타입 변환이 된다.

long longVal = 500L
float floatVal = longVal; // 5.0E2f로 변환
double doubleVal = longVal; // 5.0E2로 변환

char 타입의 경우 int 타입으로 자동 변환되면 유니코드 값이 int 타입에 대입된다.
char charVal = 'a';
int intVal = charVal // 65

* 음수를 포함하지 않는 char 타입의 경우 byte 타입으로 변환되지 않는다.
incompatible types: possible lossy conversion from byte to char

byte byteVal = 65;
char charVal = byteVal;

 */

public class AutoCasting {
    public static void main(String[] args) {
        int intVal = 65;
        long longVal = intVal;

        System.out.println(longVal);
    }
}

/*
실수형

float: 4byte | 32bit | 유효 소수 이하 자리: 7자리
- 부호(1bit) + 지수(8bit) + 가수(23bit)

double: 8byte | 64bit | 유효 소수 이하 자리: 15자리
- 부호(1bit) + 지수(11bit) | 가수(52bit)

- 최상위 1비트는 양수 및 음수를 결정짓는 bit로 0이면 양수, 1이면 음수이다.
- double은 float보다 지수와 가수 부분의 bit 수가 크기 때문에, 더 크고 정밀한 실수를 저장할 수 있다.

컴파일러는 실수 리터럴을 기본적으로 double 타입으로 해석한다. float 타입은 마지막에 소문자 'f' 혹은 'F'를 붙여 컴파일러가 float임을 알 수 있게 해야한다.

 */
public class RealNumberLiteral {
    public static void main(String[] args) {

        // 10진수 리터럴
        double x1 = 0.25;
        double y1 = -3.14;

        // e 또는 E가 포함된 10의 거듭제곱 리터럴
        double x2 = 5e2; // 500.0
        double y2 = 0.12E-2; // 0.0012

        float x3 = 3.14f;
        float y3 = 3E6f;

        System.out.println(x1); // 0.25
        System.out.println(x2); // 500.0
        System.out.println(y1); // -3.14
        System.out.println(y2); // 0.0012
        System.out.println(x3); // 3.14
        System.out.println(y3); // 3000000.0

        System.out.println();
        System.out.println("유효 자릿수를 통한 정밀도 확인");

        float var1 = 0.1234567890123456789f;
        double var2 = 0.1234567890123456789;    // double 타입이 float 타입보다 약 2배 정도의 유효 자릿수를 가진다.

        System.out.println("var1: " + var1);
        System.out.println("var2: " + var2);
        //        var1: 0.12345679
        //        var2: 0.12345678901234568
    }
}

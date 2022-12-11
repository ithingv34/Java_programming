/*
콘솔에 값을 출력하기 위해 주로 사용하는 print, printf, println에 대해 알아보자.

1. print(내용) : 괄호 안의 내용을 출력하고 행을 바꾸지 말아라
2. println(내용) : 괄호 안의 내용을 출력하고 행을 바꿔라
3. printf("형식문자열", 값1, 값2 ... ) : 형식 문자열에 맞추어 뒤의 값을 출력하라

printf()의 형식문자열

- %[값의 순번] [flag 0, -] [전체자릿수][소수자릿수][conversion]
- 형식 문자열에서 %와 conversion은 필수로 작성한다.
- 나머지 값은 생략 가능하다.
- conversion은 타입에 따라서 d(정수), s(문자열), f(실수)가 온다.
- flag는 빈 공간을 채우는 방법이다. 생략시 왼쪽이 공백으로 채워지고 -가 오면 오른쪽이 공백으로 채워진다.
- 전체 자리수는 소수점을 포함한 전체 자리수이다.
- 소수 자리수는 소수 이하 자리수이다.
 */

public class ConsolePrint {
    public static void main(String[] args) {

        // conversion이 s인 경우
        System.out.printf("아이디: %s\n", "ithingv34");
        System.out.printf("이메일 %s\n", "ithingv34@gmail.com");
        // 아이디: ithingv34
        // 이메일 ithingv34@gmail.com

        System.out.println();
        System.out.println("형식 문자열에 포함될 값이 두 개 이상인 경우 값의 순번을 포함시켜야 한다.");
        System.out.printf("아이디: %1$s 이메일: %2$s\n", "ithingv34", "ithingv34@gmail.com" );
        // 아이디: ithingv34 이메일: ithingv34@gmail.com

        System.out.println();
        System.out.println("자주 사용되는 문자열 형식 예시");
        System.out.println("-------------정수-------------");

        int value = 123;
        System.out.println("1. %d, 정수");
        System.out.printf("%d\n", value);
        System.out.println("2. %6d, 6자리 정수, 왼쪽 빈자리 공백");
        System.out.printf("%6d\n", value);
        System.out.println("3. %-6d, 6자리 정수, 오른쪽 빈자리 공백");
        System.out.printf("%-6d\n", value);
        System.out.println("4. 06d, 6자리 정수, 왼쪽 빈자리 0으로 채움");
        // 1. %d, 정수
        //123
        // 2. %6d, 6자리 정수, 왼쪽 빈자리 공백
        //   123
        // 3. %-6d, 6자리 정수, 오른쪽 빈자리 공백
        //123
        // 4. 06d, 6자리 정수, 왼쪽 빈자리 0으로 채움
        //000123

        double radius = 12345;
        System.out.println("-------------실수-------------");
        System.out.println("1. %10.2f, 정수 7자리, 소수점, 소수 2자리, 왼쪽 빈자리 공백");
        System.out.printf("%10.2f\n", radius);
        System.out.println("2. %-10.2f, 정수 7자리, 소수점, 소수 2자리, 오른쪽 빈자리 공백");
        System.out.printf("%-10.2f\n", radius);
        System.out.println("3. %010.2f, 정수 7자리, 소수점, 소수 2자리, 왼쪽 빈자리 0으로 채움");
        System.out.printf("%010.2f\n", radius);
        // 1. %10.2f, 정수 7자리, 소수점, 소수 2자리, 왼쪽 빈자리 공백
        //  12345.00
        // 2. %-10.2f, 정수 7자리, 소수점, 소수 2자리, 오른쪽 빈자리 공백
        //12345.00
        // 3. %010.2f, 정수 7자리, 소수점, 소수 2자리, 왼쪽 빈자리 0으로 채움
        //0012345.00


        System.out.println("-------------문자열-------------");
        String name = "name";

        System.out.println("1. %s, 문자열");
        System.out.printf("%s\n", name);
        System.out.println("2. %6s, 6자리 문자열, 왼쪽 빈자리 공백");
        System.out.printf("%6s\n", name);
        System.out.println("3. %-6s, 6자리 문자열, 오른쪽 빈자리 공백");
        System.out.printf("%-6s\n", name);
        // 1. %s, 문자열
        //name
        // 2. %6s, 6자리 문자열, 왼쪽 빈자리 공백
        //  name
        // 3. %-6s, 6자리 문자열, 오른쪽 빈자리 공백
        //name

        String s = "홍길동";
        String job = "도적";
        System.out.printf("%6d | %-10s | %10s\n", 1, s, job);
        //     1 | 홍길동        |         도적

    }

}

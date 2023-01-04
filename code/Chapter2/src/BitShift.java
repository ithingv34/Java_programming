/*
비트 이동 연산자

비트를 좌측 또는 우측으로 밀어서 이동시키는 연산

a << b : 정수 a의 각 비트를 b 만큼 왼쪽으로 이동, 오른쪽 빈자리는 0으로 채운다. 이는 a * 2^b와 동일한 결과이다. 
a >> b : 정수 a의 각 비트를 b 만큼 오른쪽으로 이동, 왼쪽 빈자리는 최상위 부호비트와 동일한 값으로 채운다. 이는 a / 2^b와 동일한 결과이다.
a >>> b : 정수 a의 각 비트를 b만큼 오른쪽으로 이동, 왼쪽 빈자리는 0으로 채운다.

 */

public class BitShift {
    public static void main(String[] args) {
        // a << b
        System.out.println(1 << 3);
        System.out.println(1 * (int) Math.pow(2, 3));

        // a >> b
        System.out.println(-8 >> 3); // -8 / 8 = -1

        System.out.println(-8 >>> 3);
    }
}

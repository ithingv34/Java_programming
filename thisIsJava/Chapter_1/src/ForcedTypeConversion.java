/*
강제 형변환

큰 허용 범위 타입은 작은 범위 타입으로 자동 타입 변환될 수 없지만 강제 타입 변환을 통해 캐스팅이 가능하다.

작은 허용 범위 타입 = (작은 허용범위 타입) 큰 허용 범위 타입


 */
public class ForcedTypeConversion {
    public static void main(String[] args) {

        // int ----> byte 타입 변환
        // 2byte 이상이 필요한 int 값은 원래 값이 보존되지 않는다.
        // byte 타입 변환 시 -128 ~ 127 의 범위 값을 가진다.
        int intVal = 10;
        byte byteVal = (byte) intVal;
        System.out.println("byte: " + byteVal);

        // long ----> int 타입 변환
        long longVal = 300;
        int intVal2 = (int) longVal;
        System.out.println("int: " + intVal2);

        // int ----> char 타입 변환
        // char의 허용 범위는 0 ~ 65535까지 이다.
        int intVal3 = 65;
        char charVal = (char) intVal3;
        System.out.println("char: " + charVal);

        System.out.println("실수 -----> 정수 타입 변환");
        System.out.println("소수점 이하 부분은 버려지고 정수부만 남게된다.");

        int intVal4 = 10;
        double doubleVar = 5.5;
        int result = intVal4 + (int) doubleVar;
        System.out.println(result);
    }
}

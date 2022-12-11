### Contents
- 연산식에서 자동 형변환
- 문자열을 기본 타입으로 변환


---
### 연산식에서 자동 형변환

자바는 실행 성능을 향상시키기 위해 컴파일 단계에서 연산을 수행한다.

```java
// 정수 리터럴 연산
byte result = 10 + 20; // 컴파일 byte result = 30
```

- 자바 컴파일러는 컴파일 단계에서 10과 20을 미리 연산해서 30으로 만들고 result 변수에 30을 저장하는 바이트코드를 생성한다.
- 런타임에서 계산이 없으므로 실행 성능이 좋아진다.

**변수가 피연산자로 연산 수행 시 런타임에서 계산을 수행한다.**
 
- 정수 타입 변수가 산술 연산식에서 피연산자로 사용되면 int 보다 작은 byte, short 타입의 변수는 int 타입으로 자동 형변환되어 연산을 수행한다.
- 특별한 이유가 없다면 정수 연산에서 변수가 사용될 경우, 결국 int로 타입 변환되기 때문에 처음부터 int 타입으로 변수를 선언하는 것이 실행 성능에 도움된다.

```java
byte x = 10;
byte y = 20;
int result = x + y;

// x(byte) + y(byte) --->  x (int) + y (int)
```

- 정수 연산에서 모든 변수가 int 타입으로 변환되는 것은 아니다. int 타입보다 허용 범위가 큰 long 타입이 피 연산자로 사용되면 다른 피연산자는 long 타입으로 변환되어 연산을 수행한다.
```java
long x = 10;
int y = 20;
long result = x + y;
```

**실수 연산**
- 피 연산자가 동일한 실수 타입이라면 해당 타입으로 연산된다. 
    - ex) float result = 3.14f + 1.2f 
- 피 연산자 중 하나가 double 타입이면 다른 피연산자도 double 타입으로 변환되어 연산되고 연산 결과도 double 타입이 된다.
- int 타입과 double 타입을 연산하는 경우에도 int 타입 피연산자가 double 타입으로 자동 변환도고 연산을 수행한다.

```java
int intVal = 10;
double doubleVal = 20.0;
double result = intVal + doubleVal // 10.0 + 20.0 = 30
```

- 만약 int 타입으로 연산을 해야한다면 double 타입을 int로 강제 변환하여 덧셈 연산을 수행한다.
```java
int intVal = 10;
double doubleVal = 5.5;
int result = intVal + (int) doubleVal; // 10 + 5 = 15
```

**중요**
- 자바에서 정수 연산의 결과는 항상 정수가 된다.
```java
// x / y 는 정수 연산이므로 결과값이 0이 되며 0.5가 되기 위해서는 (double) x / (double) y로 강제 변환해야한다.
// (double) x/y 를 하면 x/y값이 먼저 계산되고 double로 변환하므로 값이 0.0이 된다.
int x = 1;
int y = 2;
double result = x / y 
```


### 문자열을 기본 타입으로 변환

문자열을 숫자 타입으로 변환하는 경우, '12'와 '3.5'를 실수 타입으로 변환하여 숫자 연산을 하는 경우

1. String -> byte
```java
String str = "10";
byte value = Byte.parseByte(str);
```

2. String -> short
```java
String str = "10";
short value = Short.parseShort(str);
```

3. String -> int
```java
String str = "10";
int value = Integer.parseInt(str);
``` 

4. String -> long
```java
String str = "10";
long value = Long.parseLong(str);
``` 

5. String -> float
```java
String str = "10.345";
float value = Float.parseFloat(str);
``` 

6. String -> double
```java
String str = "10.0";
Double value = Double.parseDouble(str);
``` 

7. String -> Boolean
```java
String str = "10";
Boolean value = Boolean.parseBoolean(str);
``` 

**기본 타입을 문자열로 변경하는 경우**
```java
String str = String.valueOf(기본타입값);
```
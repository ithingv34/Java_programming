# 연산자

- 부호/증감 연산자
- 산술 연산자
- 오버플로우 언더플로우
- 정확한 계산이 필요하다면 실수 연산 대신 정수 연산으로
- 나눗셈 연산 후 `Nan`과 `Infinity` 처리
- 비교연산자
- 논리연산자
- 삼항연산자

---
### 부호/증감 연산자
- `-` 연산자는 변수값의 부호를 변경할 때 사용된다. 주의할 점은 부호 변경 후의 타입이다. 컴파일 에러가 발생할 수 있다.
```java
byte b = 100;
byte result = -b; // 컴파일 에러
```

- 정수 타입 (byte, short, int) 연산의 결과는 int 타입이고 부호를 변경하는 것도 연산이므로 다음과 같이 int 타입 변수에 대입해야한다.
```java
byte b = 100;
inrt result = -b;
```

---
### 산술연산자
- 피 연산자가 정수 타입(byte, short, int, char) 이면 연산 결과는 int 타입이다.
- 피 연산자가 정수 타입이고 그 중 하나가 long 타입이면 연산의 결과는 long 타입이다.
- 피 연산자 중 하나가 실수 타입이면 연산 결과는 실수 타입이다.

```java
byte v1 = 10;
byte v2 = 4;
int v3 = 5;
long v4 = 10L;

// byte + byte
int result1 = v1 + v2; // int 타입으로 자동 변환 후 연산

// byte + byte - long
long result2 = v1 + v2 - v4; // long 타입으로 자동 변환 후 연산

// (double) byte / byte
double result3 = (double) v1 / v2 // 2.5

// % 연산
int result4 = v1 % v2 // 2
```
---

### 오버플로우, 언더플로우

`오버플로우`란 타입이 허용하는 최대값을 벗어나는 것을 말하며 `언더플로우`는 최소값을 벗어나는 것을 말한다. 정수 타입 연산에서 오버플로우/언더플로우가 발생하면 실행 에러가 발생하지 않고 해당 정수 타입의 최소값 또는 최대값으로 되돌아간다.
- 연산 과정 중 발생하는 오버플로우/언더플로우는 기대하는 값이 아니기 때문에 항상 해당 타입의 범위 내에서 연산이 수행되도록 신경써야한다.
- int 타입에서 오버플로우가 발생할 가능성이 있다면 long으로 타입을 변경해야한다.

**`byte` 타입일 경우 최대값인 127에서 1을 더해 오버플로우가 발생하면 최소값인 -128이 된다. 반댁로 언더플로우가 발생하면 결과는 최대값인 127이 된다.**
```java
byte val = 127;
val++; // 127 + 1 -> overflow --> -128

byte val2 = -128;
val--; // -128 - 1 -> underflow --> 127
```

---

### 정확한 계산은 정수 연산으로 하자

- 산술 연산을 정확하게 계산하고 싶다면 **실수 타입을 사용하지 않는 것이 좋다**

```java
int apple = 1;
double priceUnit = 0.1;
int number = 7;
double result = apple - number * priceUnit;

// 출력 결과 result의 값은 정확히 3이 되지 않는다. 이것은 부동 소수점 방식을 사용하는 실수 타입에서 흔히 발생한다.
// 0.299999999999999993
```

**정확한 계산이 필요하다면 정수 연산으로 계산하자**
```java
int apple = 1;
int totalPrices = apple * 10;
int number = 7;

int result = totalPrices - number; // 3
```
---
### 나눗셈 연산 후 `Nan`과 `Infinity` 처리
- 나눗셈 (/) 또는 나머지 (%) 연산에서 좌측 피연산자가 정수이고 우측 피연산자가 0일 경우 예외(ArithmeticException)가 발생한다.
- 무한대의 값은 정수로 표현할 수 없다.
- `Infinity` 혹은 `NaN`인 상태에서 연산을 계속하면 안된다.

```java
int x = 5;
int y = 0;
int result = x / y; //에러
```

**좌측 피 연산자가 실수이거나 우측 피연산자가 0.0 또는 0.0f이면 예외가 발생하지 않고 연산의 결과는 `Infinity` 또는 `NaN(Not a Number)`가 된다.
```java
// 우측 피연산자가 0.0인 경우
5 / 0.0 -> Infinity  
5 % 0.0 -> Nan
```

** `/` 혹은 `%` 결과가 `Infinity` 인지 `NaN` 인지 먼저 확인하고 다음 연산을 수행하는 것이 좋다**
- 확인을 위해 `Double.isInifnite()` 와 `Double.isNaN()` 을 사용하며 참이면 true 거짓이면 false를 리턴한다.

```java
int x = 5;
double y = 0.0;
double z = x / y; // Infinity

if (Double.isInfinite(z) || Double.isNaN(z)) {
    System.out.println("값 산출 불가");
} else {
    System.out.println(z + 2);    
}

// 값 산출 불가
```
---
### 비교연산자

- 피연산자의 타입이 다를 경우 비교 연산을 수행하기 위해 타입을 일치시킨다.
```java
'A' = 64 // true
3 == 3.0 // true
0.1f == 0.1 // false
0.1f == (float) 0.1 // true
```

- 문자열을 비교할 때 동등 연산자 대신 `equals()`와 `!equals()`를 사용한다.
```java
boolean result = str1.equals(str2); // 문자열이 같은지 검사
boolean result = !str1.euqlas(str2); // 문자열이 다른지 검사
```

---
### 논리연산자

논리곱(&&), 논리합(||), 배타적 논리합(^), 논리부정(!) 연산을 수행하는 연산자

- AND (&& 혹은 &) : 피연사자 모두가 true일 경우에만 연산 결과가 true 
- OR (|| 또는 |) : 피연산자 중 하나만 true이면 연산 결과는 true
- XOR (^) : 피연산자 중 하나가 true이고 다른 하나가 false인 경우
- NOT (! : 피연산자의 논리값을 바꿈

**&&과 &은 산출 결과는 같지만 연산 과정이 조금 다르다(||도 마찬가지)**
- &&는 앞의 피연산자가 false라면 뒤의 피연산자를 평가하지 않고 false를 산출한다.
- &는 두 피연산자 모두를 평가해서 산출 결과를 낸다.
  -> &&가 조금 더 효율적으로 동작한다. 

---
### 삼항연산자

삼항 연산자는 (피연산자? 피연산자 : 피연산자)는 총 3개의 피연산자를 가진다. 

- `조건식(피연산자1) ? : 값 또는 연산식(피연산자2) : 값 또는 연산식(피연산자3)` 

```java
int score = 85;
char grade = (score > 90) ? 'A' : (score > 80) ? 'B' : 'C';
```

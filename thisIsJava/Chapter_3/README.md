## contents
- switch
- do-while


### switch문

- 자바 12버전 이후부터는 swtich 문에서 Expression(표현식)을 사용할 수 있다.
- break 문을 없애는 대신에 화살표와 중괄호를 사용한다.

```java
char grade = 'B';

switch (grade) {
    case 'A', 'a' -> {
        System.out.println("A");    
    }
    case 'A', 'a' -> {
        System.out.println("B");
    }
    default -> {
        System.out.println("C");
    }
}
```

- 괄호 생략 버전
```java
switch(grade) {
    case 'A', 'a' -> System.out.println("A");
    case 'B', 'b' -> System.out.println("B");
    default -> System.out.println("C");
}
```

switch Expression을 사용하면 스위치된 값을 변수에 바로 대입할 수도 있다. 단일 값일 경우에는 화살표 오른쪽에 값을 기술하고
중괄호를 사용할 때는 `yield` 키워드로 값을 지정하면 된다. 이때는 반드시 `default` 가 존재해야한다.

```java
int score = switch(grade) {
    case "A" -> 100;
    case "B" -> {
        int result = 100 - 20;
        yield result;
    }
    default -> 60;
}
```

---

### do-while
- do-while 문은 조신식에 의해 반복 실행한다는 점에서는 while문과 동일하다.
- while 문은 시각할 때부터 조건식을 평가하여 블록 내부를 실행할지 결정하지만, 경우에 따라 블록 내부를 먼저 실행시킨다.
- 실행 결과에 따라 반복 실행을 계속할지 결정하는 경우도 있다.

```java
do {
    실행문 // 조건이 참일 경우 반복 실행
} while (조건식 ) // 조건이 거짓일 경우 실행 종료 
```

```java
// inputStr의 값이 "q"가 아니면 계속 입력받는 반복문
do  {
    inputStr = sc.nextLine();
    System.out.println(inputStr)
} while (!inputStr.equals("q"))
```



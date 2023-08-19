# 헷갈리는 built-in function 정리

**목록**

- aiter()
- all()
- any()
- anext()
- ascii()
- bin()
- bool()
- breakpoint()
- bytearray()
- bytes()
- callable()
- chr()
- compile()
- complex()
- delattr()
- dir()
- divmod()
- enumerate()
- eval()
- exec()
- filter()
- frozenset()
- getattr()
- globals()
- hasattr()
- hash()
- help()
- hex()
- id()
- input()
- isinstance()
- issubclass()
- iter()
- locals()
- map()
- memoryview()
- next()
- object()
- oct()
- open()
- ord()
- property()
- range()
- repr()
- reversed()
- round()
- setattr()
- slice()
- sorted()
- super()
- tuple()
- vars()
- zip()
- `__import__()`

---

### A

---

- `aiter()`: 비동기 이터레이터를 반환하는 함수

  - `async for` 루프를 사용하여 비동기적으로 값을 반복하고 처리할 수 있다.
  - 비동기 이터레이터는 `__anext__()` 메서드를 사용하여 비동기적으로 다음 값을 가져올 수 있는 객체이다.

- `anext()`: 비동기적으로 값을 반복적으로 반환하고 StopAsyncIteration 예외를 발생시켜 반복을 종료하는 함수

```python
import asyncio

class AsyncCounter:
    def __init__(self, stop):
        self.current = 0
        self.stop = stop

    # `async for`로 동작하는 클래스를 만드려면 `__aiter__` 와 `__anext__` 메서드를 반드시 구현해야 한다.
    def __aiter__(self):
        return self

    # 메서드를 만들 때는 반드시 `async def`를 붙여 네이티브 코루틴임을 명시
    async def __anext__(self):
        if self.current < self.stop:
            await asyncio.sleep(1.0)
            r = self.current
            self.current += 1
            return r
        else:
            raise StopAsyncIteration

async def main():
    async for i in AsyncCounter(3):    # for 앞에 async를 붙임
        print(i, end=' ')

# python 3.10
asyncio.run(main())

0 1 2
```

**참고페이지**

- https://peps.python.org/pep-0525/
- https://docs.python.org/ko/3/library/functions.html#aiter
- https://docs.python.org/ko/3/reference/compound_stmts.html#async-for
- https://dojang.io/mod/page/view.php?id=2469

---

- `all()`: iterable 객체의 모든 요소가 참인지 검사하는 함수이다. 모든 요소가 참이면 True를 반환하고, 그렇지 않으면 False를 반환한다.

```python
lst1 = [True, True, True]
lst2 = [True, False, True]

print(all(lst1))  # 출력: True
print(all(lst2))  # 출력: False
```

---

- `any()`: iterable 객체의 요소 중 하나라도 참인지 검사하는 함수이다. 하나 이상의 요소가 참이면 True를 반환하고, 모든 요소가 거짓이면 False를 반환한다.

```python
lst1 = [False, False, False]
lst2 = [True, False, True]

print(any(lst1))  # 출력: False
print(any(lst2))  # 출력: True
```

---

- `ascii()`: 주어진 객체를 ASCII 문자로 표현한 문자열로 반환하는 함수이다. 일반적으로는 객체의 문자열 표현과 동일한 결과를 반환하지만, 특정 문자를 이스케이프 처리한 문자열을 반환할 수도 있다.

```python
print(ascii('Hello'))      # 출력: 'Hello'
print(ascii('안녕'))       # 출력: '\uc548\ub155'
print(ascii('\u03C0'))     # 출력: '\\u03C0'
print(ascii('\U0001F600'))  # 출력: '\\U0001F600'
```

---

### B

---

- `bin()`: 정수를 이진수로 변환하여 문자열로 반환한다. 반환된 이진수 문자열은 '0b' 접두사가 붙는다.

```python
num = 10
binary = bin(num)
print(binary)  # 출력: '0b1010'
```

---

- `bool()`: 주어진 값을 불리언으로 변환하여 반환한다. 0, 빈 문자열, None 등이 False로 변환되고, 그 외의 값은 True로 변환된다.

```python
value1 = 0
value2 = ""
value3 = None
value4 = 10
value5 = "Hello"

print(bool(value1))  # 출력: False
print(bool(value2))  # 출력: False
print(bool(value3))  # 출력: False
print(bool(value4))  # 출력: True
print(bool(value5))  # 출력: True
```

---

- `breakpoint()`: 디버깅을 위해 프로그램 실행 중에 중단점을 설정하는 함수이다. 코드 실행이 해당 위치에서 일시 중지되고, 디버거가 실행된다.

```python
def calculate(a, b):
    result = a + b
    breakpoint()  # 중단점 설정
    return result

result = calculate(3, 5)
print(result)

#####################
-> return result
(Pdb) result
8
```

**참고페이지**

- https://docs.python.org/ko/3/library/functions.html#breakpoint

---

- `bytearray()`: 주어진 값을 수정 가능한 바이트 배열로 반환한다. 문자열, 리스트 등의 값을 인수로 전달하여 바이트 배열로 변환할 수 있다.

```python
text = "Hello"
byte_array = bytearray(text, 'utf-8')
print(byte_array)  # 출력: bytearray(b'Hello')
```

---

- `bytes()`: 주어진 값을 변경할 수 없는 바이트 객체로 반환한다. 문자열, 리스트 등의 값을 인수로 전달하여 바이트 객체로 변환할 수 있다.

```python
text = "Hello"
byte_object = bytes(text, 'utf-8')
print(byte_object)  # 출력: b'Hello'
```

### C

---

- `callable()`: 주어진 객체가 호출 가능한지 여부를 판단하여 불리언 값을 반환한다. 함수, 메서드, 클래스 등이 포함된다.

```python
def my_function():
    print("Hello!")


class MyClass:
    def instance_method(self):  # 인스턴스 메서드
        print("This is an instance method.")

    @staticmethod
    def static_method():  # 정적 메서드
        print("This is a static method.")

    @classmethod
    def class_method(cls):  # 클래스 메서드
        print("This is a class method.")


print(callable(my_function))  # True
print(callable(MyClass.instance_method))  # True
print(callable(MyClass.static_method))  # True
print(callable(MyClass.class_method))  # True
```

---

- `chr()`: 주어진 정수를 해당하는 유니코드 문자로 변환하여 반환한다.

```python
char = chr(65)
print(char)  # 출력: 'A'
```

---

- `compile()`: 주어진 소스 코드를 컴파일하여 코드 객체로 반환한다. 반환된 코드 객체는 exec() 함수나 eval() 함수에서 사용할 수 있다.

```python
source = "print('Hello, World!')"
code = compile(source, "hello.py", "exec")
exec(code)  # 출력: Hello, World!
```

---

- `complex()`: 주어진 실수나 문자열을 복소수로 변환하여 반환한다. 복소수는 실수 부분과 허수 부분으로 구성된다.

```python
num = complex(2, 3)
print(num)  # 출력: (2+3j)
```

### D

---

- `delattr()`: 객체에서 지정된 이름의 속성을 제거하는 역할을 한다.

```python
class MyClass:
    def __init__(self):
        self.name = "John"
        self.age = 25

obj = MyClass()
print(obj.name)  # 출력: John

delattr(obj, "name")
print(obj.name)  # AttributeError: 'MyClass' object has no attribute 'name'
```

---

- `dir()`: 객체가 가지고 있는 속성과 메서드의 리스트를 반환한다

```python
my_list = [1, 2, 3]
print(dir(my_list))

# 출력
['__add__', '__class__', '__class_getitem__', '__contains__', '__delattr__', '__delitem__', '__dir__', '__doc__', '__eq__', '__format__', '__ge__', '__getattribute__', '__getitem__', '__gt__', '__hash__', '__iadd__', '__imul__', '__init__', '__init_subclass__', '__iter__', '__le__', '__len__', '__lt__', '__mul__', '__ne__', '__new__', '__reduce__', '__reduce_ex__', '__repr__', '__reversed__', '__rmul__', '__setattr__', '__setitem__', '__sizeof__', '__str__', '__subclasshook__', 'append', 'clear', 'copy', 'count', 'extend', 'index', 'insert', 'pop', 'remove', 'reverse', 'sort']
```

---

- `divmod()`: 두 개의 숫자를 인자로 받아 나눗셈과 나머지를 반환한다. 반환값은 (몫, 나머지)의 형태로 구성된 튜플이다.

```python
result = divmod(10, 3)
print(result)  # 출력: (3, 1)
```

### E

---

- `enumerate()`: 순회 가능한(iterable) 객체를 입력으로 받아 인덱스와 해당 요소로 구성된 enumerate 객체를 반환한다.

```python
my_list = ['apple', 'banana', 'orange']
for index, value in enumerate(my_list):
    print(index, value)

#
0 apple
1 banana
2 orange
```

---

- `eval()`: 문자열로 표현된 파이썬 코드를 실행하여 결과를 반환한다. 주의해야 할 점은 eval() 함수를 사용할 때 보안상의 이유로 신뢰할 수 없는 코드는 실행하지 않아야 한다.

```python
x = 10
result = eval("x + 5")
print(result)  # 출력: 15
```

---

- `exec()`: 문자열로 표현된 파이썬 코드를 실행한다. `eval() `함수와 달리 실행 결과를 반환하지 않고 코드를 직접 실행한다. 마찬가지로 보안상의 이유로 신뢰할 수 없는 코드는 실행하지 않아야 한다.

```python
code = '''
x = 10
for i in range(x):
    print(i)
'''
exec(code)

#
0
1
2
3
4
5
6
7
8
9
```

### F

---

- `filter()`: 주어진 함수를 사용하여 iterable에서 조건을 만족하는 요소만을 걸러내는 역할을 한다.

```python
def is_even(num):
    return num % 2 == 0

numbers = [1, 2, 3, 4, 5, 6]
even_numbers = list(filter(is_even, numbers))
print(even_numbers)  # 출력: [2, 4, 6]

```

---

- `frozenset()`: 변경할 수 없는(frozen) 집합(set) 객체를 생성한다. 집합은 중복되지 않은 요소들로 구성되며, 변경할 수 없는 특성을 가지는 frozenset은 수정할 수 없는 집합을 의미한다.

```python
numbers = [1, 2, 3, 3, 4, 5, 5]
unique_numbers = frozenset(numbers)
print(unique_numbers)  # 출력: frozenset({1, 2, 3, 4, 5})
```

### G

---

- `getattr()`: 객체에서 지정된 이름의 속성을 가져오는 역할을 한다.

```python
class Person:
    def __init__(self, name):
        self.name = name

person = Person("Alice")
name_attr = getattr(person, "name")
print(name_attr)  # 출력: Alice
```

---

- `globals()`: 현재 전역 심볼 테이블을 나타내는 딕셔너리를 반환한다.

```python
global_var = 10
print(globals())  # 전역 심볼 테이블을 나타내는 딕셔너리 출력

# 출력
{..., 'global_var': 10}

```

### H

---

- `hasattr()`: 객체가 특정 이름의 속성을 가지고 있는지 확인하는 역할을 한다.

```python
class Person:
    def __init__(self, name):
        self.name = name

person = Person("Bob")
has_name = hasattr(person, "name")
print(has_name)  # 출력: True

```

---

- `hash()`: 주어진 객체의 해시 값을 반환한다.

```python
my_dict = {"apple": 1, "banana": 2}
hash_value = hash(my_dict)
print(hash_value)  # 출력: -9223372036574812776
```

---

- `help()`: 객체나 모듈의 도움말 정보를 출력한다.

```python
help(list)  # list에 대한 도움말 정보 출력
```

---

- `hex()`: 정수를 16진수 문자열로 변환한다.

```python
num = 16
hex_value = hex(num)
print(hex_value)  # 출력: 0x10
```

### I

---

- `id()`: 객체의 고유 식별자(ID)를 반환한다.

```python
obj = "Hello"
obj_id = id(obj)
print(obj_id)  # 출력: 고유한 정수 값
```

---

- `input()`: 사용자로부터 입력을 받는 역할을 한다.

```python
name = input("이름을 입력하세요: ")
print("안녕하세요, " + name + "님!")
```

---

- `isinstance()`: 객체가 특정 클래스의 인스턴스인지 확인하는 역할을 한다.

```python
class Person:
    pass

person = Person()
is_person = isinstance(person, Person)
print(is_person)  # 출력: True
```

---

- `issubclass()`: 클래스가 다른 클래스의 서브클래스인지 확인하는 역할을 한다.

```python
class Animal:
    pass

class Dog(Animal):
    pass

is_subclass = issubclass(Dog, Animal)
print(is_subclass)  # 출력: True
```

---

- `iter()`: 순회 가능한(iterable) 객체에서 이터레이터(iterator)를 반환한다.

```python
my_list = [1, 2, 3]
my_iterator = iter(my_list)
print(next(my_iterator))  # 출력: 1
```

### L

- `locals()`: 현재 local 심볼 테이블을 나타내는 딕셔너리를 반환한다.

```python
def my_function():
    x = 10
    y = 10
    print(locals())

my_function()  # local 심볼 테이블을 나타내는 딕셔너리 출력

# {'x': 10, 'y': 10}
```

### M

---

- `map()`: 주어진 함수를 순회 가능한(iterable) 객체의 모든 요소에 적용하여 새로운 이터레이터(iterator)를 반환한다.

```python
def square(x):
    return x ** 2

numbers = [1, 2, 3, 4, 5]
squared_numbers = list(map(square, numbers))
print(squared_numbers)  # 출력: [1, 4, 9, 16, 25]
```

---

- `memoryview()`: 객체의 메모리를 바이트 단위로 조작할 수 있는 메모리 뷰(memory view) 객체를 생성한다.

```python
my_bytes = b"Hello"
view = memoryview(my_bytes)
print(view[1])  # 출력: 101 (ASCII 코드 값)
```

### N

---

- `next()`: 함수는 이터레이터(iterator)에서 다음 요소를 반환한다.

```python
my_list = [1, 2, 3]
my_iterator = iter(my_list)
print(next(my_iterator))  # 출력: 1
```

### O

---

- `object()`: 함수는 새로운 객체를 생성한다.

```python
my_object = object()
print(my_object)  # 출력: <object object at 0x...>
```

---

- `oct()`: 정수를 8진수 문자열로 변환한다.

```python
num = 10
oct_value = oct(num)
print(oct_value)  # 출력: '0o12'
```

---

- `open()`: 파일을 열고 해당 파일 객체를 반환한다.

```python
file = open("example.txt", "r")
content = file.read()
print(content)
file.close()
```

---

- `ord()`: 문자의 유니코드 코드 포인트를 반환한다.

```python
char = 'A'
code_point = ord(char)
print(code_point)  # 출력: 65
```

### P

---

- `property()`: 클래스에서 속성에 대한 getter와 setter를 정의하기 위해 사용된다.

```python
class Person:
    def __init__(self, name):
        self._name = name

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value

person = Person("Alice")
print(person.name)  # 출력: Alice
person.name = "Bob"
print(person.name)  # 출력: Bob
```

### R

---

- `range()`: 정수 범위를 나타내는 이터러블(iterable) 객체를 생성한다

```python
my_range = range(1, 5)
for num in my_range:
    print(num)  # 출력: 1, 2, 3, 4
```

---

- `repr()`: 객체의 문자열 표현을 반환한다.

```python
my_list = [1, 2, 3]
list_repr = repr(my_list)
print(list_repr)  # 출력: '[1, 2, 3]'
```

---

- `reversed()`: 순서를 반대로 뒤집은 이터러블(iterable) 객체를 반환한다

```python
my_list = [1, 2, 3]
reversed_list = list(reversed(my_list))
print(reversed_list)  # 출력: [3, 2, 1]
```

---

- `round()`: 숫자를 반올림한 결과를 반환한다.

```python
num = 3.14159
rounded_num = round(num, 2)
print(rounded_num)  # 출력: 3.14
```

### S

---

- `setattr()`: 객체에 속성을 동적으로 설정한다.

```python
class Person:
    pass

person = Person()
setattr(person, "name", "Alice")
print(person.name)  # 출력: Alice
```

---

- `slice()`: 시퀀스를 슬라이스할 때 사용되는 슬라이스 객체를 생성한다.

```python
my_list = [1, 2, 3, 4, 5]
my_slice = slice(1, 4)
sliced_list = my_list[my_slice]
print(sliced_list)  # 출력: [2, 3, 4]
```

---

- `sorted()`: 이터러블(iterable) 객체를 정렬한 결과를 반환한다.

```python
my_list = [5, 2, 4, 1, 3]
sorted_list = sorted(my_list)
print(sorted_list)  # 출력: [1, 2, 3, 4, 5]
```

---

- `super()`: 부모 클래스의 메서드를 호출하는 데 사용된다.

```python
class Animal:
    def sound(self):
        print("Animal sound")

class Dog(Animal):
    def sound(self):
        super().sound()
        print("Woof!")

dog = Dog()
dog.sound()  # 출력: Animal sound, Woof!
```

### T

---

- `tuple()`: 이터러블(iterable) 객체를 튜플로 변환한다.

```python
my_list = [1, 2, 3]
my_tuple = tuple(my_list)
print(my_tuple)  # 출력: (1, 2, 3)
```

### IN

---

- `vars()`: 객체의 속성을 딕셔너리로 반환한다

```python
class Person:
    def __init__(self, name):
        self.name = name

person = Person("Alice")
person_vars = vars(person)
print(person_vars)  # 출력: {'name': 'Alice'}
```

### WITH

---

- `zip()`: 여러 개의 이터러블(iterable) 객체를 병렬로 묶어서 이터레이터(iterator)를 반환한다.

```python
numbers = [1, 2, 3]
letters = ['A', 'B', 'C']
zipped = zip(numbers, letters)
for item in zipped:
    print(item)  # 출력: (1, 'A'), (2, 'B'), (3, 'C')
```

---

`__import__()`: 문자열로 모듈을 동적으로 가져올 때 사용된다.

```python
math_module = __import__('math')
print(math_module.sqrt(16))  # 출력: 4.0
```

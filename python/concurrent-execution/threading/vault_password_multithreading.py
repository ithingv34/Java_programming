"""
해커 스레드를 사용하여 비밀번호를 찾는 프로그램

이 프로그램은 Vault 클래스를 사용하여 생성된 비밀번호를 해킹하기 위해 AscendingHackerThread 및 DescendingHackerThread 스레드를 실행합니다.
PoliceThread 스레드는 제한 시간 내에 비밀번호를 찾지 못한 경우에 경고를 표시합니다.

- Vault: 비밀번호 저장 및 검증을 위한 클래스
- HackerThread: 해커 스레드의 기본 클래스
- AscendingHackerThread: 비밀번호를 오름차순으로 시도하여 비밀번호를 찾는 스레드
- DescendingHackerThread: 비밀번호를 내림차순으로 시도하여 비밀번호를 찾는 스레드
- PoliceThread: 제한 시간 내에 비밀번호를 찾지 못한 경우 경고를 표시하는 스레드

MAX_PASSWORD는 비밀번호 범위의 최대 값입니다.
"""
import threading
import random
import time
import logging

MAX_PASSWORD = 500


# Vault 클래스 정의
class Vault:
    def __init__(self, password: int) -> None:
        self._password = password

    def is_correct_password(self, guess: int) -> bool:
        time.sleep(0.005)
        return self._password == guess

    def get_password(self) -> int:
        return self._password


# HackerThread 클래스 정의
class HackerThread(threading.Thread):
    def __init__(self, vault: Vault, stop_event: threading.Event, name: str) -> None:
        super().__init__(daemon=True)
        self.vault = vault
        self.stop_event = stop_event
        self.name = name

    def run(self) -> None:
        logging.info("%s 스레드를 시작합니다.", self.name)
        for guess in self.password_range():
            if self.stop_event.is_set():
                logging.info("%s가 종료됩니다.", self.name)
                return

            if self.vault.is_correct_password(guess):
                logging.info("%s가 비밀번호 %d를 찾았습니다.", self.name, guess)
                self.stop_event.set()  # 종료 이벤트 트리거

    def crack_password(self) -> None:
        raise NotImplementedError("비밀번호 찾기 알고리즘을 해야합니다.")


# AscendingHackerThread 클래스 정의
class AscendingHackerThread(HackerThread):
    def password_range(self):
        return range(MAX_PASSWORD)


# DescendingHackerThread 클래스 정의
class DescendingHackerThread(HackerThread):
    def password_range(self):
        return range(MAX_PASSWORD, -1, -1)


# PoliceThread 클래스 정의
class PoliceThread(threading.Thread):
    def __init__(self, name: str, stop_event: threading.Event, timeout: int = 10):
        super().__init__(name=name)
        self.stop_event = stop_event
        self.timeout = timeout

    def run(self) -> None:
        for i in range(self.timeout, 0, -1):
            time.sleep(1)
            if self.stop_event.is_set():
                logging.info("%s가 종료됩니다.", self.name)
                return

            logging.info(i)

        logging.info("제한 시간 %d초 내에 비밀번호를 찾지 못했습니다.", self.timeout)


def main() -> None:
    # Logging 설정
    logging.basicConfig(level=logging.INFO, format="%(threadName)s - %(message)s")

    # 난수 시드 설정
    random.seed()

    vault = Vault(random.randint(0, MAX_PASSWORD))

    logging.info("설정된 비밀번호는 %d 입니다.", vault.get_password())

    # Event 객체 생성
    stop_event = threading.Event()

    threads = []

    threads.append(
        AscendingHackerThread(
            vault,
            stop_event,
            name="AscendingHackerThread",
        )
    )
    threads.append(
        DescendingHackerThread(
            vault,
            stop_event,
            name="DescendingHackerThread",
        )
    )
    threads.append(PoliceThread(name="PoliceThread", stop_event=stop_event))

    # 스레드 생성 및 시작
    for thread in threads:
        thread.start()


if __name__ == "__main__":
    main()

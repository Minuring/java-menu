## 구현할 기능 목록

- [x] 카테고리와 각 카테고리의 메뉴
    ```
    일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
    한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
    중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
    아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
    양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
    ```

- [x] 요일마다 코치 별 메뉴를 추천한다.
  - [x] 한 주에 같은 카테고리는 최대 2회까지만 고를 수 있다.
  - 예시)
  ```
  - 구구: 비빔밥, 김치찌개, 쌈밥, 규동, 우동 → 한식을 3회 먹으므로 불가능
  - 토미: 비빔밥, 비빔밥, 규동, 우동, 볶음면 → 한 코치가 같은 메뉴를 먹으므로 불가능
  - 제임스: 비빔밥, 김치찌개, 스시, 가츠동, 짜장면 → 매일 다른 메뉴를 먹으므로 가능
  - 포코: 비빔밥, 김치찌개, 스시, 가츠동, 짜장면 → 제임스와 메뉴가 같지만, 포코는 매번 다른 메뉴를 먹으므로 가능
  ```
      
    1. 월요일에 추천할 카테고리를 무작위로 정한다.
    2. 각 코치가 월요일에 먹을 메뉴를 추천한다.
    3. 화, 수, 목, 금요일에 대해 i, ii 과정을 반복한다.

  - [x] 추천할 카테고리는 `Randoms.pickNumberInRange()`에서 생성해 준 값을 이용하여 정해야 한다.
      ```java
      // 예시 코드. 사용하는 자료 구조에 따라 난수를 적절하게 가공해도 된다.
      String category = categories.get(Randoms.pickNumberInRange(1, 5));
      ```
    - 임의로 카테고리의 순서 또는 데이터를 변경하면 안 된다.
        - `Randoms.pickNumberInRange()`의 결과가 **1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식**을 추천해야 한다.
    - 추천할 수 없는 카테고리인 경우 다시 `Randoms.pickNumberInRange()`를 통해 임의의 값을 생성해서 추천할 카테고리를 정해야 한다.

  - [x] 추천할 메뉴는 정해진 카테고리에 있는 메뉴를 `Randoms.shuffle()`을 통해 임의의 순서로 섞은 후, 첫 번째 값을 사용해야 한다.
      - 카테고리에 포함되는 메뉴 목록을 `List<String>` 형태로 준비한다.
      ```java
      String menu = Randoms.shuffle(menus).get(0);
      ```
    - 임의로 메뉴의 순서 또는 데이터를 변경하면 안 된다.
        - `Randoms.shuffle()` 메서드의 인자로 전달되는 메뉴 데이터는, 최초에 제공한 목록을 그대로 전달해야 한다.
            - 코치에게 추천할 메뉴를 정할 때 이미 추천한 메뉴, 먹지 못하는 메뉴도 포함된 리스트를 전달해야 한다.
    - 추천할 수 없는 메뉴인 경우 다시 섞은 후 첫 번째 값을 사용해야 한다.

- [x] 입력
  - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
      - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

  - [x] 메뉴 추천을 받을 코치의 이름을 입력받는다.
    - [x] 코치의 이름은 최소 2글자, 최대 4글자이다.
    - [x] 코치는 최소 2명, 최대 5명까지 식사를 함께 한다.
    - [x] 코치는 중복될 수 없다.
    - ex) `토미,제임스,포코`
  - [x] 각 코치별 0~2개의 못 먹는 메뉴를 `,` 로 구분해서 입력한다. (없으면 빈 값)
    - 추천을 못하는 경우는 발생하지 않으니 고려하지 않아도 된다.
    - ex) `우동,스시`
    
- [x] 출력
  - [x] 서비스 시작 문구
    - `점심 메뉴 추천을 시작합니다.`
  - [x] 서비스 종료 문구
  - ```
    메뉴 추천 결과입니다.
    [ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
    [ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
    [ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
    [ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
    [ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]
    
    추천을 완료했습니다.
    ```
  - [x] 예외 상황 시 "[ERROR]"로 시작하는 에러 문구를 출력
    - ```
    [ERROR] 코치는 최소 2명 이상 입력해야 합니다.
    ```

#### 실행 결과 예시

```
점심 메뉴 추천을 시작합니다.

코치의 이름을 입력해 주세요. (, 로 구분)
토미,제임스,포코

토미(이)가 못 먹는 메뉴를 입력해 주세요.
우동,스시

제임스(이)가 못 먹는 메뉴를 입력해 주세요.
뇨끼,월남쌈

포코(이)가 못 먹는 메뉴를 입력해 주세요.
마파두부,고추잡채

메뉴 추천 결과입니다.
[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]
[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]
[ 토미 | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]
[ 제임스 | 된장찌개 | 비빔밥 | 가츠동 | 토마토 달걀볶음 | 파인애플 볶음밥 ]
[ 포코 | 된장찌개 | 불고기 | 하이라이스 | 탕수육 | 나시고렝 ]

추천을 완료했습니다.
```

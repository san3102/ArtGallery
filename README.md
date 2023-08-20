# gallary_sample

![artgall_main](https://github.com/san3102/ArtGallery/assets/103571921/03f6c0fa-540f-427d-93e7-7b9ffbe56122)

07_17 : 완성한 템플릿에 로그인 회원가입 > DB에 유저들 데이터 추가 완료
application-secure 에 API 주요 보안부분 따로 분리해둠
회원가입시 비밀번호 적혀있는 조건에 맞게 입력해야 confirm되도록 수정완료
닉네임 입력 부분 한글도 입력될 수 있게 수정완료

07_24 : 게시물 이미지 업로드, 다운로드, 조회수, 좋아요
        회원 팔로우기능 구현완료

07_28 : 게시물 상세 페이지의 '갤러리세부정보-저장'에서 저장된 횟수 안나옴 -> 수정완료
        정렬 기능 구현
        유저 페이지에서 컬렉션 클릭시 사용자자 저장한 게시물나오고, 컬렉션화면일 땐 정렬 안보이게 함
        토픽(카테고리)별 게시물 나오도록 함

========================== 각자 수정해야하는 부분 ==========================

spring.servlet.multipart.location = 업로드한 이미지 저장경로 각자 수정

PostController.java
String imagePath = "~~" + uuid + "_" + fileName;
 -> ~~ 부분도 업로드한 이미지 저장경로 각자 수정

FileService.java
fileEntity.setFilePath("~~" + uuid + "_fileName.jpg");
 -> ~~ 부분도 업로드한 이미지 저장경로 각자 수정

# ArtGallery

![artgall_main](https://github.com/san3102/ArtGallery/assets/103571921/03f6c0fa-540f-427d-93e7-7b9ffbe56122)

> [artgall.co.kr][artgall]

[artgall]: https://artgall.co.kr

#### 기간 및 팀 구성
2023.07.10 ~ 2023.08.04 <br/>
이산(본인) / 김이홍 / 라영진 / 이예진

#### Skills
<div>
        <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">
        <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
        <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
        <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
        <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
        <img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
        <img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white">
        <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
</div>

#### 형상관리 및 배포
<div>
        <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
        <img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white">
        <img src="https://img.shields.io/badge/linux-FCC624?style=for-the-badge&logo=linux&logoColor=black">
</div>

<br/><br/>

## Discription

### ERD Diagram
<img src="https://github.com/san3102/ArtGallery/assets/103571921/2b11d4cc-4754-4f73-b123-6ca54e216e42" width="600px" height="800px" title="px(픽셀) 크기 설정"></img><br/>

OS X & 리눅스:

```sh
npm install my-crazy-module --save
```

윈도우:

```sh
edit autoexec.bat
```

## 사용 예제

스크린 샷과 코드 예제를 통해 사용 방법을 자세히 설명합니다.

_더 많은 예제와 사용법은 [Wiki][wiki]를 참고하세요._

## 개발 환경 설정

모든 개발 의존성 설치 방법과 자동 테스트 슈트 실행 방법을 운영체제 별로 작성합니다.

```sh
make install
npm test
```

## 업데이트 내역

* 0.2.1
    * 수정: 문서 업데이트 (모듈 코드 동일)
* 0.2.0
    * 수정: `setDefaultXYZ()` 메서드 제거
    * 추가: `init()` 메서드 추가
* 0.1.1
    * 버그 수정: `baz()` 메서드 호출 시 부팅되지 않는 현상 (@컨트리뷰터 감사합니다!)
* 0.1.0
    * 첫 출시
    * 수정: `foo()` 메서드 네이밍을 `bar()`로 수정
* 0.0.1
    * 작업 진행 중

## 정보

이름 – [@트위터 주소](https://twitter.com/dbader_org) – 이메일주소@example.com

XYZ 라이센스를 준수하며 ``LICENSE``에서 자세한 정보를 확인할 수 있습니다.

[https://github.com/yourname/github-link](https://github.com/dbader/)

## 기여 방법

1. (<https://github.com/yourname/yourproject/fork>)을 포크합니다.
2. (`git checkout -b feature/fooBar`) 명령어로 새 브랜치를 만드세요.
3. (`git commit -am 'Add some fooBar'`) 명령어로 커밋하세요.
4. (`git push origin feature/fooBar`) 명령어로 브랜치에 푸시하세요. 
5. 풀리퀘스트를 보내주세요.

<!-- Markdown link & img dfn's -->
[npm-image]: https://img.shields.io/npm/v/datadog-metrics.svg?style=flat-square
[npm-url]: https://npmjs.org/package/datadog-metrics
[npm-downloads]: https://img.shields.io/npm/dm/datadog-metrics.svg?style=flat-square
[travis-image]: https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/dbader/node-datadog-metrics
[wiki]: https://github.com/yourname/yourproject/wiki

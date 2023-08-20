# ArtGallery

![artgall_main](https://github.com/san3102/ArtGallery/assets/103571921/03f6c0fa-540f-427d-93e7-7b9ffbe56122)

> [artgall.co.kr][artgall]

[artgall]: https://artgall.co.kr

### 유저들의 이미지나 사진 공유, 배포를 위한 사이트

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

#### 구현 목록

|구분|기능|구현|
|------|---|---|
|회원가입|이메일 인증|O|
||소셜 로그인|O|
|회원|닉네임 변경|O|
||비밀번호 변경|X|
||팔로우|O|
|게시물|이미지 업로드|O|
||해시태그|O|
||카테고리|O|
||수정, 삭제|O|
||좋아요, 즐겨찾기|O|
||신고|X|
||이미지 다운로드|O|
|댓글|수정, 삭제|O|
||답글|O|
|검색|다중 검색|O|

<br/><br/>

## Description

### 1. ERD Diagram
<img src="https://github.com/san3102/ArtGallery/assets/103571921/2b11d4cc-4754-4f73-b123-6ca54e216e42" width="600px" height="800px"></img><br/>

### 2. Sequence Diagram
#### 회원가입
<img src="https://github.com/san3102/ArtGallery/assets/103571921/651c6665-f419-43fb-a00e-0c52e7e91279" width="750px" height="300px"></img><br/>

> **1. JavaScript 및 jQuery 사용** : 사용자가 아이디, 닉네임, 비밀번호, 이메일 등의 정보를 입력받아 jQuery를 사용하여 이벤트 처리와 DOM 조작을 수행합니다. <br/><br/>
> **2. 유효성 검사 및 상태 관리** : 사용자가 입력한 아이디, 닉네임, 비밀번호, 이메일 등의 데이터를 실시간으로 유효성을 검사합니다. 예를 들어, 아이디와 닉네임은 정규식을 사용하여 형식이나 중복 여부를 확인하고, 비밀번호는 여러 조건을 만족하는지 확인합니다. <br/><br/>
> **3. AJAX 요청** : 입력 데이터의 중복 여부를 확인하기 위해 AJAX를 사용하여 서버에 요청을 보냅니다. 중복된 아이디, 닉네임, 이메일이 이미 존재하는지 확인합니다. <br/><br/>
> **4. Controller** <br/>
> * 회원가입 데이터를 Ajax POST 요청으로 받아 유효성을 검사하고, 에러가 없다면 회원 데이터를 생성합니다.
> * 이메일 인증 코드를 생성하여 반환합니다.
> * 아이디, 닉네임, 이메일 중복 여부를 확인하는 요청을 처리하고 결과를 반환합니다.
>
> **5. Service** <br/>
> * 회원가입 데이터를 사용하여 회원 정보를 생성하고 암호화된 비밀번호를 저장합니다.
> * JPA Repository를 활용해 데이터베이스와의 상호작용을 처리합니다. 아이디, 닉네임, 이메일의 중복 여부를 확인하는 로직을 수행합니다.

<br/><br/>

#### 게시물 등록
<img src="https://github.com/san3102/ArtGallery/assets/103571921/65effec8-3860-44e2-8acc-76e018319366" width="850px" height="300px"></img><br/>

> **1. HTML, JavaScript** : 사용자는 이미지를 업로드하고, 게시물에 대한 정보를 입력할 수 있습니다. 입력받은 데이터를 Form 제출 시 JavaScript로 유효성 검사(Hashtag 입력 데이터 확인) 후 서버에 POST 요청을 보냅니다. <br/><br/>
> **2. Controller**
> * 이미지 파일과 게시물에 필요한 Input 데이터를 받습니다.
> * 업로드된 이미지 파일과 함께 게시물 정보를 사용하여 게시물을 생성하고 데이터베이스에 저장합니다.
> * 생성된 게시물의 ID를 활용하여 해당 게시물의 세부 페이지로 리다이렉트합니다.
>
> **3. Service**
> * FileService
>   + 업로드된 파일을 실제 파일로 저장하고, 해당 파일 정보를 데이터베이스에 저장합니다.
>   + 이미지 파일 여부를 확인하고, 이미지 파일이 아닌 경우 예외를 발생시킵니다.
> * PostService
>   + 게시물 정보를 받아와 JPA Repository를 활용해 데이터베이스에 게시물을 생성하고 저장합니다.
>   + 중복되지 않는 해시태그를 데이터베이스에 저장하거나 이미 존재하는 경우 활용합니다.

<br/><br/>

#### 팔로우
<img src="https://github.com/san3102/ArtGallery/assets/103571921/73d02ddb-6393-4826-86dd-4e7c9b5732dd" width="850px" height="300px"></img><br/>

> **1. HTML, JavaScript**
> * 팔로우 버튼은 조건에 따라 팔로우 추가 또는 팔로우 취소를 나타내는 두 가지 상태로 표시됩니다.
> * 확인 창에서 "확인"을 선택하면 해당 사용자에 대한 팔로우 또는 언팔로우 요청이 서버로 전송됩니다.
> * 요청의 결과에 따라 페이지를 다시로드하여 변경 사항을 반영합니다.
>
> **2. Controller**
> * followUser 메서드: 인증된 사용자(follower)가 다른 사용자(following)를 팔로우하는 동작을 수행합니다.
> * unfollowUser 메서드: 인증된 사용자(follower)가 다른 사용자(following)를 언팔로우하는 동작을 수행합니다.
>
> **3. Service**
> * JPA Repository를 활용해 주어진 follower와 following 사용자 엔티티에 해당하는 팔로우 엔티티를 조회합니다.
> * followUser 메서드는 주어진 팔로우 관계를 JPA Repository를 통해 조회한 뒤, 두 사용자 엔티티를 사용하여 새로운 FollowEntity 엔티티를 생성하고 데이터베이스에 저장합니다.
> * unfollowUser 메서드는 주어진 언팔로우 관계를 JPA Repository를 통해 조회한 뒤, follower와 following 사용자 엔티티에 해당하는 팔로우 엔티티를 조회하여 데이터베이스에서 삭제합니다.

<br/><br/>

### 3. 주요 코드 설명
##### OAuth2.0 소셜 로그인
```java
SecurityConfig.java

public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        ...
        .oauth2Login(oauth2Login -> oauth2Login
            .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService))
        );
    return http.build();
}
```
> * 이 코드 부분은 Spring Security를 설정하는 부분입니다. 인증 없이 접근할 수 있는 엔드포인트와 모든 요청에 대한 인증 설정이 포함되어 있습니다.
> * .oauth2Login : OAuth2 로그인을 처리하는 설정입니다.
> * .userInfoEndpoint : 사용자 정보를 가져오는 엔드포인트 설정입니다.
> * .userService(customOAuth2UserService) : customOAuth2UserService를 통해 사용자 정보를 처리합니다.

```java
CustomOAuth2UserService.java

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    // ...

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest){
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 사용자 정보 처리 및 저장

        return new DefaultOAuth2User(
            // ...
        );
    }

    private UserEntity saveOrUpdate(OAuthAttributes attributes){
        // ...
    }
    
    private String generateUniqueNickname(){
        // ...
    }
}
```
> * 이 클래스는 OAuth2 사용자 정보를 가져오고 저장하는 역할을 합니다
> * loadUser 메서드 : OAuth2 사용자 정보를 가져와서 가공하고 로컬 사용자 엔터티로 변환합니다. OAuth2 공급자로부터 받은 사용자 정보를 토대로 사용자 데이터를 로컬 데이터베이스에 저장하고, 필요한 권한과 속성을 부여하여 반환합니다.
> * saveOrUpdate 메서드 : OAuthAttributes 클래스로부터 생성된 사용자 정보를 로컬 데이터베이스에 저장하거나 업데이트합니다. 기존에 저장된 사용자인지 확인하고, 새로운 사용자일 경우에는 닉네임을 생성하여 저장합니다.
> * generateUniqueNickname 메서드 : 새로운 사용자의 경우 닉네임을 생성합니다. UUID를 사용하여 중복을 피하며 랜덤한 값을 닉네임으로 사용합니다.

```java
OAuthAttributes.java

@Getter
@Builder
public class OAuthAttributes {
    // ...

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
        // ...
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        // ...
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        // ...
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        // ...
    }

    public UserEntity toEntity(){
        // ...
    }
}
```
> * 이 클래스는 OAuth2 소셜 로그인에서 받아온 사용자 정보를 표준화된 형식으로 변환합니다
> * of 메서드 : OAuth2 공급자의 종류와 사용자 정보를 표준화된 형태로 변환하는 메서드입니다. Google, Naver, Kakao 등 각 공급자에 맞게 사용자 정보를 변환합니다.
> * ofGoogle, ofNaver, ofKakao 메서드 : 각 소셜 플랫폼에 맞는 사용자 정보 변환 로직을 구현한 메서드입니다.
> * toEntity 메서드 : 변환된 사용자 정보를 기반으로 로컬 사용자 엔터티(UserEntity)를 생성합니다.

<br/>

##### 검색
```java
PostController.java
...
@PostMapping("/search/post")
public List<PostEntity> getPostsByHashtag(@RequestParam("hashtagName") String hashtagName, @RequestParam int sortingOption){
    return postService.getPostsByHashtag(hashtagName, sortingOption);
}

@GetMapping("/search/post")
public String showSearchForm(){
    return "search_form"; // 검색어 입력을 위한 폼을 보여줍니다.
}
...
```
> * getPostsByHashtag : POST 요청을 통해 검색어와 정렬 옵션을 받아와 postService의 getPostsByHashtag 메서드를 호출하여 해당 해시태그를 포함하는 게시물을 가져옵니다.
> * showSearchForm : GET 요청을 통해 검색어 입력 폼을 보여줍니다.

```java
PostService.java
...
// 검색어를 OR 연산하여 합침
public List<PostEntity> getPostsByHashtag(String keywords, int sortingOption){
    List<String> keywordList = Arrays.stream(keywords.split(" ")).collect(Collectors.toList());
    Specification<PostEntity> searchSpec = Specification.where(null);
    for (String keyword : keywordList) {
        Specification<PostEntity> spec = PostSpecifications.searchAllWithHashtag(keyword);
        searchSpec = searchSpec.or(spec);
    }

    List<PostEntity> sortedPosts;
    switch (sortingOption) {
        case 1:
            // 최신순으로 정렬
            sortedPosts = postRepository.findAll(searchSpec, Sort.by(Sort.Direction.DESC, "createDate"));
            break;
        case 2:
            // 인기순으로 정렬
            sortedPosts = postRepository.findAll(searchSpec, Sort.by(Sort.Direction.DESC, "postLike"));
            break;
        default:
            // 기본적으로 최신순으로 정렬
            sortedPosts = postRepository.findAll(searchSpec, Sort.by(Sort.Direction.DESC, "createDate"));
            break;
    }
    return sortedPosts;
}
...
```
> * getPostsByHashtag : 사용자로부터 입력받은 검색어와 정렬 옵션을 기반으로 게시물을 검색하고 정렬합니다.
>  
>   * keywordList : 사용자가 입력한 검색어를 공백을 기준으로 분리하여 리스트로 저장합니다.
>   * searchSpec : Specification 객체를 사용하여 검색 조건을 생성합니다. 검색어 각각에 대한 검색 조건을 or 연산으로 합칩니다.
>   * sortedPosts : 정렬 옵션에 따라 게시물을 정렬하여 반환합니다.

```java
PostSpecifications.java

public class PostSpecifications {

    // Specification : Jpa에서 제공하는 검색기능을 구현하기 위한 인터페이스
    // 제목, 내용, 작성자 이름, 해시태그를 포함한 검색결과
    // keyword : 템플릿 Topview(네비게이션 바)에 포함되어있는 Form 내부의 input값
    public static Specification<PostEntity> searchAllWithHashtag(String keyword) {
        return new Specification<>() {
            @Override
            public Predicate toPredicate(Root<PostEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate hashtagPredicate = hasHashtag(keyword).toPredicate(root, query, criteriaBuilder);
                Predicate searchAllPredicate = searchAll(keyword).toPredicate(root, query, criteriaBuilder);

                // 검색 조건을 OR 연산하여 합침
                return criteriaBuilder.or(hashtagPredicate, searchAllPredicate);
            }
        };
    }

    // 해시태그 검색결과
    // hashtagName : searchAllWithHashtag 메서드의 keyword 값
    public static Specification<PostEntity> hasHashtag(String hashtagName){
        return new Specification<PostEntity>() {
            @Override
            public Predicate toPredicate(Root<PostEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<PostEntity, HashtagEntity> hashtagJoin = root.joinSet("hashtags", JoinType.INNER);
                return criteriaBuilder.equal(hashtagJoin.get("name"), hashtagName);
            }
        };
    }

    // 제목, 내용, 작성자 이름을 포함한 검색결과
    // keyword : searchAllWithHashtag 메서드의 keyword 값
    public static Specification<PostEntity> searchAll(String keyword) {
        return new Specification<>() {
            @Override
            public Predicate toPredicate(Root<PostEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.or(
                        criteriaBuilder.like(root.get("subject"), "%" + keyword + "%"),
                        criteriaBuilder.like(root.get("content"), "%" + keyword + "%"),
                        criteriaBuilder.like(root.get("userEntity").get("nickname"), "%" + keyword + "%")
                );
            }
        };
    }
}
```
> * 이 클래스는 JPA의 Specification을 사용하여 검색 조건을 생성하는 로직을 담당합니다. Specification은 JPA에서 쿼리를 동적으로 생성하기 위한 도구로 사용됩니다.
> * searchAllWithHashtag : 입력받은 검색어를 기반으로 해시태그 검색과 일반 텍스트 검색 조건을 생성하고 이들을 or 연산으로 합칩니다.
> * hasHashtag : 해시태그 검색을 위한 검색 조건을 생성합니다.
> * searchAll : 제목, 내용, 작성자 닉네임에 대한 검색 조건을 생성합니다.

<br/>

### 4. 결과물
<div display="inline">
        <img src="https://github.com/san3102/ArtGallery/assets/103571921/45b8f7c8-3791-4104-8a89-10e9c8a2c3c5" width="400px" height="200px" align></img>
        <img src="https://github.com/san3102/ArtGallery/assets/103571921/5a9d7007-18d6-4106-b9ed-31b8985060d1" width="400px" height="200px"></img>
        <img src="https://github.com/san3102/ArtGallery/assets/103571921/e37b8535-6108-4ec6-acbf-557d5d937269" width="400px" height="200px"></img>
        <img src="https://github.com/san3102/ArtGallery/assets/103571921/e51b3f23-a2d4-42cd-84cc-8cc44ee95ebb" width="400px" height="200px"></img>
        <img src="https://github.com/san3102/ArtGallery/assets/103571921/ff9d106b-bfe0-411c-a3d6-7469cc18707b" width="400px" height="200px"></img>
        <img src="https://github.com/san3102/ArtGallery/assets/103571921/5dc279f8-4505-4c3b-9139-4866d33452b3" width="400px" height="200px"></img>
        <img src="https://github.com/san3102/ArtGallery/assets/103571921/10252e86-8188-4ae2-a025-bb888a7bf501" width="400px" height="200px"></img>
</div>

<br/>

### 5. Trouble Shooting

#### 문제 현상

게시물 삭제 구현 후 동작했을 때 삭제한 게시물이 여전히 보이거나 데이터베이스에서 완전히 삭제되지 않는 현상이 발생.<br/>
어떠한 에러도 발생하지 않고 설계해둔 기능들은 정상적으로 작동되는 것처럼 보임.

#### 원인 분석

1. 해시태그 기능 추가 전 삭제기능을 구현했을 때는 게시물이 잘 삭제되었던 것을 기반으로 문제 원인은 HashtagEntity와 PostEntity의 연관관계에서 발생했다고 추측.
2. 연관된 엔티티 간의 연관 관계 설정이 올바르지 않아서 삭제가 제대로 이루어지지 않을 수 있기 때문에 데이터베이스 테이블의 연관관계를 검토.
3. 디버깅 모드와 테스트 함수를 실행하면서 두 엔티티의 관계가 잘 끊어지는지, 데이터는 정상적으로 도중에 누락되는 부분 없이 컨트롤러와 서비스클래스를 잘 순회하면서 구현한대로 흘러가는지 검토.

#### 문제 해결

강사님의 도움을 받아 문제의 원인은 PostEntity와 FileEntity 둘의 관계에서 cascade 영속성 전이 설정이 잘못되었다는 것을 알게 되어 아래와 같이 cascade 설정을 변경했습니다.

```java
PostEntity.java
...
    @OneToOne(cascade = CascadeType.ALL)
    private FileEntity fileEntity;
...

FileEntity.java
...
    @OneToOne(mappedBy = "fileEntity")
    private PostEntity postEntity;
...
```

#### 해결 후 원인 정리

수정하기 전 코드에서 문제가 발생하는 이유는 PostEntity 쪽에서는 fileEntity라는 필드로 FileEntity와의 관계를 맺고 있고, FileEntity 쪽에서는 postEntity라는 필드로 역방향 관계를 맺고 있습니다.<br/>
이런 상태에서 cascade = CascadeType.ALL을 FileEntity 쪽에 설정하면, FileEntity의 모든 변경 작업(생성, 수정, 삭제)에 대해서도 그와 연관된 PostEntity에 동일한 변경 작업이 자동으로 전파됩니다.<br/><br/>

이 설정이 문제가 되는 이유는 삭제 작업에서 발생합니다. 예를 들어 PostEntity를 삭제하려고 하면, 설정된 cascade에 따라 JPA는 PostEntity와 연관된 FileEntity도 함께 삭제하려고 시도하게 되고 동시에 FileEntity를 삭제하려고 하면 JPA는 FileEntity와 연관된 PostEntity도 함께 삭제하려고 시도합니다.<br/>
이 때 두 엔티티 간의 삭제가 서로를 무한 반복하게 되는 상황이 발생하게 되어 결국 순환 참조 문제로 이어집니다.<br/>
즉, PostEntity 삭제 시 FileEntity 삭제 → FileEntity 삭제 시 PostEntity 삭제 → PostEntity 삭제 시... 반복되는 루프로 인해 영원히 삭제 작업이 완료되지 않고 결국 예외가 발생하게 됩니다.<br/><br/>

예외가 발생했는데도 정상적으로 동작하는 것처럼 보였던 것도 예외처리를 제대로 처리해주지 않고 ajax 응답을 받으면 location.reload(); 설정해놓았기 때문에 페이지에서는 어떠한 응답이 오던지 처리성공 메시지와 함께 새로고침되어 정상적으로 동작하는것처럼 보였던 것입니다.<br/><br/>

이번 문제 해결 과정을 통해 중요한 경험을 얻게 되었습니다.<br/>
첫째, 문제의 원인을 너무 특정한 부분에 고정시켜놓고 사고하는 것은 해결 과정을 협소화시킬 수 있다는 것. 문제의 원인은 PostEntity와 FileEntity간의 관계문제였는데, HashtagEntity와 PostEntity의 관계문제만을 원인으로 생각하여 다른 곳의 문제를 생각하지 못했습니다.<br/>
둘째, 예외처리의 중요성을 명확히 깨달았습니다. 프로그래밍에서는 언제든지 예상치 못한 문제가 발생할 수 있기 때문에 미리 예외를 대비해야 함을 배웠습니다.<br/>


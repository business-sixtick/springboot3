# 스프링 부트 3 시작하기
- 스프링 프레임워크 2003년 6월에 등장
- 스프링 프레임워크의 설정이 매우 복잡하다는 단점을 극복하고자 2013년 4월에 부트 출시
- 부트는 WAS가 내장되어 있음.
- XML 설정을 자바코드로 할수 있음.
- 부트는 스프링에 속해있는 도구임. 스프링을 더 간편하게 해주는 도구임.

<br/>

### 제어의 역전 IoC
- Inversion of Control
- 객체를 직접 생성하지 않고 외부에서 관리하고 제공함

<br/>

### DI 의존성 주입 Dependency injection
- 제어의 역전 IoC를 구현하기 위해 쓰는 방법

<br/>

### 빈 
- 스프링 컨테이너에서 관리하는 객체

<br/>


### 관점 지향 프로그래밍 AOP : Aspect Oriented Programming
- 기능의 모듈화?

<br/>

### 이식 가능한 서비스 추상화 PSA : Portable Service Abstraction
- 인터페이스를 거친다는 얘기같음. 직접 객체를 작동시키는게 아니라 인터페이스를 작동시키고 그기에 연결된 객체가 최종적으로 작동하는 거임.

<br/>

### 정리하면 전체적인 틀을 잡고 틀은 건드리지 않고 외부에서 작동 시키거나 관리하는 거임. 대규모일수록 유지보수 비용이 적어짐

***
<br/>

# 스프링 부트 3 구조 이해하기
1. 컨트롤러 : 프리젠테이션 계층 (라우터)
2. 서비스 : 비지니스 계층 (비지니스 로직)
3. 리포지터리 : 퍼시스턴스 계층 (데이터베이스)

<br/>

### 디렉터리 구성
- main 폴더 : 실제 코드 작성 공간 (java, resource)
-   - resource : static(정적페이지, js, css), templetes(뷰와 관련된, 컴포넌트? 위젯?), application.yml (앱 내부에서 쓸 설정 정보)
- test 폴더 : 테스트 코드
- build.gradle : 빌드 설정
- settings.gradle : 프로젝트 정보

<br/>

### 참고
- www.w3schools.com/sql
- REST : Representational State Transfer. 자원을 어떻게 교환할지에 대한 규약. 그냥 웹 통신 ㅋ
- RESTful API : 설계할때 동사를 쓰지 않는다. 기본적으로 자원을 어떻게 한다의 행위가 내포되어있으므로 자원의 명칭만을 쓰는걸로 한다.
- HTTP : 메서드 GET 조회, POST 추가, PUT 수정, DELETE 삭제 : CRUD

<br/>

### 응답코드
- 200 ok
- 201 created : 요청이 성공적으로 수행되었고, 새로운 리소스가 생성되었음
- 400 bad request : 요청 값이 잘못되어 요청에 실패했음
- 403 forbidden : 권한이 없어 요청에 실패했음
- 404 not found : 요청 값으로 찾은 리소스가 없어 요청에 실패했음
- 500 internal sever error : 서버 상에 문제가 있어 요청에 실패했음

### 애너테이션 annotation
- @GetMapping : 조회
- @PostMapping : 컨트롤러 객체 안에 실행할 메서드에 붙임. 생성
- @Putmapping : 수정
- @DeleteMaping : 삭제
- @RestController : 컨트롤러 객체에 붙임. 응답을  json 형식으로 반환함
- @RequestBody : 매개변수에 붙임. 요청의 본문(아마 post 파라매터) 
- @AutoConfigureMockMvc : 테스트 객체에 붙임. 서버환경을 구성해줌
- @SpringBootTest : 테스트 객체에 붙임
- @PathVariable : 매개변수에 붙임. url 에서 변수명과 같은 값을 추출

### 템플릿 엔진
- jsp
- 타임리프 : 스프링 권장 템플릿. implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
- 프리마커
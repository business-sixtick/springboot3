# springboot3
스프링 부트3 학습하기
<br/>
<br/>
### 윈도우에 인텔리제이 설치하기
- [커뮤니티버전 다운로드](https://www.jetbrains.com/ko-kr/idea/download/download-thanks.html?platform=windows&code=IIC)
- 설치시에 PATH 등록 체크하기
- 학습 환경은 JDK 17로 한다. (프로젝트 생성시에 다운로드 및 선택 할 수 있다)
- 빌드 시스템은 gradle 을 쓴다. (스크립트 언어로는 groovy 를 쓴다. kotlin 도 있지만 groovy가 디폴트다.)
- 프로젝트 생성시에 고급설정에서 그룹ID를 설정하는데 org.example이 기본인데 배포할때 문제가 되므로 변경한다.
<br/>
<br/>
### 스프링부트3 프로젝트 설정하기
- src/build.gradle 을 연다
-

```
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.0'  // 추가
    id 'io.spring.dependency-management' version '1.1.0' // 추가
}

group = 'me.shinsunyoung'
version = '1.0-SNAPSHOT'
sourceCompatibility = '17' //추가

repositories {
    mavenCentral()
}

dependencies {
    //testImplementation platform('org.junit:junit-bom:5.10.0')
    //testImplementation 'org.junit.jupiter:junit-jupiter'
    implementation 'org.springframework.boot:spring-boot-starter-web' // 추가
    testImplementation 'org.springframework.boot:spring-boot-starter-test' // 추가
}

test {
    useJUnitPlatform()
}
```
- 고래 아이콘을 눌러서 새로고침(동기화) 를 해준다.
<br/>
<br/>
### 서버 구동하기
- src/main/java/패키지에 진입점(클래스)를 만들어준다

```
package me.shinsunyoung.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args) { // 부트 앱 진입점
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}
```

- resources/static/index.html 파일을 생성한다 (html5 치고 자동완성하면 html 기본 형태가 작성됨)
- 위에 작성한 클래스를 실행하고(서버켬) localhost:8080 로 접속해본다



<br/>
<br/>
### 포스트맨 설치하기 (api 테스트용 클라이언트)
- [포스트맨 다운로드](https://dl.pstmn.io/download/latest/win64)












package me.shinsunyoung.springbootdeveloper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void mockMvcSetup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @DisplayName("quiz() : GET /quiz?code=1 이면 응답 코드는 201, 응답 본문은 Created!를 리턴한다")
    @Test
    public void getQuiz1() throws Exception{
        // given  저장
        final  String url = "/quiz";
//        Member savedMember = memberRepository.save(new Member(1L, "홍길동"));

        // when 조회
        final ResultActions result = mockMvc.perform(get(url).param("code", "1"));

        //then 검증
        result.andExpect(status().isCreated())
                .andExpect(content().string("Created!")); // 201
    }

    @DisplayName("quiz() : GET /quiz?code=2 이면 응답 코드는 400, 응답 본문은 Bad Request!를 리턴한다")
    @Test
    public void getQuiz2() throws Exception{

        // given  저장
        final  String url = "/quiz";

        // when 조회
        final ResultActions result = mockMvc.perform(get(url).param("code", "2"));

        //then 검증
        result.andExpect(status().isBadRequest())
                .andExpect(content().string("Bad Request!")); // 400
    }

    @DisplayName("quiz() : POST /quiz?code=1 이면 응답 코드는 403, 응답 본문은 Forbidden!를 리턴한다")
    @Test
    public void postQuiz1() throws Exception{

        // given  저장
        final  String url = "/quiz";

        // when 조회
        final ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new QuizController.Code(1)))
        );

        //then 검증
        result.andExpect(status().isForbidden())
                .andExpect(content().string("Forbidden!")); // 403
    }

}
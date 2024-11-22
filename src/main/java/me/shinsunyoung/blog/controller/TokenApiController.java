package me.shinsunyoung.blog.controller;

import lombok.RequiredArgsConstructor;
import me.shinsunyoung.blog.dto.CreateAccessTokenRequest;
import me.shinsunyoung.blog.dto.CreateAccessTokenResponse;
import me.shinsunyoung.blog.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {
    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(
            @RequestBody CreateAccessTokenRequest request){
        try {
            String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());
            System.out.println(">>>>>>>>>>>>>> " + newAccessToken);
            return ResponseEntity.status(HttpStatus.CREATED).body(new CreateAccessTokenResponse(newAccessToken));
        } catch (Exception e) {
            System.out.println(">>>>>>>>>>>>>> " + e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }
}

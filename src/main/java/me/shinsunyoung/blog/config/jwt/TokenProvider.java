package me.shinsunyoung.blog.config.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import me.shinsunyoung.blog.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.thymeleaf.extras.springsecurity6.dialect.processor.AuthenticationAttrProcessor;

import java.time.Duration;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class TokenProvider {
    private final JwtProperties jwtProperties;

    public String generateToken(User user, Duration expiredAt){
        Date now = new Date();
        return makeToken(new Date(now.getTime() + expiredAt.toMillis()), user);
    }

    private String makeToken(Date expiry, User user){
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // 헤더 typ : JWT
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

    public boolean validToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).parseClaimsJwt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // TODO 하는중
//    public Authentication getAuthentication(String token){
//        Claims claims;
//    }





    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJwt(token)
                .getBody();
    }
}

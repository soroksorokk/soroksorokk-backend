package com.soroksorokk.soroksorokk.jwt;

import com.soroksorokk.soroksorokk.config.PropertyConfiguration;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TokenProviderTest {
    static final String AUTHORITIES_KEY = "auth";
    long tokenValidityInMilliseconds;
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);


    @BeforeEach
    public void setup() {
        this.tokenValidityInMilliseconds = 180000;
    }

    @Test
        void createToken() {
        // given
        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInMilliseconds);
        // when
        String jwtToken = Jwts.builder()
                .setSubject(String.valueOf(1L))
                .claim(AUTHORITIES_KEY, "ROLE_USER") // 정보 저장
                .signWith(key, SignatureAlgorithm.HS512) // 사용할 암호화 알고리즘과 , signature 에 들어갈 secret값 세팅
                .setExpiration(validity) // set Expire Time 해당 옵션 안넣으면 expire안함
                .compact();
        System.out.println(jwtToken);
        //then
        assertThat(jwtToken).isNotBlank();
        }
}
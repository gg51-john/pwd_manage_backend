package com.example.pwdmanage.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {
//    private final Key secretKey;
//    private final JwtParser jwtParser;
//    private final int accessTokenTtlSeconds;
//    private final AuthenticationProvider authenticationProvider;
//
//    public TokenService(Key jwtSecretKey, JwtParser jwtParser, int accessTokenTtlSeconds,
//                        AuthenticationProvider authenticationProvider) {
//        this.secretKey = jwtSecretKey;
//        this.jwtParser = jwtParser;
//        this.accessTokenTtlSeconds = accessTokenTtlSeconds;
//       this.authenticationProvider = authenticationProvider;
//    }

//    public String createAccessToken(String id) {
//        long expirationMillis = Instant.now()
//                .plusSeconds(accessTokenTtlSeconds)
//                .getEpochSecond()
//                * 1000;
//
//        Claims claims = Jwts.claims();
//        claims.setSubject("Access Token");
//        claims.setIssuedAt(new Date());
//        claims.setExpiration(new Date(expirationMillis));
//        claims.put("id", id);
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .signWith(secretKey)
//                .compact();
//    }
}

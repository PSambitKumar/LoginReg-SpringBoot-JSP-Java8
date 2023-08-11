package com.sambit.CompetitvePractice.Basic;

import com.sambit.JWT.JWTUtils;

import java.util.Base64;

/**
 * @Project : Registration
 * @Author : Sambit Kumar Pradhan
 * @Created On : 03/04/2023 - 11:41 AM
 */
public class JwtTokenGeneration {

    private JWTUtils jwtUtil;
    public String generateSecurityKey(String merchantName) {
        String[] jwtParts = jwtUtil.generateToken(merchantName).split("\\.");
        String payload = jwtParts[1];

        Base64.Decoder decoder = Base64.getDecoder();
        String decodedPayload = new String(decoder.decode(payload));

        System.out.println(decodedPayload);

        String sharedSecret = decodedPayload.substring(decodedPayload.indexOf("sharedSecret") + 15, decodedPayload.indexOf("sharedSecret") + 47);
        System.out.println(sharedSecret);

        Base64.Encoder encoder = Base64.getEncoder();
        String encodedPayload = encoder.encodeToString(decodedPayload.getBytes());

        String encodedJWT = jwtParts[0] + "." + encodedPayload + "." + jwtParts[2];
        System.out.println(encodedJWT);

        return jwtUtil.generateToken(merchantName);
    }
}

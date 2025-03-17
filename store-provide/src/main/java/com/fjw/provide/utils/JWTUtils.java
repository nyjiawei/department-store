package com.fjw.provide.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fjw.provide.common.model.UserInfo;
import com.fjw.provide.model.User;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jiawe
 * @description JWT工具
 * @date 2019/6/8
 */
@Slf4j
public class JWTUtils {

    //过期时间设置为30分钟
    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    //token私钥(这里选用的是一个UUID)
    private static final String TOKEN_SECRET = "02ace2efd64147e8b60f9e734d09eb64";

    private JWTUtils(){}

    /**
     * 生成token
     * @param user 用户
     * @return 加密的token
     */
    public static String createToken (User user) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //
            return JWT.create()
                    .withHeader(header)
                    .withClaim("username",user.getUsername())
                    .withClaim("id",user.getId())
                    .withClaim("nick",user.getNick())
                    .withClaim("userRoleId",user.getUserRoleId())
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 校验token是否正确
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }

    /**
     * 从token获取用户信息，无需解密
     * @param token
     * @return token中包含的对象
     */
    public static UserInfo getUserInfoByToken(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            UserInfo userInfo = new UserInfo();
            userInfo.setId(jwt.getClaim("id").asLong());
            userInfo.setUsername(jwt.getClaim("username").asString());
            userInfo.setNick(jwt.getClaim("nick").asString());
            userInfo.setRoleId(jwt.getClaim("userRoleId").asInt());
            return userInfo;
        } catch (JWTDecodeException e) {
            log.error("令牌解析异常：{}",e.getMessage(),e);
            return null;
        }
    }


}

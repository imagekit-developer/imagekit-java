package io.imagekit.sdk.tasks;

import org.apache.commons.codec.digest.HmacUtils;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;

public class Calculation {
    private static final int DEFAULT_TIME_DIFF = 60 * 30;

    public static Map<String, String> getAuthenticatedParams(String token, long expire, String privateKey){
        if (token==null){
            token= UUID.randomUUID().toString();
        }
        if (expire==0){
            expire= Calendar.getInstance().getTimeInMillis()+DEFAULT_TIME_DIFF;
        }
        if (privateKey==null) throw new RuntimeException("Private key can't be null.");

        String signature = HmacUtils.hmacSha1Hex(privateKey, token + expire);

        Map<String, String> auth=new HashMap<>();
        auth.put("token",token);
        auth.put("expire", String.valueOf(expire));
        auth.put("signature",signature);
        return auth;
    }

    public static int getHammingDistance(String firstHex, String secondHex){
        if (!(isValidHex(firstHex) && isValidHex(secondHex))){
            throw new RuntimeException("Both argument should be hexadecimal.");
        }
        if (firstHex.length()!=secondHex.length()) throw new RuntimeException("Both argument are not equal in length.");

        BigInteger xor = new BigInteger(firstHex, 16).xor(new BigInteger(secondHex, 16));

        int count=0;
        for(int i = 0; i < xor.toString(2).length(); i++) {
            if (xor.toString(2).charAt(i)=='1'){
                count+=1;
            }
        }
        return count;
    }

    static boolean isValidHex(String hex){
        return Pattern.matches("^[0-9a-fA-F]+$",hex);
    }
}

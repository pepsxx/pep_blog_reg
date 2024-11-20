package ru.pepsxx.pep_blog_reg.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

@UtilityClass
public class HashCodeUtil {

    @SneakyThrows
    public String getSHA256Hash(String input) {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(bytes);

    }
}

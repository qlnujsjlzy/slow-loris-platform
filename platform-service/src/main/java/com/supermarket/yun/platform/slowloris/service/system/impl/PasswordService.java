package com.supermarket.yun.platform.slowloris.service.system.impl;

import com.supermarket.yun.platform.slowloris.domain.system.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/22 0:11
 */
@Service("passwordService")
public class PasswordService {

    @Value(value = "${shiro.credentials.hashIterations}")
    private final int hashIterations = 2;
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    @Value(value = "${shiro.credentials.hashAlgorithmName}")
    private String algorithmName = "md5";

    public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
        user.setPassword(newPassword);
    }
}

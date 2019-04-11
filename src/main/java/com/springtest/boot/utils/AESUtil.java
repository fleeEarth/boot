package com.springtest.boot.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

/**
 * @Author: zh
 * @Date: 2019/4/11 14:18
 */
public class AESUtil {

	public static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS7Padding";

	public static final String ENCODING   = "UTF8";

	public static String decrypt(String text,String key,String iv){
		try{

			//密钥
			byte[] raw = key.getBytes(ENCODING);
			SecretKeySpec skey = new SecretKeySpec(raw, "AES");
			IvParameterSpec ivp = new IvParameterSpec(iv.getBytes(ENCODING));
			//添加Cipher对PKCS7Padding的支持
			Security.addProvider(new BouncyCastleProvider());
			Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE,skey,ivp);
			byte[] pwd = new BASE64Decoder().decodeBuffer(text);
			return  new String(cipher.doFinal(pwd), ENCODING);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return "error";
		}
	}
}

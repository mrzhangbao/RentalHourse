package com.jiaxin.utils.smsutil;

import java.util.Random;

/**
 * 产生一个六位数的随机数当作验证码
 * @author Benson_Tom
 *
 */
public class RandomCode {
	
	
	public static int getRandomCode(){
		return new Random().nextInt(899999)+100000;
	}

}

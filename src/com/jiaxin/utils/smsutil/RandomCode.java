package com.jiaxin.utils.smsutil;

import java.util.Random;

/**
 * ����һ����λ���������������֤��
 * @author Benson_Tom
 *
 */
public class RandomCode {
	
	
	public static int getRandomCode(){
		return new Random().nextInt(899999)+100000;
	}

}

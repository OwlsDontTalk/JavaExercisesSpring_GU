package com.owlsdonttalk;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class Lesson04SpringBootApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void telToMd5() throws NoSuchAlgorithmException, IOException {
//		BufferedReader reader = new BufferedReader(new FileReader("1.csv"));
//		FileWriter writer = new FileWriter("1-out.csv");
//		writer.append("Mobile;md5\n");
//		writer.flush();
//		String row;
//
//		int i = 0;
//		while ( (row = reader.readLine()) != null) {
//			++i;
//			String[] data0 = row.split(",");
//			String s = data0[0];
//			MessageDigest m = MessageDigest.getInstance("MD5");
//			byte[] data = s.getBytes();
//			m.update(data,0,data.length);
//			BigInteger i0 = new BigInteger(1,m.digest());
//			String md5 = String.format("%1$032X", i0);
//
//			System.out.println(i + " " + s + " " + md5);
//			writer.append(s+";"+md5+"\n");
//
//		}
//
//		writer.close();

	}

}

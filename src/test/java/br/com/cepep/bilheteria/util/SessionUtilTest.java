package br.com.cepep.bilheteria.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SessionUtilTest {

	@Test
	public void testaHashMD5() {
		String adminEmMD5 = "admin";
		String java = "java";
		String md5 = "md5";
		String hash = SessionUtil.converteParaMD5(adminEmMD5);
		java = SessionUtil.converteParaMD5(java);
		md5 = SessionUtil.converteParaMD5(md5);
		
		System.out.println("Teste admin: " + hash);
		System.out.println("Teste java: " + java);
		System.out.println("Teste md5: " + md5);
		
		assertEquals(32, hash.length());
		assertEquals(32, java.length());
		assertEquals(32, md5.length());
	}

}

package xiaoxi.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import xiaoxi.ops.VerificateExtractor;

public class VerificateExtractorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExtractVerifcateCode() {
		String content = ",d,x,abcA123,.x2,.x;a\n.ab";
		String code = VerificateExtractor.extractVerifcateCode(content);
		assertEquals("abcA123",code);
	}

}

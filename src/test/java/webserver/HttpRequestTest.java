package webserver;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import static org.junit.Assert.*;

public class HttpRequestTest {
	private String testDir = "./src/test/resources/";

	@Test
	public void request_GET() throws Exception {
		InputStream in = new FileInputStream(new File(testDir + "Http_GET.txt"));
		HttpRequest request = new HttpRequest(in);

		assertEquals(HttpMethod.GET, request.getMethod());
		assertEquals("/user/create", request.getPath());
		assertEquals("keep-alive", request.getHeader("Connection"));
		assertEquals("mhjin", request.getParameter("userId"));
	}

	@Test
	public void request_POST() throws Exception {
		InputStream in = new FileInputStream(new File(testDir + "Http_POST.txt"));
		HttpRequest request = new HttpRequest(in);

		assertEquals(HttpMethod.POST, request.getMethod());
		assertEquals("/user/create", request.getPath());
		assertEquals("keep-alive", request.getHeader("Connection"));
		assertEquals("mhjin", request.getParameter("userId"));
	}
}

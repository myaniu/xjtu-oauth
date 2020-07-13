package cn.edu.xjtu.oauth.kit;

import java.io.File;
import java.util.Map;
import java.util.UUID;

public class HttpKit {
	private static final int DEFAULT_TIMEOUT = 3 * 1000;
	private static final int DEFAULT_READ_TIMEOUT = 6 * 1000;
	private static final int DEFAULT_DOWN_TIMEOUT = 60 * 1000;
	private static final String DEFAULT_CHARSET =  HttpRequest.CHARSET_UTF8;

	private HttpKit() {
	}

	public static String post(String url, Map<String, ?> params) {
		return post(url,params, null);
	}
	
	public static String post(String url, Map<String, ?> params, Map<String, String> headers) {
		try {
			HttpRequest request = HttpRequest.post(url)
					.connectTimeout(DEFAULT_TIMEOUT)
					.readTimeout(DEFAULT_READ_TIMEOUT)
					.contentType(HttpRequest.CONTENT_TYPE_FORM)
					.form(params, DEFAULT_CHARSET);
			if(headers != null && headers.size() > 0) {
				request.headers(headers);
			}
			return request.body(DEFAULT_CHARSET);
		}catch(Exception e) {
			return null;
		}
	}
	
	public static File postJsonDownload(String url, String json) {
		try {
			HttpRequest request = HttpRequest.post(url)
					.connectTimeout(DEFAULT_TIMEOUT)
					.readTimeout(DEFAULT_DOWN_TIMEOUT)
					.contentType(HttpRequest.CONTENT_TYPE_FORM)
					.contentType(HttpRequest.CONTENT_TYPE_JSON)
					.send(json);
			File tmp = File.createTempFile(UUID.randomUUID().toString(), ".tmp");
			request.receive(tmp);
			return tmp;
		}catch(Exception e) {
			return null;
		}
	}
	
	public static String postJson(String url, String json) {
		try {
			HttpRequest request = HttpRequest.post(url)
					.connectTimeout(DEFAULT_TIMEOUT)
					.readTimeout(DEFAULT_READ_TIMEOUT)
					.contentType(HttpRequest.CONTENT_TYPE_JSON)
					.send(json);
			return request.body(DEFAULT_CHARSET);
		}catch(Exception e) {
			return null;
		}
	}
	
	public static String get(String url) {
		return get(url,null);
	}
	
	public static String get(String url, Map<String, String> headers) {
		try {
			HttpRequest request = HttpRequest.get(url)
					.connectTimeout(DEFAULT_TIMEOUT)
					.readTimeout(DEFAULT_READ_TIMEOUT);
			if(headers != null && headers.size() > 0) {
				request.headers(headers);
			}
			return request.body(HttpRequest.CHARSET_UTF8);
		}catch(Exception e) {
			return null;
		}
	}
}

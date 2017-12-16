package org.egateway.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://wwww.baidu.com");
		URLConnection conn = url.openConnection();
		conn.setRequestProperty("accept", "*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // 发送POST请求必须设置如下两行
        conn.setDoOutput(true);
        conn.setDoInput(true);
        // 获取URLConnection对象对应的输出流
        PrintWriter out = new PrintWriter(conn.getOutputStream());
        out.println("");
        out.flush();
        String result = "";
        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        System.out.println(result);
        System.out.println("======");
        result = "";
        
        out.println("");
        out.flush();
        in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        while ((line = in.readLine()) != null) {
            result += line;
        }
        System.out.println(result);
	}
}

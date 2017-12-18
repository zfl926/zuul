package org.egateway.core;

public class HttpClient {
//	private static ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//        @Override
//        public String handleResponse(
//                final HttpResponse response) throws ClientProtocolException, IOException {
//                HttpEntity entity = response.getEntity();
//                return entity != null ? EntityUtils.toString(entity) : null;
//
//        }
//
//    };
//
//    public static String Get(CloseableHttpClient http, String url){
//        HttpGet httpget = new HttpGet(url);
//        System.out.println("Executing request " + httpget.getRequestLine());
//        String html = "";
//
//        try{
//            html = http.execute(httpget, responseHandler);
//            
//        } catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//        }
//        System.out.println(html);
//        return html;
//    }
//
//    public static void main(String[] args) throws Exception {
//        CloseableHttpClient http = HttpClients.createSystem();
//        String url1 = "http://localhost:8081/myapp/myServlet";
//        String url2 = "http://localhost:8081/test";
//        try {
//            Get(http, url2);
//            Get(http, url1);
//            Get(http, url2);
//        } finally {
//            http.close();
//        }
//    }	
	
	
}

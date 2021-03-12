import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Task2 {

    private String url = "www.metaweather.com";

    public void WeatherP(String param, String value) throws IOException, URISyntaxException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        URIBuilder builder = new URIBuilder();
        builder.setScheme("https")
                .setHost("www.metaweather.com")
                .setPath("/api/location/search")
                .setParameter(param, value);
        URI uri = builder.build();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        System.out.println("Status code: " + response.getStatusLine().getStatusCode());
        System.out.println("Reason phrase: " + response.getStatusLine().getReasonPhrase());
        for (Header header : response.getAllHeaders()) {
            System.out.println(header.getName() + ": " + header.getValue());
        }

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String data = IOUtils.toString(entity.getContent(), "utf8");
            System.out.println("Data: " + data);
        } else {
            System.out.println("Empty responce");
        }
    }
}


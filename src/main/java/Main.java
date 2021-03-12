import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {

        Task2 task2 = new Task2();
        Scanner in2 = new Scanner(System.in);

        System.out.println("Enter parametr (query or lattlong");
        String param = in2.next();
        System.out.println("Enter value");
        String value = in2.next();

        task2.WeatherP(param, value);

        Task1 task1 = new Task1();
        Scanner in1 = new Scanner(System.in);
        System.out.println("Q - 1, LL - 2, exit - 3");
        int num = in1.nextInt();

        switch (num){
            case 1:
                task1.WeatherQ("Kharkiv");
                break;
            case 2:
                task1.WeatherLL("36.96,-122.02");
                break;
            case 3:
                break;
        }
        /*String url = "https://github.com";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);

        System.out.println("Status code: " + response.getStatusLine().getStatusCode());
        System.out.println("Reason phrase: " + response.getStatusLine().getReasonPhrase());
        for (Header header: response.getAllHeaders()){
            System.out.println(header.getName() + ": " + header.getValue());
        }

        HttpEntity entity = response.getEntity();
        if (entity!= null){
            String data = IOUtils.toString(entity.getContent(), "utf8");
            System.out.println("Data: " + data);
        } else {
            System.out.println("Empty responce");
        }*/
    }
}

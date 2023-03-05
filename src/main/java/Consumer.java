import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://reqres.in/api/users/2";
        String response = restTemplate.getForObject(url, String.class);

        System.out.println(response);

        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "TestName");
        jsonToSend.put("job", "TestJob");

        HttpEntity<Map<String, String>> request  = new HttpEntity<>(jsonToSend);

        String url2 = "https://reqres.in/api/users";
        String response2 = restTemplate.postForObject(url2, request, String.class);

        System.out.println(response2);





    }



}

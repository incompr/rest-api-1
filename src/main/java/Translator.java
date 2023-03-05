import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Bsequte npepnoxeHve Ha pyCCKOM A3bike:");
        Scanner scanner = new Scanner(System.in);
        String sentenceToTranslate = scanner.nextLine();

        RestTemplate restTemplate = new RestTemplate();

        String url = "https://translate.api.cloud.yandex.net/tranflate/v2/translate";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + "t1.9euelZrKicjJzc7Mz56Szcébyp");

        Map<String, String> jsonData = new HashMap<>();
        jsonData.put("folderId", "bige46fc2qis4gcejuen");
        jsonData.put("targetLanguageCode", "en");
        jsonData.put("texts", "[" + sentenceToTranslate + "]");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonData, headers);

      //  String response = restTemplate.postForObject(url, request, String.class);
       YandexResponse response = restTemplate.postForObject(url, request, YandexResponse.class);

        System.out.println(response);

        //Парсим полученный джейсон
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode obj = mapper.readTree(response);
//        System.out.println(("Translation: " + obj.get("translations").get(0).get("text")));
        System.out.println("Translation: " + response.getTranslations().get(0).getText());

    }
}

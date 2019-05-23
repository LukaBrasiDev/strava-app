package pl.lukabrasi.stravaapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StravaService {

    @Value("${api.clientsecret.key}")
    public String clientSecret;

    @Value("${api.clientid.key}")
    public String clientId;

    public String redirectUri = "http://localhost:8080/";


    public String getAuthenticate() {
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://www.strava.com/oauth/authorize/?client_id=" + clientId + "&redirect_uri=" + redirectUri + "&redirect_uri=" + redirectUri + "&response_type=code&approval_prompt=auto&scope=activity:read";

        String accountDto = restTemplate.getForObject(url, String.class);
        System.out.println(accountDto);
        return accountDto;
    }



    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }



}

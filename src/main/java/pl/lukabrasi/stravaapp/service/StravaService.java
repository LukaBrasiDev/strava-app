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

    public String redirectUri = "http://strava.com";


    public String getAuthenticate() {
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://www.strava.com/oauth/authorize/?client_id=" + clientId + "&response_type=code&redirect_uri=" + redirectUri + "&approval_prompt=force";
        String accountDto = restTemplate.getForObject(url, String.class);
        return accountDto;
    }

    public String getAuthenticate2() {
        RestTemplate restTemplate = getRestTemplate();
        String url = "https://www.strava.com/oauth/authorize/?client_id=" + clientId + "&redirect_uri=" + redirectUri + "&response_type=code&scope=read";
        String accountDto = restTemplate.getForObject(url, String.class);
        return accountDto;
    }



    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }



}

package com.bills_user.bills_user_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class RestService {
    private static final Logger logger = LoggerFactory.getLogger(RestService.class);
    private final String ticketGenAppUrl = "http://localhost:8080/ticket-generator";//System.getenv("TicketGenURL");
    public List<Integer> generateTickets(Integer event_id, Integer amount, Integer user_id){
        RestTemplate restTemplate = new RestTemplate();

        URI uri = UriComponentsBuilder.fromHttpUrl(ticketGenAppUrl)
                .path("/gen")
                .queryParam("event_id",event_id)
                .queryParam("amount", amount)
                .queryParam("user_id", user_id)
                .build()
                .toUri();

        logger.info(String.valueOf(uri));

        try {
            ParameterizedTypeReference <List<Integer>> responseType = new ParameterizedTypeReference<>() {};
            ResponseEntity<List<Integer>> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    responseType);
            return response.getBody();
        }
        catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return null;
    }
}

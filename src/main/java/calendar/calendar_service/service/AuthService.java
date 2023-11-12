package calendar.calendar_service.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    public boolean authenticate(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("jwt-auth-token", token);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(null, headers);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://sac.prod.cluster.yanychoi.com/api/auth/user/authenticate",
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getStatusCode().is2xxSuccessful();
    }
}

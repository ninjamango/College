package com.example.college.COLLEGE;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;
import org.springframework.web.reactive.function.client.*;

import java.util.*;

@RestController
@RequestMapping("/api/")
public class Controller {

   @Autowired
   private  WebClient.Builder webClientBuilder;
    private final collegeService service;

    public Controller(collegeService service, RestTemplate restTemplate) {
        this.service = service;
        this.webClientBuilder = webClientBuilder;
    }

    @PostMapping("/college")
    public collegeModel addCollege(@RequestBody collegeModel college) {
        return service.insertCollege(college);

    }

    @PostMapping("/population")
    public Integer findPopulation(@RequestBody collegeModel college) {

          String baseUrl = "http://localhost:8081/api/findpopulation?country=" + college.getCountry();

//        String baseUrl = "localhost:8081/api/findpopulation";
//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> requestEntity = new HttpEntity<>(jsonPayload, headers);
//
//        restTemplate.get
//
//        ResponseEntity<Integer> response = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, Integer.class);
//
//        Integer responseBody = response.getBody();


      int value =  webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/findpopulation?country=" + college.getCountry())
                .retrieve()
                .bodyToMono(Integer.class )
                .block();

       return value;




//
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//        HttpEntity <collegeModel> requestEntity = new HttpEntity<collegeModel>(college,headers);
//
//        ResponseEntity<Integer> response =  restTemplate.exchange(baseUrl, HttpMethod.GET, requestEntity, Integer.class);
//
//        return response.getBody();
//       //this is webclient version ...
    }

}

package com.example.clienttest.Sensor;

import com.example.clienttest.Pojo.PojoTemperature;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.Date;

public class TemperatureThread extends Thread {

    @Override
    public void run ( ) {
        try {
            while (true){
                Thread.sleep (1000);
                TestRestTemplate restTemplate = new TestRestTemplate ( );

                HttpHeaders headers = new HttpHeaders ( );
                headers.setContentType (MediaType.APPLICATION_JSON);
                headers.add ("Accept", MediaType.APPLICATION_JSON.toString ( ));

                PojoTemperature demo = new PojoTemperature( );
                demo.setId(1);
                demo.setText ("температура");
                demo.setTag ("коридор");
                demo.setInd (1+(int) (Math.random ( ) * 20));
                demo.setLocalTime(new Date());
                demo.setLocalDate(new Date());
                HttpEntity formEntity = new HttpEntity<> (demo, headers);

               restTemplate.put ("http://localhost:8090/api/temperatures", formEntity);
                ResponseEntity<String> response = restTemplate
                        .postForEntity ("http://localhost:8090/api/temperatures", formEntity, String.class);
                System.out.println ();
            }
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        } catch (RestClientException e) {
            e.printStackTrace ( );
        }
    }
}

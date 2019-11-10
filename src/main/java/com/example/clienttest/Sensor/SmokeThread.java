package com.example.clienttest.Sensor;

import com.example.clienttest.Pojo.PojoSmoke;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.Date;

public class SmokeThread  extends Thread {

    @Override
    public void run (){

        try {
            Smoke1 ( );
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        } catch (
                RestClientException e) {
            e.printStackTrace ( );
        }
    }

    private void Smoke1 () throws InterruptedException{
        while (true){
            Thread.sleep (3000);
            TestRestTemplate restTemplate = new TestRestTemplate ( );

            HttpHeaders headers = new HttpHeaders ( );
            headers.setContentType (MediaType.APPLICATION_JSON);
            headers.add ("Accept", MediaType.APPLICATION_JSON.toString ( ));

            PojoSmoke demo = new PojoSmoke ( );
            demo.setId(2);
            demo.setIp ("анализатор дыма");
            demo.setLocation ("кухня");
            demo.setValue (15+(int) (Math.random ( ) * 20));
            demo.setLocalTime(new Date());
            demo.setLocalDate(new Date());

            HttpEntity formEntity = new HttpEntity<> (demo, headers);

            restTemplate.put ("http://localhost:8090/api/smokes", formEntity);

            ResponseEntity<String> response = restTemplate
                    .postForEntity ("http://localhost:8090/api/smokes", formEntity, String.class);
            System.out.println (response);
        }
    }
}

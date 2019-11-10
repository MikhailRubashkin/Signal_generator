package com.example.clienttest.Sensor;


import com.example.clienttest.Pojo.PojoTemperature;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TemperatureThreadTest {
    @Test
    public void testRun() {
        try {
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

            Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
            Assert.assertNotNull(response);



        } catch (InterruptedException e) {
            e.printStackTrace ( );
        } catch (RestClientException e) {
            e.printStackTrace ( );
        }
    }
}

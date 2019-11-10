package com.example.clienttest.Sensor

import com.example.clienttest.Pojo.PojoSmoke
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.client.RestClientException

@RunWith(SpringRunner.class)
@SpringBootTest
class SmokeThreadTest extends GroovyTestCase {

    @Test
    void testRun() {
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

        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assert.assertNotNull(response);
    }
    }


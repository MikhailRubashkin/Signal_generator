package com.example.clienttest;

import com.example.clienttest.Sensor.SmokeThread;
import com.example.clienttest.Sensor.TemperatureThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ClienttestApplication  {

    static SmokeThread smokeThread;
    static TemperatureThread temperatureThread;

    public static void main ( String[] args ){
        SpringApplication.run (ClienttestApplication.class, args);

        temperatureThread = new TemperatureThread ();            //Создание потока
        smokeThread = new SmokeThread ();
        smokeThread.start ();
        temperatureThread.start();

    }
}

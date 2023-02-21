package com.baidu.kafka;

import net.sf.json.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import java.io.IOException;

@SpringBootApplication
public class SpringBootKafkaApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringBootKafkaApplication.class,args);
        System.in.read();
    }

    @KafkaListeners(value = {
            @KafkaListener(topics = {"topic01"})
    })
    public void receive01(String records){
        System.out.println(records);
    }

    //topic 02接收的数据发送到topic03
    @KafkaListeners(value = {
            @KafkaListener(topics = {"topic02"})
    })
    @SendTo("topic03")
    public String receive02(String records){
        return records+"topic03发送的数据";
    }
}

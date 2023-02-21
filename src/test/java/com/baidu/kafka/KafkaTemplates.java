package com.baidu.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {SpringBootKafkaApplication.class})
@RunWith(SpringRunner.class)
public class KafkaTemplates {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    //生产
    @Test
    public void testMessage(){
         this.kafkaTemplate.send(new ProducerRecord<>("topic02","key1","this is springbootTest method template"));
    }
}

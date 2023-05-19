package customEx;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import serializer.KafkaJsonSerializer;
import vo.TransectionOfBlock;

import java.util.Properties;

public class ProducerCustom {
    private final static String TOPIC_NAME = "hello.kafka";
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";

    public static void main(String[] args) {

        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class.getName());



        KafkaProducer<String, TransectionOfBlock> producer = new KafkaProducer<>(configs);

        TransectionOfBlock vo = TransectionOfBlock.builder()
                .transactionHash("qwe121asd3144qwe")
                .block("1000")
                .fromAddr("jin")
                .toAddr("mong")
                .volume("2345")
                .gasPrice("1.1")
                .tokenContractAddr("BIO")
                .timeStamp("2023-05-20 23:00:01")
                .build();

        ProducerRecord<String, TransectionOfBlock> record = new ProducerRecord<>(TOPIC_NAME, "k1", vo);
        producer.send(record);

        producer.flush();
        producer.close();
    }
}
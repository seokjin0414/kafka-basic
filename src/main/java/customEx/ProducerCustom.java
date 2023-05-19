package customEx;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import serializer.KafkaJsonSerializer;
import vo.TxOfBlock;

import java.util.Properties;

public class ProducerCustom {
    private final static String TOPIC_NAME = "hello.kafka";
    private final static String BOOTSTRAP_SERVERS = "my-kafka:9092";

    public static void main(String[] args) {

        Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaJsonSerializer.class.getName());

        KafkaProducer<String, TxOfBlock> producer = new KafkaProducer<>(configs);

        TxOfBlock vo = new TxOfBlock();
        vo.setTransactionHash("qwe121asd3144qwe");
        vo.setBlock("13245151345");
        vo.setFromAddr("jin");
        vo.setToAddr("mong");
        vo.setVolume("79976234");
        vo.setGasPrice("1.1");
        vo.setTokenContractAddr("BIO");
        vo.setTimeStamp("2023-05-20 23:00:01");

        ProducerRecord<String, TxOfBlock> record = new ProducerRecord<>(TOPIC_NAME, "BIO", vo);
        producer.send(record);

        producer.flush();
        producer.close();
    }
}
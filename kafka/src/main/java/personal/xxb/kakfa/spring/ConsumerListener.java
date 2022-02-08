package personal.xxb.kakfa.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsumerListener {

    @KafkaListener(topics = "quickstart-events", groupId = "group0")
    public void onMessage(String msg){
        log.info("................收到消息{}", msg);
    }

}

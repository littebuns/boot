package personal.xxb.kakfa.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import personal.xxb.kakfa.stream.util.BeanUtil;

@Slf4j
@Component
@EnableBinding({Sink.class,MyProcessor.class})
public class JsonMessageListener {


    @Autowired
    private MyProcessor myProcessor;

    /**
     * 消息中转站
     * 消费 input 通道的数据，处理后通过 msg_output 通道发送出去
     * @param msg
     * @return
     */
    @StreamListener(Sink.INPUT)
    public void onMessage(String msg){
        log.info("json收到原始消息:{} ", msg);
        myProcessor.jsonMsgOutput().send(MessageBuilder.withPayload(msg).build());
    }

    /**
     * 消费 out_put 通道的数据
     */
    @StreamListener(MyProcessor.JSON_MESSAGE_INPUT)
    public void onMessageInput(String msg) {
        log.info("json收到 msg_input 通道被加工过的字节{}", msg);
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(msg, User.class);
        } catch (JsonProcessingException e) {

        }
        System.out.println(user);

    }



}

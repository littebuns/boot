package personal.xxb.kakfa.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import personal.xxb.kakfa.stream.util.BeanUtil;

@Slf4j
@Component
@EnableBinding({Sink.class,MyProcessor.class})
public class MessageListener {

    @Autowired
    private MyProcessor myProcessor;

    /**
     * 消息中转站
     * 消费 input 通道的数据，处理后通过 msg_output 通道发送出去
     * @param msg
     * @return
     */
    @StreamListener(Sink.INPUT)
//    @SendTo(MyProcessor.MESSAGE_OUTPUT)
    public void onMessage(String msg){
        log.info("收到原始消息:{} ", msg);
        myProcessor.msgOutput().send(MessageBuilder.withPayload(BeanUtil.serializeToBytes(msg)).build());
    }

    /**
     * 消费 out_put 通道的数据
     * @param bytes 字节数组
     */
    @StreamListener(MyProcessor.MESSAGE_INPUT)
    public void onMessageInput(byte[] bytes) {
        log.info("收到 msg_input 通道被加工过的字节{}", bytes);
        Object obj = BeanUtil.deserializeFromBytes(bytes);
        System.out.println(obj.getClass());
    }



}

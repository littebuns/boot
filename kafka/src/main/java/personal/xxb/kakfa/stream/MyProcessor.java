package personal.xxb.kakfa.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface MyProcessor {

    String MESSAGE_OUTPUT = "msg_output";

    String MESSAGE_INPUT = "msg_input";

    String JSON_MESSAGE_INPUT = "json_msg_input";

    String JSON_MESSAGE_OUTPUT = "json_msg_output";

    @Input("msg_input")
    SubscribableChannel msgInput();

    @Output("msg_output")
    MessageChannel msgOutput();

    @Input("json_msg_input")
    SubscribableChannel jsonMsgInput();

    @Output("json_msg_output")
    MessageChannel jsonMsgOutput();


}

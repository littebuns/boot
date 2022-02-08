package personal.xxb.kakfa.stream;

import org.apache.kafka.common.network.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

    @Autowired
    private SendService sendService;

    @GetMapping("/send/{msg}")
    public void send(@PathVariable("msg") String msg){
        sendService.sendMsg(msg);
    }

}

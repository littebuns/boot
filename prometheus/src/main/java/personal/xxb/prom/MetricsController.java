package personal.xxb.prom;

import io.prometheus.client.Collector;
import io.prometheus.client.CollectorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetricsController {

    @Autowired
    private MyCustomCollector customCollector;

    @GetMapping("/metrics")
    public List<Collector.MetricFamilySamples> test(){
        System.out.println("hello");
        Collector collector = customCollector.register(CollectorRegistry.defaultRegistry);
        return collector.collect();
    }

}

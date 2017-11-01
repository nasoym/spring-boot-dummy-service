package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Vector;

@SpringBootApplication
@RestController
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/")
    public String home() {
        LOGGER.info("request: /");
        return "Hello Docker World";
    }

    @RequestMapping("/createstring")
    public String createstring() {
        for(int i=0;i<=1000;i++) {
          String foo = new String("new String");
        }
        return "ok";
    }

    @RequestMapping("/memory_usage")
    public String memory_usage(@RequestParam("usage") int mb_usage) {
        Vector v = new Vector();
        for(int i=0; i<mb_usage; i++) {
          byte[] bytes = new byte[1024*1024];
          bytes[0] = 0;
          bytes[1] = 0;
          bytes[2] = 0;
          v.add(bytes);
        }
        return "ok";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

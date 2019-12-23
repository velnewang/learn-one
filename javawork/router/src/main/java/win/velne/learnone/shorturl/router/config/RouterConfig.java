package win.velne.learnone.shorturl.router.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "r")
public class RouterConfig {

    private List<String> listProp = new ArrayList<String>();

    public List<String> getListProp() {
        return listProp;
    }

    public void setListProp(List<String> listProp) {
        this.listProp = listProp;
    }

}

package GasStationsAPI.GasStationsAPI.config;

import GasStationsAPI.GasStationsAPI.client.StationClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient stationWebClient() {
        return WebClient
                .builder()
                .build();
    }

    @Bean
    public StationClient stationClient() {
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(stationWebClient()))
                .build();

        return proxyFactory.createClient(StationClient.class);
    }
}

package cl.indecon.config;

import cl.indecon.Constants;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;

@Configuration
public class RestTemplateConfiguration {

    private static final int TIME_OUT = 26000;

    @Bean(Constants.REST_TEMPLATE_WITHOUT_CERT)
    public RestTemplate restTemplateWithoutCert(RestTemplateBuilder builder) {
        try {

            TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
            SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                    .loadTrustMaterial(null, acceptingTrustStrategy)
                    .build();

            SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

            CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLSocketFactory(csf)
                    .build();

            HttpComponentsClientHttpRequestFactory requestFactory =
                    new HttpComponentsClientHttpRequestFactory();
            requestFactory.setConnectTimeout(TIME_OUT);
            requestFactory.setReadTimeout(TIME_OUT);
            requestFactory.setHttpClient(httpClient);

            return new RestTemplate(requestFactory);

        } catch (Exception e) {
            new Throwable(e);
        }
        return null;
    }

}

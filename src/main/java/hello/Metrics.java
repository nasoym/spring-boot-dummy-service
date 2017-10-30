package hello;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.ClassLoadingExports;
import io.prometheus.client.hotspot.GarbageCollectorExports;
import io.prometheus.client.hotspot.MemoryPoolsExports;
import io.prometheus.client.hotspot.StandardExports;
import io.prometheus.client.hotspot.ThreadExports;
import io.prometheus.client.hotspot.VersionInfoExports;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Metrics {

  @Bean
  public ServletRegistrationBean registerPrometheusExporterServlet() {
    CollectorRegistry.defaultRegistry.clear();
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MetricsServlet(), "/prometheus");
    //DefaultExports.initialize();
    (new StandardExports()).register();
    (new MemoryPoolsExports()).register();
    (new GarbageCollectorExports()).register();
    (new ThreadExports()).register();
    (new ClassLoadingExports()).register();
    (new VersionInfoExports()).register();
    return servletRegistrationBean;
  }

}

package br.com.fiap.hackathon.time.tracking.launcher.configuration;

import br.com.fiap.hackathon.time.tracking.adapter.presenter.PresenterFactory;
import br.com.fiap.hackathon.time.tracking.adapter.presenter.TimeTrackingPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresenterConfiguration {

    @Bean
    public TimeTrackingPresenter purchasePresenter() {
        return PresenterFactory.presenter();
    }

}

package br.com.fiap.hackathon.time.tracking.adapter.presenter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PresenterFactory {

    public static TimeTrackingPresenter presenter() {
        return new TimeTrackingPresenterImpl();
    }

}

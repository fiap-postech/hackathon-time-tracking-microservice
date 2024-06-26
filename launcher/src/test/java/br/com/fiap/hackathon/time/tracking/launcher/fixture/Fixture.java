package br.com.fiap.hackathon.time.tracking.launcher.fixture;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class Fixture {

    public static <T> T create(Model<T> model) {
        return Instancio.of(model).create();
    }

}

package br.com.fiap.hackathon.time.tracking.driven.mongo.config;

import javax.net.ssl.SSLContext;

public interface SSLLoader {

    SSLContext load();

}

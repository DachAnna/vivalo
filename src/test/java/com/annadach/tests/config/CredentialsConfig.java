package com.annadach.tests.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "classpath:config/credentials.properties"})
public interface CredentialsConfig extends Config {

    String login();

    String password();

    String remoteUrl();
}

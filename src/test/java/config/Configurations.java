package config;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/test/resources/properties/test.properties"})
public interface Configurations extends Config {
    @Config.Key("baseURI")
    String baseURI();

    @Config.Key("basePath")
    String basePath();

    @Key("token")
    String token();
}

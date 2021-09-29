package config;

import java.io.*;
import java.util.Properties;

public class Config {

    private Properties conf = new Properties();
    private String env, acc;

    public Config() throws IOException
    {
        conf.load(new FileInputStream(getClass().getClassLoader().getResource("website.properties").getPath()));
    }

    public Config(String env, String acc) throws IOException
    {
        conf.load(new FileInputStream(getClass().getClassLoader().getResource("website.properties").getPath()));
        this.env = env;
        this.acc = acc;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getUrl() {
        return conf.getProperty(env + ".url");
    }

    public String getUsername() {
        return conf.getProperty(env + "." + acc + ".username");
    }

    public String getPassword() {
        return conf.getProperty(env + "." + acc + ".password");
    }
}

package de.evoila.cf.autoscaler.kafka.model;

/**
 * Created by reneschollmeyer, evoila on 24.10.18.
 */
public class BindingInformation {

    private String appId;
    private String action;
    private String source;

    public BindingInformation(String appId, String action, String source) {
        this.appId = appId;
        this.action = action;
        this.source = source;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

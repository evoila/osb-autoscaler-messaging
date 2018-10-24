package de.evoila.cf.autoscaler.kafka.model;

/**
 * Created by reneschollmeyer, evoila on 24.10.18.
 */
public class BindingInformation {

    public static final String ACTION_BIND = "bind";
    public static final String ACTION_UNBIND = "unbind";
    public static final String SOURCE_AUTOSCALER = "autoscaler";
    public static final String SOURCE_LOGMETRIC = "logMetric";

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

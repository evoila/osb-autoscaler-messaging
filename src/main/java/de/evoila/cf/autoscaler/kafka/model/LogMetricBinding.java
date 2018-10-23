package de.evoila.cf.autoscaler.kafka.model;

/**
 * Created by reneschollmeyer, evoila on 16.10.18.
 */
public class LogMetricBinding implements Binding {

    private String appId;
    private String action;
    private String source;

    public LogMetricBinding(String appId, String action) {
        this.appId = appId;
        this.action = action;
        this.source = "logMetric";
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
}
    
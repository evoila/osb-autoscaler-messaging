package de.evoila.cf.autoscaler.kafka.messages;

/**
 * Created by reneschollmeyer, evoila on 07.03.18.
 */
public class LogMessage {

    private long timestamp;
    private String logMessage;
    private String logMessageType;
    private String sourceType;
    private String appId;
    private String appName;
    private String space;
    private String organization;
    private String organizationGuid;
    private String sourceInstance;

    public LogMessage() {}

    public LogMessage(LogMessage other) {
        this(other.getTimestamp(), other.getLogMessage(), other.getLogMessageType(), other.getSourceType(),
                other.getAppId(), other.getAppName(), other.getSpace(), other.getOrganization(), other.getOrganizationGuid(),
                other.getSourceInstance());
    }

    public LogMessage(long timestamp, String logMessage, String logMessageType, String sourceType, String appId,
                      String appName, String space, String organization, String organization_guid, String sourceInstance) {
        this.timestamp = timestamp;
        this.logMessage = logMessage;
        this.logMessageType = logMessageType;
        this.sourceType = sourceType;
        this.appId = appId;
        this.appName = appName;
        this.space = space;
        this.organization = organization;
        this.organizationGuid = organization_guid;
        this.sourceInstance = sourceInstance;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogMessageType() {
        return logMessageType;
    }

    public void setLogMessageType(String logMessageType) {
        this.logMessageType = logMessageType;
    }

    public String getSourceType() { return sourceType; }

    public void setSourceType(String sourceType) { this.sourceType = sourceType; }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() { return appName; }

    public void setAppName(String appName) { this.appName = appName; }

    public String getSpace() { return space; }

    public void setSpace(String space) { this.space = space; }

    public String getOrganization() { return organization; }

    public void setOrganization(String organization) { this.organization = organization; }

    public String getOrganizationGuid() {
        return organizationGuid;
    }

    public void setOrganizationGuid(String organizationGuid) {
        this.organizationGuid = organizationGuid;
    }

    public String getSourceInstance() {
        return sourceInstance;
    }

    public void setSourceInstance(String sourceInstance) {
        this.sourceInstance = sourceInstance;
    }
}

package de.cf.autoscaler.kafka.messages;

import de.cf.autoscaler.kafka.protobuf.ProtobufLogMessageWrapper;

/**
 * Created by reneschollmeyer, evoila on 07.03.18.
 */
public class LogMessage {

    private long timestamp;
    private String logMessage;
    private String logMessageType;
    private String appId;
    private String appName;
    private String space;
    private String organization;

    public LogMessage(ProtobufLogMessageWrapper.ProtoLogMessage protoLogMessage) {
        this(protoLogMessage.getTimestamp(), protoLogMessage.getLogMessage(),
                protoLogMessage.getLogMessageType(), protoLogMessage.getAppId(),
                protoLogMessage.getAppName(), protoLogMessage.getSpace(),
                protoLogMessage.getOrganization());
    }

    public LogMessage(LogMessage other) {
        this(other.getTimestamp(), other.getLogMessage(), other.getLogMessageType(),
                other.getAppId(), other.getAppName(), other.getSpace(), other.getOrganization());
    }

    public LogMessage(long timestamp, String logMessage, String logMessageType, String appId,
                      String appName, String space, String organization) {
        this.timestamp = timestamp;
        this.logMessage = logMessage;
        this.logMessageType = logMessageType;
        this.appId = appId;
        this.appName = appName;
        this.space = space;
        this.organization = organization;
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

    public void setOrganization(String organization) { this.organization = organization;}
}

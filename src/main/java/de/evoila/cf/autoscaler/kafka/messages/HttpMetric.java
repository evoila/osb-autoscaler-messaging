package de.evoila.cf.autoscaler.kafka.messages;

/**
 * Wrapper class to store information about the controller requests of an application.
 * @author Marius Berger
 *
 */
public class HttpMetric implements AutoscalerMetric {
	
	private int requests;
	private int latency;
	private long timestamp;
	private String appId;
	private String appName;
	private String space;
	private String organization;
	private String organizationGuid;
	private String metricName;
	private String description;

	/**
	 * Default constructor in order to make the jackson ObjectMapper work
	 */
	public HttpMetric() {}
	
	/**
	 * Constructor with all fields.
	 * @param timestamp {@linkplain #timestamp}
	 * @param metricName {@linkplain #metricName}
	 * @param appId {@linkplain #appId}
	 * @param requests {@linkplain #requests}
	 * @param latency {@linkplain #latency}
	 * @param description {@linkplain #description}
	 */
	public HttpMetric(long timestamp, String metricName, String appId, String appName, String space, String organization,
					  String organizationGuid, int requests, int latency, String description) {
		this.timestamp = timestamp;
		this.metricName = metricName;
		this.appId = appId;
		this.appName = appName;
		this.space = space;
		this.organization = organization;
		this.organizationGuid = organizationGuid;
		this.requests = requests;
		this.latency = latency;
		this.description = description;
	}
	
	/**
	 * Copy constructor
	 * @param other metric to copy
	 */
	public HttpMetric(HttpMetric other) {
		this(other.getTimestamp(), other.getMetricName(), other.getAppId(), other.getAppName(), other.getSpace(),
				other.getOrganization(), other.getOrganizationGuid(), other.getRequests(), other.getLatency(), other.getDescription());
	}
	

	/**
	 * Returns a String representation of the controller metric type.
	 */
	@Override
	public String getType() {
		return AutoscalerMetric.TYPE_HTTP;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public int getRequests() {
		return requests;
	}

	public void setRequests(int requests) {
		this.requests = requests;
	}

	public int getLatency() {
		return latency;
	}

	public void setLatency(int latency) {
		this.latency = latency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getSpace() {
		return space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrganizationGuid() {
		return organizationGuid;
	}

	public void setOrganizationGuid(String organizationGuid) {
		this.organizationGuid = organizationGuid;
	}

	/**
	 * Creates and returns a String representation of this metric, mostly used for debugging.
	 */
	@Override
	public String toString() {
		String output = "{"
				+ "\"timestamp\" : \"" + timestamp + "\""
				+ " , "
				+ "\"metricName\" : \"" + metricName + "\""
				+ " , "
				+ "\"appId\" : \"" + appId + "\""
				+ " , "
				+ "\"requests\" : \"" + requests + "\""
				+ " , "
				+ "\"latency\" : \"" + latency + "\""
				+ " , "
				+ "\"description\" : \"" + description + "\""
				+ "}";
		return output;
	}
	
	/**
	 * Checks for equality based on {@linkplain #timestamp}, {@linkplain #metricName}, {@linkplain #appId} and {@linkplain #requests}, 
	 * {@linkplain #latency}.
	 * @param other {@code ContainerMetric} to check for equality
	 * @return true if the other metric is equal, otherwise returns false
	 */
	public boolean equals(HttpMetric other) {
		return (timestamp == other.getTimestamp()) && (metricName.equals(other.getMetricName()))  && (appId.equals(other.getAppId()))
				&& (requests == other.getRequests()) && (latency == other.getLatency());
	}
	
	/**
	 * Checks whether this metric is older than the maximum age a metric is allowed to have.
	 * @param maxMetricAge maximum age allowed to have
	 * @return true if this metric is younger than the maximum age
	 */
	public boolean isTooOld(long maxMetricAge) {
		return System.currentTimeMillis() - getTimestamp() > maxMetricAge;
	}
}

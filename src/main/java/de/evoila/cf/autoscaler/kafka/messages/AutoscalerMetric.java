package de.evoila.cf.autoscaler.kafka.messages;

/**
 * Interface for metrics the Autoscaler 
 * @author Marius Berger
 *
 */
public interface AutoscalerMetric {
	
	/**
	 * String representation of the HTTP metric type.
	 */
	public static final String TYPE_HTTP = "HTTP";
	/**
	 * Name of the HTTP metric.
	 */
	public static final String NAME_HTTP = "HTTPMetric";
	/**
	 * String representation of the container metric type.
	 */
	public static final String TYPE_CONTAINER = "Container";
	/**
	 * Name of the container metric.
	 */
	public static final String NAME_CONTAINER = "ContainerMetric";
	/**
	 * String representation of the application metric type.
	 */
	public static final String TYPE_APPLICATION = "Application";
	/**
	 * Name of the application metric.
	 */
	public static final String NAME_APPLICATION = "ApplicationMetric";

	/**
	 * Returns a String representation of the metric.
	 */
	public String getType();

	/**
	 * Returns the id of the application the metric is dedicated to.
	 */
	public String getAppId();

	public long getTimestamp();
}

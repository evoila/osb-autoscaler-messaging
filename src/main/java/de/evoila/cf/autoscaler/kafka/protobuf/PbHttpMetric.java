// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HttpMetric.proto

package de.evoila.cf.autoscaler.kafka.protobuf;

public final class PbHttpMetric {
  private PbHttpMetric() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ProtoHttpMetricOrBuilder extends
      // @@protoc_insertion_point(interface_extends:autoscaler.ProtoHttpMetric)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 timestamp = 1;</code>
     */
    long getTimestamp();

    /**
     * <code>string metricName = 2;</code>
     */
    java.lang.String getMetricName();
    /**
     * <code>string metricName = 2;</code>
     */
    com.google.protobuf.ByteString
        getMetricNameBytes();

    /**
     * <code>string appId = 3;</code>
     */
    java.lang.String getAppId();
    /**
     * <code>string appId = 3;</code>
     */
    com.google.protobuf.ByteString
        getAppIdBytes();

    /**
     * <code>int32 requests = 4;</code>
     */
    int getRequests();

    /**
     * <code>int32 latency = 5;</code>
     */
    int getLatency();

    /**
     * <code>string description = 6;</code>
     */
    java.lang.String getDescription();
    /**
     * <code>string description = 6;</code>
     */
    com.google.protobuf.ByteString
        getDescriptionBytes();
  }
  /**
   * Protobuf type {@code autoscaler.ProtoHttpMetric}
   */
  public  static final class ProtoHttpMetric extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:autoscaler.ProtoHttpMetric)
      ProtoHttpMetricOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ProtoHttpMetric.newBuilder() to construct.
    private ProtoHttpMetric(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ProtoHttpMetric() {
      timestamp_ = 0L;
      metricName_ = "";
      appId_ = "";
      requests_ = 0;
      latency_ = 0;
      description_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ProtoHttpMetric(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              timestamp_ = input.readInt64();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              metricName_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              appId_ = s;
              break;
            }
            case 32: {

              requests_ = input.readInt32();
              break;
            }
            case 40: {

              latency_ = input.readInt32();
              break;
            }
            case 50: {
              java.lang.String s = input.readStringRequireUtf8();

              description_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.internal_static_autoscaler_ProtoHttpMetric_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.internal_static_autoscaler_ProtoHttpMetric_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric.class, de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric.Builder.class);
    }

    public static final int TIMESTAMP_FIELD_NUMBER = 1;
    private long timestamp_;
    /**
     * <code>int64 timestamp = 1;</code>
     */
    public long getTimestamp() {
      return timestamp_;
    }

    public static final int METRICNAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object metricName_;
    /**
     * <code>string metricName = 2;</code>
     */
    public java.lang.String getMetricName() {
      java.lang.Object ref = metricName_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        metricName_ = s;
        return s;
      }
    }
    /**
     * <code>string metricName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMetricNameBytes() {
      java.lang.Object ref = metricName_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        metricName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int APPID_FIELD_NUMBER = 3;
    private volatile java.lang.Object appId_;
    /**
     * <code>string appId = 3;</code>
     */
    public java.lang.String getAppId() {
      java.lang.Object ref = appId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        appId_ = s;
        return s;
      }
    }
    /**
     * <code>string appId = 3;</code>
     */
    public com.google.protobuf.ByteString
        getAppIdBytes() {
      java.lang.Object ref = appId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        appId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int REQUESTS_FIELD_NUMBER = 4;
    private int requests_;
    /**
     * <code>int32 requests = 4;</code>
     */
    public int getRequests() {
      return requests_;
    }

    public static final int LATENCY_FIELD_NUMBER = 5;
    private int latency_;
    /**
     * <code>int32 latency = 5;</code>
     */
    public int getLatency() {
      return latency_;
    }

    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    private volatile java.lang.Object description_;
    /**
     * <code>string description = 6;</code>
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      }
    }
    /**
     * <code>string description = 6;</code>
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (timestamp_ != 0L) {
        output.writeInt64(1, timestamp_);
      }
      if (!getMetricNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, metricName_);
      }
      if (!getAppIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, appId_);
      }
      if (requests_ != 0) {
        output.writeInt32(4, requests_);
      }
      if (latency_ != 0) {
        output.writeInt32(5, latency_);
      }
      if (!getDescriptionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 6, description_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (timestamp_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, timestamp_);
      }
      if (!getMetricNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, metricName_);
      }
      if (!getAppIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, appId_);
      }
      if (requests_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, requests_);
      }
      if (latency_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, latency_);
      }
      if (!getDescriptionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, description_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric)) {
        return super.equals(obj);
      }
      de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric other = (de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric) obj;

      boolean result = true;
      result = result && (getTimestamp()
          == other.getTimestamp());
      result = result && getMetricName()
          .equals(other.getMetricName());
      result = result && getAppId()
          .equals(other.getAppId());
      result = result && (getRequests()
          == other.getRequests());
      result = result && (getLatency()
          == other.getLatency());
      result = result && getDescription()
          .equals(other.getDescription());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getTimestamp());
      hash = (37 * hash) + METRICNAME_FIELD_NUMBER;
      hash = (53 * hash) + getMetricName().hashCode();
      hash = (37 * hash) + APPID_FIELD_NUMBER;
      hash = (53 * hash) + getAppId().hashCode();
      hash = (37 * hash) + REQUESTS_FIELD_NUMBER;
      hash = (53 * hash) + getRequests();
      hash = (37 * hash) + LATENCY_FIELD_NUMBER;
      hash = (53 * hash) + getLatency();
      hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
      hash = (53 * hash) + getDescription().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code autoscaler.ProtoHttpMetric}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:autoscaler.ProtoHttpMetric)
        de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetricOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.internal_static_autoscaler_ProtoHttpMetric_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.internal_static_autoscaler_ProtoHttpMetric_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric.class, de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric.Builder.class);
      }

      // Construct using de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        timestamp_ = 0L;

        metricName_ = "";

        appId_ = "";

        requests_ = 0;

        latency_ = 0;

        description_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.internal_static_autoscaler_ProtoHttpMetric_descriptor;
      }

      public de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric getDefaultInstanceForType() {
        return de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric.getDefaultInstance();
      }

      public de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric build() {
        de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric buildPartial() {
        de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric result = new de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric(this);
        result.timestamp_ = timestamp_;
        result.metricName_ = metricName_;
        result.appId_ = appId_;
        result.requests_ = requests_;
        result.latency_ = latency_;
        result.description_ = description_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric) {
          return mergeFrom((de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric other) {
        if (other == de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric.getDefaultInstance()) return this;
        if (other.getTimestamp() != 0L) {
          setTimestamp(other.getTimestamp());
        }
        if (!other.getMetricName().isEmpty()) {
          metricName_ = other.metricName_;
          onChanged();
        }
        if (!other.getAppId().isEmpty()) {
          appId_ = other.appId_;
          onChanged();
        }
        if (other.getRequests() != 0) {
          setRequests(other.getRequests());
        }
        if (other.getLatency() != 0) {
          setLatency(other.getLatency());
        }
        if (!other.getDescription().isEmpty()) {
          description_ = other.description_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long timestamp_ ;
      /**
       * <code>int64 timestamp = 1;</code>
       */
      public long getTimestamp() {
        return timestamp_;
      }
      /**
       * <code>int64 timestamp = 1;</code>
       */
      public Builder setTimestamp(long value) {
        
        timestamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 timestamp = 1;</code>
       */
      public Builder clearTimestamp() {
        
        timestamp_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object metricName_ = "";
      /**
       * <code>string metricName = 2;</code>
       */
      public java.lang.String getMetricName() {
        java.lang.Object ref = metricName_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          metricName_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string metricName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getMetricNameBytes() {
        java.lang.Object ref = metricName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          metricName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string metricName = 2;</code>
       */
      public Builder setMetricName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        metricName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string metricName = 2;</code>
       */
      public Builder clearMetricName() {
        
        metricName_ = getDefaultInstance().getMetricName();
        onChanged();
        return this;
      }
      /**
       * <code>string metricName = 2;</code>
       */
      public Builder setMetricNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        metricName_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object appId_ = "";
      /**
       * <code>string appId = 3;</code>
       */
      public java.lang.String getAppId() {
        java.lang.Object ref = appId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          appId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string appId = 3;</code>
       */
      public com.google.protobuf.ByteString
          getAppIdBytes() {
        java.lang.Object ref = appId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          appId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string appId = 3;</code>
       */
      public Builder setAppId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        appId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string appId = 3;</code>
       */
      public Builder clearAppId() {
        
        appId_ = getDefaultInstance().getAppId();
        onChanged();
        return this;
      }
      /**
       * <code>string appId = 3;</code>
       */
      public Builder setAppIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        appId_ = value;
        onChanged();
        return this;
      }

      private int requests_ ;
      /**
       * <code>int32 requests = 4;</code>
       */
      public int getRequests() {
        return requests_;
      }
      /**
       * <code>int32 requests = 4;</code>
       */
      public Builder setRequests(int value) {
        
        requests_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 requests = 4;</code>
       */
      public Builder clearRequests() {
        
        requests_ = 0;
        onChanged();
        return this;
      }

      private int latency_ ;
      /**
       * <code>int32 latency = 5;</code>
       */
      public int getLatency() {
        return latency_;
      }
      /**
       * <code>int32 latency = 5;</code>
       */
      public Builder setLatency(int value) {
        
        latency_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 latency = 5;</code>
       */
      public Builder clearLatency() {
        
        latency_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object description_ = "";
      /**
       * <code>string description = 6;</code>
       */
      public java.lang.String getDescription() {
        java.lang.Object ref = description_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          description_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string description = 6;</code>
       */
      public com.google.protobuf.ByteString
          getDescriptionBytes() {
        java.lang.Object ref = description_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          description_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string description = 6;</code>
       */
      public Builder setDescription(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        description_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string description = 6;</code>
       */
      public Builder clearDescription() {
        
        description_ = getDefaultInstance().getDescription();
        onChanged();
        return this;
      }
      /**
       * <code>string description = 6;</code>
       */
      public Builder setDescriptionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        description_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:autoscaler.ProtoHttpMetric)
    }

    // @@protoc_insertion_point(class_scope:autoscaler.ProtoHttpMetric)
    private static final de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric();
    }

    public static de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ProtoHttpMetric>
        PARSER = new com.google.protobuf.AbstractParser<ProtoHttpMetric>() {
      public ProtoHttpMetric parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ProtoHttpMetric(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ProtoHttpMetric> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ProtoHttpMetric> getParserForType() {
      return PARSER;
    }

    public de.evoila.cf.autoscaler.kafka.protobuf.PbHttpMetric.ProtoHttpMetric getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_autoscaler_ProtoHttpMetric_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_autoscaler_ProtoHttpMetric_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020HttpMetric.proto\022\nautoscaler\"\177\n\017ProtoH" +
      "ttpMetric\022\021\n\ttimestamp\030\001 \001(\003\022\022\n\nmetricNa" +
      "me\030\002 \001(\t\022\r\n\005appId\030\003 \001(\t\022\020\n\010requests\030\004 \001(" +
      "\005\022\017\n\007latency\030\005 \001(\005\022\023\n\013description\030\006 \001(\tB" +
      "]\n&de.evoila.cf.autoscaler.kafka.protobu" +
      "fB\014PbHttpMetric\252\002$de.evoila.cf.autoscale" +
      "r.PbHttpMetricb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_autoscaler_ProtoHttpMetric_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_autoscaler_ProtoHttpMetric_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_autoscaler_ProtoHttpMetric_descriptor,
        new java.lang.String[] { "Timestamp", "MetricName", "AppId", "Requests", "Latency", "Description", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

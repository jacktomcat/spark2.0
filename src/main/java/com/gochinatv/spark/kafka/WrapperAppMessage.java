/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.gochinatv.spark.kafka;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class WrapperAppMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 1292340064664972254L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WrapperAppMessage\",\"namespace\":\"com.gochinatv.spark.kafka\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\"},{\"name\":\"count\",\"type\":\"int\"},{\"name\":\"value\",\"type\":\"float\"},{\"name\":\"agreeId\",\"type\":\"int\"},{\"name\":\"cityId\",\"type\":\"int\"},{\"name\":\"provinceId\",\"type\":\"int\"},{\"name\":\"instanceId\",\"type\":\"int\"},{\"name\":\"connectType\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public long timestamp;
  @Deprecated public int count;
  @Deprecated public float value;
  @Deprecated public int agreeId;
  @Deprecated public int cityId;
  @Deprecated public int provinceId;
  @Deprecated public int instanceId;
  @Deprecated public int connectType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WrapperAppMessage() {}

  /**
   * All-args constructor.
   * @param timestamp The new value for timestamp
   * @param count The new value for count
   * @param value The new value for value
   * @param agreeId The new value for agreeId
   * @param cityId The new value for cityId
   * @param provinceId The new value for provinceId
   * @param instanceId The new value for instanceId
   * @param connectType The new value for connectType
   */
  public WrapperAppMessage(Long timestamp, Integer count, Float value, Integer agreeId, Integer cityId, Integer provinceId, Integer instanceId, Integer connectType) {
    this.timestamp = timestamp;
    this.count = count;
    this.value = value;
    this.agreeId = agreeId;
    this.cityId = cityId;
    this.provinceId = provinceId;
    this.instanceId = instanceId;
    this.connectType = connectType;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return timestamp;
    case 1: return count;
    case 2: return value;
    case 3: return agreeId;
    case 4: return cityId;
    case 5: return provinceId;
    case 6: return instanceId;
    case 7: return connectType;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: timestamp = (Long)value$; break;
    case 1: count = (Integer)value$; break;
    case 2: value = (Float)value$; break;
    case 3: agreeId = (Integer)value$; break;
    case 4: cityId = (Integer)value$; break;
    case 5: provinceId = (Integer)value$; break;
    case 6: instanceId = (Integer)value$; break;
    case 7: connectType = (Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'timestamp' field.
   * @return The value of the 'timestamp' field.
   */
  public Long getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the value of the 'timestamp' field.
   * @param value the value to set.
   */
  public void setTimestamp(Long value) {
    this.timestamp = value;
  }

  /**
   * Gets the value of the 'count' field.
   * @return The value of the 'count' field.
   */
  public Integer getCount() {
    return count;
  }

  /**
   * Sets the value of the 'count' field.
   * @param value the value to set.
   */
  public void setCount(Integer value) {
    this.count = value;
  }

  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public Float getValue() {
    return value;
  }

  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(Float value) {
    this.value = value;
  }

  /**
   * Gets the value of the 'agreeId' field.
   * @return The value of the 'agreeId' field.
   */
  public Integer getAgreeId() {
    return agreeId;
  }

  /**
   * Sets the value of the 'agreeId' field.
   * @param value the value to set.
   */
  public void setAgreeId(Integer value) {
    this.agreeId = value;
  }

  /**
   * Gets the value of the 'cityId' field.
   * @return The value of the 'cityId' field.
   */
  public Integer getCityId() {
    return cityId;
  }

  /**
   * Sets the value of the 'cityId' field.
   * @param value the value to set.
   */
  public void setCityId(Integer value) {
    this.cityId = value;
  }

  /**
   * Gets the value of the 'provinceId' field.
   * @return The value of the 'provinceId' field.
   */
  public Integer getProvinceId() {
    return provinceId;
  }

  /**
   * Sets the value of the 'provinceId' field.
   * @param value the value to set.
   */
  public void setProvinceId(Integer value) {
    this.provinceId = value;
  }

  /**
   * Gets the value of the 'instanceId' field.
   * @return The value of the 'instanceId' field.
   */
  public Integer getInstanceId() {
    return instanceId;
  }

  /**
   * Sets the value of the 'instanceId' field.
   * @param value the value to set.
   */
  public void setInstanceId(Integer value) {
    this.instanceId = value;
  }

  /**
   * Gets the value of the 'connectType' field.
   * @return The value of the 'connectType' field.
   */
  public Integer getConnectType() {
    return connectType;
  }

  /**
   * Sets the value of the 'connectType' field.
   * @param value the value to set.
   */
  public void setConnectType(Integer value) {
    this.connectType = value;
  }

  /**
   * Creates a new WrapperAppMessage RecordBuilder.
   * @return A new WrapperAppMessage RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new WrapperAppMessage RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WrapperAppMessage RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    return new Builder(other);
  }

  /**
   * Creates a new WrapperAppMessage RecordBuilder by copying an existing WrapperAppMessage instance.
   * @param other The existing instance to copy.
   * @return A new WrapperAppMessage RecordBuilder
   */
  public static Builder newBuilder(WrapperAppMessage other) {
    return new Builder(other);
  }

  /**
   * RecordBuilder for WrapperAppMessage instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WrapperAppMessage>
    implements org.apache.avro.data.RecordBuilder<WrapperAppMessage> {

    private long timestamp;
    private int count;
    private float value;
    private int agreeId;
    private int cityId;
    private int provinceId;
    private int instanceId;
    private int connectType;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[0].schema(), other.timestamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.count)) {
        this.count = data().deepCopy(fields()[1].schema(), other.count);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.value)) {
        this.value = data().deepCopy(fields()[2].schema(), other.value);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.agreeId)) {
        this.agreeId = data().deepCopy(fields()[3].schema(), other.agreeId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.cityId)) {
        this.cityId = data().deepCopy(fields()[4].schema(), other.cityId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.provinceId)) {
        this.provinceId = data().deepCopy(fields()[5].schema(), other.provinceId);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.instanceId)) {
        this.instanceId = data().deepCopy(fields()[6].schema(), other.instanceId);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.connectType)) {
        this.connectType = data().deepCopy(fields()[7].schema(), other.connectType);
        fieldSetFlags()[7] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing WrapperAppMessage instance
     * @param other The existing instance to copy.
     */
    private Builder(WrapperAppMessage other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.timestamp)) {
        this.timestamp = data().deepCopy(fields()[0].schema(), other.timestamp);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.count)) {
        this.count = data().deepCopy(fields()[1].schema(), other.count);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.value)) {
        this.value = data().deepCopy(fields()[2].schema(), other.value);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.agreeId)) {
        this.agreeId = data().deepCopy(fields()[3].schema(), other.agreeId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.cityId)) {
        this.cityId = data().deepCopy(fields()[4].schema(), other.cityId);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.provinceId)) {
        this.provinceId = data().deepCopy(fields()[5].schema(), other.provinceId);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.instanceId)) {
        this.instanceId = data().deepCopy(fields()[6].schema(), other.instanceId);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.connectType)) {
        this.connectType = data().deepCopy(fields()[7].schema(), other.connectType);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'timestamp' field.
      * @return The value.
      */
    public Long getTimestamp() {
      return timestamp;
    }

    /**
      * Sets the value of the 'timestamp' field.
      * @param value The value of 'timestamp'.
      * @return This builder.
      */
    public Builder setTimestamp(long value) {
      validate(fields()[0], value);
      this.timestamp = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'timestamp' field has been set.
      * @return True if the 'timestamp' field has been set, false otherwise.
      */
    public boolean hasTimestamp() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'timestamp' field.
      * @return This builder.
      */
    public Builder clearTimestamp() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'count' field.
      * @return The value.
      */
    public Integer getCount() {
      return count;
    }

    /**
      * Sets the value of the 'count' field.
      * @param value The value of 'count'.
      * @return This builder.
      */
    public Builder setCount(int value) {
      validate(fields()[1], value);
      this.count = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'count' field has been set.
      * @return True if the 'count' field has been set, false otherwise.
      */
    public boolean hasCount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'count' field.
      * @return This builder.
      */
    public Builder clearCount() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public Float getValue() {
      return value;
    }

    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public Builder setValue(float value) {
      validate(fields()[2], value);
      this.value = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public Builder clearValue() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'agreeId' field.
      * @return The value.
      */
    public Integer getAgreeId() {
      return agreeId;
    }

    /**
      * Sets the value of the 'agreeId' field.
      * @param value The value of 'agreeId'.
      * @return This builder.
      */
    public Builder setAgreeId(int value) {
      validate(fields()[3], value);
      this.agreeId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'agreeId' field has been set.
      * @return True if the 'agreeId' field has been set, false otherwise.
      */
    public boolean hasAgreeId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'agreeId' field.
      * @return This builder.
      */
    public Builder clearAgreeId() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'cityId' field.
      * @return The value.
      */
    public Integer getCityId() {
      return cityId;
    }

    /**
      * Sets the value of the 'cityId' field.
      * @param value The value of 'cityId'.
      * @return This builder.
      */
    public Builder setCityId(int value) {
      validate(fields()[4], value);
      this.cityId = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'cityId' field has been set.
      * @return True if the 'cityId' field has been set, false otherwise.
      */
    public boolean hasCityId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'cityId' field.
      * @return This builder.
      */
    public Builder clearCityId() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'provinceId' field.
      * @return The value.
      */
    public Integer getProvinceId() {
      return provinceId;
    }

    /**
      * Sets the value of the 'provinceId' field.
      * @param value The value of 'provinceId'.
      * @return This builder.
      */
    public Builder setProvinceId(int value) {
      validate(fields()[5], value);
      this.provinceId = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'provinceId' field has been set.
      * @return True if the 'provinceId' field has been set, false otherwise.
      */
    public boolean hasProvinceId() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'provinceId' field.
      * @return This builder.
      */
    public Builder clearProvinceId() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'instanceId' field.
      * @return The value.
      */
    public Integer getInstanceId() {
      return instanceId;
    }

    /**
      * Sets the value of the 'instanceId' field.
      * @param value The value of 'instanceId'.
      * @return This builder.
      */
    public Builder setInstanceId(int value) {
      validate(fields()[6], value);
      this.instanceId = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'instanceId' field has been set.
      * @return True if the 'instanceId' field has been set, false otherwise.
      */
    public boolean hasInstanceId() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'instanceId' field.
      * @return This builder.
      */
    public Builder clearInstanceId() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'connectType' field.
      * @return The value.
      */
    public Integer getConnectType() {
      return connectType;
    }

    /**
      * Sets the value of the 'connectType' field.
      * @param value The value of 'connectType'.
      * @return This builder.
      */
    public Builder setConnectType(int value) {
      validate(fields()[7], value);
      this.connectType = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'connectType' field has been set.
      * @return True if the 'connectType' field has been set, false otherwise.
      */
    public boolean hasConnectType() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'connectType' field.
      * @return This builder.
      */
    public Builder clearConnectType() {
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    public WrapperAppMessage build() {
      try {
        WrapperAppMessage record = new WrapperAppMessage();
        record.timestamp = fieldSetFlags()[0] ? this.timestamp : (Long) defaultValue(fields()[0]);
        record.count = fieldSetFlags()[1] ? this.count : (Integer) defaultValue(fields()[1]);
        record.value = fieldSetFlags()[2] ? this.value : (Float) defaultValue(fields()[2]);
        record.agreeId = fieldSetFlags()[3] ? this.agreeId : (Integer) defaultValue(fields()[3]);
        record.cityId = fieldSetFlags()[4] ? this.cityId : (Integer) defaultValue(fields()[4]);
        record.provinceId = fieldSetFlags()[5] ? this.provinceId : (Integer) defaultValue(fields()[5]);
        record.instanceId = fieldSetFlags()[6] ? this.instanceId : (Integer) defaultValue(fields()[6]);
        record.connectType = fieldSetFlags()[7] ? this.connectType : (Integer) defaultValue(fields()[7]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
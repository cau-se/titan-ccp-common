package titan.ccp.models.records;

import kieker.common.exception.RecordInstantiationException;
import kieker.common.record.factory.IRecordFactory;
import kieker.common.record.io.IValueDeserializer;

/**
 * @author Generic Kieker
 *
 * @since 1.14
 */
public final class AggregatedActivePowerRecordFactory
    implements IRecordFactory<AggregatedActivePowerRecord> {

  @Override
  public AggregatedActivePowerRecord create(final IValueDeserializer deserializer)
      throws RecordInstantiationException {
    return new AggregatedActivePowerRecord(deserializer);
  }

  @Override
  public String[] getValueNames() {
    return AggregatedActivePowerRecord.VALUE_NAMES; // NOPMD
  }

  @Override
  public Class<?>[] getValueTypes() {
    return AggregatedActivePowerRecord.TYPES; // NOPMD
  }

  @Override
  public int getRecordSizeInBytes() {
    return AggregatedActivePowerRecord.SIZE;
  }
}
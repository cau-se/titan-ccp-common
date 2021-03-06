package titan.ccp.model.sensorregistry;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A {@link SensorRegistry} containing no real sensors. Will be removed with next release.
 *
 * @deprecated Create a corresponding {@link SensorRegistry} manually if required.
 */
@Deprecated
public class DummySensorRegistry implements SensorRegistry {

  private static final AggregatedSensor EMPTY_TOP_LEVEL_SENSOR = new EmptyTopLevelSensor();

  private final Map<String, DummyMachineSensor> dummySensors = new HashMap<>();

  @Override
  public Optional<MachineSensor> getSensorForIdentifier(final String identifier) {
    return Optional
        .of(this.dummySensors.computeIfAbsent(identifier, i -> new DummyMachineSensor(i)));
  }

  @Override
  public AggregatedSensor getTopLevelSensor() {
    return EMPTY_TOP_LEVEL_SENSOR;
  }

  @Override
  public Collection<MachineSensor> getMachineSensors() {
    return Collections.emptyList();
  }

  // TODO move
  private static class EmptyTopLevelSensor implements AggregatedSensor {

    @Override
    public Optional<AggregatedSensor> getParent() {
      return Optional.empty();
    }

    @Override
    public String getIdentifier() {
      return "";
    }

    @Override
    public String getName() {
      return "";
    }

    @Override
    public Collection<Sensor> getChildren() {
      return Collections.emptyList();
    }

  }

  private static class DummyMachineSensor implements MachineSensor {

    private final String identifier;

    private DummyMachineSensor(final String identifier) {
      this.identifier = identifier;
    }

    @Override
    public Optional<AggregatedSensor> getParent() {
      return Optional.empty();
    }

    @Override
    public String getIdentifier() {
      return this.identifier;
    }

    @Override
    public String getName() {
      return "";
    }

  }

}

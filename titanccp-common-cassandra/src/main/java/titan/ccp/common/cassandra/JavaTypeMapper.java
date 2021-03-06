package titan.ccp.common.cassandra;

import com.datastax.driver.core.DataType;

/**
 * Utility class providing a method for mapping a Java {@link Class} object to a Cassandra
 * {@link DataType}.
 */
public final class JavaTypeMapper {

  private JavaTypeMapper() {}

  /**
   * Map a Java {@link Class} object to a Cassandra {@link DataType}.
   */
  public static DataType map(final Class<?> type) { // NOCS // NOPMD
    if (type == boolean.class) {
      return DataType.cboolean();
    } else if (type == Boolean.class) {
      return DataType.cboolean();
    } else if (type == byte.class) {
      return DataType.tinyint();
    } else if (type == Byte.class) {
      return DataType.tinyint();
    } else if (type == char.class) {
      return DataType.text();
    } else if (type == Character.class) {
      return DataType.text();
    } else if (type == short.class) {
      return DataType.smallint();
    } else if (type == Short.class) {
      return DataType.smallint();
    } else if (type == int.class) {
      return DataType.cint();
    } else if (type == Integer.class) {
      return DataType.cint();
    } else if (type == long.class) {
      return DataType.bigint();
    } else if (type == Long.class) {
      return DataType.bigint();
    } else if (type == float.class) {
      return DataType.cfloat();
    } else if (type == Float.class) {
      return DataType.cfloat();
    } else if (type == double.class) {
      return DataType.cdouble();
    } else if (type == Double.class) {
      return DataType.cdouble();
    } else if (type == Enum.class) {
      return DataType.cint(); // Depend on array serialization strategy
    } else if (type == byte[].class) {
      return DataType.blob();
    } else if (type == Byte[].class) {
      return DataType.blob();
    } else if (type == String.class) {
      return DataType.text();
    } else {
      throw new IllegalArgumentException(
          "Unable to map Java type '" + type.getName() + "' to a Cassandra data type.");
    }
  }

}

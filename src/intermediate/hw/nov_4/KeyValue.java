package intermediate.hw.nov_4;

public class KeyValue<V> {

  private String key;
  private V value;
  private String extra;

  public KeyValue(String key, V value) {
    this(key, value, null);
  }

  public KeyValue(String key, V value, String extra) {
    this.key = key;
    this.value = value;
    this.extra = extra;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public String getExtra() {
    return extra;
  }

  public void setExtra(String extra) {
    this.extra = extra;
  }
}
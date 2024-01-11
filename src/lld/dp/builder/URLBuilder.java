package lld.dp.builder;

public class URLBuilder {

  public final String protocal;
  public final String hostName;
  public final String port;
  public final String pathParam;
  public final String queryParam;

  public URLBuilder(Builder builder) {
    this.protocal = builder.protocal;
    this.hostName = builder.hostName;
    this.port = builder.port;
    this.pathParam = builder.pathParam;
    this.queryParam = builder.queryParam;
  }

  public static class Builder {

    private String protocal;
    private String hostName;
    private String port;
    private String pathParam;
    private String queryParam;

    public Builder protocal(String protocal) {
      this.protocal = protocal;
      return this;
    }

    public Builder hostName(String hostName) {
      this.hostName = hostName;
      return this;
    }

    public Builder port(String port) {
      this.port = port;
      return this;
    }

    public Builder pathParam(String pathParam) {
      this.pathParam = pathParam;
      return this;
    }

    public Builder queryParam(String queryParam) {
      this.queryParam = queryParam;
      return this;
    }

    public URLBuilder build() {

      return new URLBuilder(this);
    }

  }
}

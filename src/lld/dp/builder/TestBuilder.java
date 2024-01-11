package lld.dp.builder;

public class TestBuilder {

  public static void main(String[] args) {
    URLBuilder.Builder builder=new URLBuilder.Builder();
    builder.protocal("https://").hostName("localhost").port(":8080").pathParam("/abc").queryParam("?par=test");
    URLBuilder urlBuilder = builder.build();
    System.out.print(urlBuilder.protocal);
    System.out.print(urlBuilder.hostName);
    System.out.print(urlBuilder.port);
    System.out.println(urlBuilder.pathParam);
    URLBuilder.Builder builder2=new URLBuilder.Builder();
    builder2.protocal("https://").hostName("localhost").pathParam("/abc").queryParam("?par=test");;
    URLBuilder urlBuilder2 = builder2.build();
    System.out.print(urlBuilder2.protocal);
    System.out.print(urlBuilder2.hostName);
    System.out.print(urlBuilder2.pathParam);
    System.out.println(urlBuilder2.queryParam);

  }

}

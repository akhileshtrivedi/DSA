package lb_recursion;

import java.util.Arrays;

public class DayTwo {
private static int countDistinctWayToClimbStair(int nStairs){
if(nStairs<0){
  return 0;
}
  if(nStairs==0){
    return 1;
  }
  //recursion relation
  return countDistinctWayToClimbStair(nStairs-1)+countDistinctWayToClimbStair(nStairs-2);
}

static String sayDigit(int n, String[] data,String result){
  if(n==0){
    return result;
  }
  int digit =n%10;
      n=n/10;
 // System.out.print(" before  "+result);

  result =sayDigit(n,data, result);
  result = result + data[digit]+" ";

 // System.out.print(digit+" after "+result);
   return result;
}
  public String getDomainName(String host){
    String strDomain;
    //String[] strhost = url.getHost().split(Pattern.quote("."));
    String[] strhost = host.split("\\.");
    String[] strTLD = {"com","org","net","int","edu","gov","mil","arpa"};

    if(Arrays.asList(strTLD).indexOf(strhost[strhost.length-1])>=0)
      strDomain = strhost[strhost.length-2]+"."+strhost[strhost.length-1];
    else if(strhost.length>2)
      strDomain = strhost[strhost.length-3]+"."+strhost[strhost.length-2]+"."+strhost[strhost.length-1];
    else
      strDomain = strhost[strhost.length-2]+"."+strhost[strhost.length-1];
    return strDomain;}


  private static String extractDomainName(String url) {
    int start = url.indexOf("://");
    if (start < 0) {
      start = 0;
    } else {
      start += 3;
    }
    int end = url.indexOf('/', start);
    if (end < 0) {
      end = url.length();
    }
    String domainName = url.substring(start, end);

    int port = domainName.indexOf(':');
    if (port >= 0) {
      domainName = domainName.substring(0, port);
    }
   return domainName;
  }
  private static boolean isDemoInstance(String url) {
    String domainName = url.startsWith("https://") ? url.substring(8) : url;
    String firstFourChars = domainName.substring(0, 4);
    return firstFourChars.equals("demo");
  }
  public static void main(String[] args) {
   // System.out.println(""+countDistinctWayToClimbStair(5));
  //  String[] data={"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
   // System.out.println(" "+sayDigit(432,data," "));
String host="https://prod-flip.adready.com";
    System.out.println(""+isDemoInstance(host));
// String[] domainParts = host.split("\\.");
//    String domainName = host.startsWith("https://") ? host.substring(8) : host;
//    System.out.println("domainName domainName-->"+domainName);
//   String firstFourChars = domainName.substring(0, 4);
//    System.out.println("firstFourChars -->"+firstFourChars);
//    System.out.println("domainName domainName-->"+domainName);
//    System.out.println("extractDomainName-->"+ extractDomainName(host));
//    System.out.println("domainName-->"+ Arrays.toString(domainParts));
//    for(int i=0;i<domainParts.length;i++){
//      System.out.println(domainParts[i]);
//    }
  }
}

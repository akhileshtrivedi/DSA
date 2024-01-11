package intermediate.dec_7;

class MagicNumberHW
{
    static int s=0;
    public static void main(String args[])
    {
        MagicNumberHW ob=new MagicNumberHW();
        System.out.println(""+ob.Magic_Check(83557));
        System.out.println(""+ob.Magic_Check(8354));
        System.out.println(""+ob.Magic_Check(82));
//        Scanner in=new Scanner(System.in);
//        System.out.print("Enter a Number:>");
//        int n=in.nextInt();
//        if(ob.Magic_Check(n)==1)
//        {
//            System.out.println(n+" is a MAGIC NUMBER");
//        }
//        else
//        {
//            System.out.println(n+" is NOT a MAGIC NUMBER");
//        }
    }
    public int Magic_Check(int A)
    {
        if (A % 9 == 1){
            return 1;
        } else{
            return 0;
        }
    }
}
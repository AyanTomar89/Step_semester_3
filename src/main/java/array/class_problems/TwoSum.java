import java.util.*;
class TwoSum {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=s.nextInt();
        int t=s.nextInt();
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++)
                if(a[i]+a[j]==t)System.out.println(i+" "+j);
    }
}
public class TARCCode{
public static void printEvens(int num) {int ctr;int mod;ctr = 0;while(ctr<=num){ 
mod = ctr%2;if(mod==0){ 
System.out.print(ctr) ;
} 
ctr = ctr+1;
} 
}
public static void main(String[] args){int num;num = 5;printEvens(num) ;}}
package koushik.leetcode;
//wrong ans
public class minBoats {
    public static void main(String[] args) {
        int[] arr = {4,3,6};
        int l =6;
        System.out.println(numRescueBoats(arr,l));
    }
    public static int numRescueBoats(int[] people, int limit) {
        int count=0;
        if(people.length<3){
            int sum=0;
            for( int i : people){
                sum+=i;
            }
            if(sum<=limit){
                return 1;
            }
        }
        int[] freq=new int[limit+1];
        for(int i : people){
            freq[i]++;
        }
        int s=0,e=freq.length-1;
        while(s<=e){
            if(freq[s]==1 || freq[e]==1 ){
                if(freq[s]==1 && freq[e]==1){
                    freq[s]--;
                    freq[e]--;
                    count++;
                }
                if(freq[s]==0 && freq[e]==1){
                    freq[e]--;
                    count++;
                }
                if(freq[s]==1 && freq[e]==0){
                    freq[s]--;
                    count++;
                }
            }
            if(freq[s]>1 || freq[e]>1){
                if(freq[s]>=1 && freq[e]>=1){
                    freq[s]--;
                    freq[e]--;
                    count++;
                }
                if(freq[s]==0 && freq[e]>1){
                    int temp=(e*freq[e]);
                    if(temp>limit){
                        if(temp%limit==0){
                            count+=temp/limit;
                        }
                        else{
                            temp=(temp+(limit-(temp%limit)));
                            count+=temp/limit;
                        }
                    }
                    freq[e]=0;
                }
                if(freq[s]>1 && freq[e]==0){
                    int temp=(s*freq[s]);
                    if(temp>limit){
                        if(temp%limit==0){
                            count+=temp/limit;
                        }
                        else{
                            temp=(temp+(limit-(temp%limit)));
                            count+=temp/limit;
                        }
                    }
                    freq[s]=0;
                }
            }
            if(freq[s]<1 && freq[e]<1){
                s++;
                e--;
            }
        }
        return count;
    }
}

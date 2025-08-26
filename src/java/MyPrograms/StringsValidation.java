import java.util.*;

public class StringsValidation
{
    public static void main(String[] args) {
        largestSumContiguous();
    }
    public static void asendingDesendingNumbers()
    {
        int[] a = {10,6,8,9,2,3,2,4,5};
        for(int i=0;i<=a.length;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                if(a[i]>a[j])
                {
                    int temp = a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        for (int j : a) {
            System.out.print(" " + j);
        }
    }

    public static void asendingDesendingStrings()
    {
        String[] a = {"apple", "oranges", "bananas", "Strawberry", "Blueberry"};
        for(int i=0;i<=a.length;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                if(a[i].compareTo(a[j])<0)
                {
                    String temp = a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        for (String j : a) {
            System.out.print(" " + j);
        }
    }

    public static void palindromeBasic()
    {
        String s = "malayalam";
        for(int i=0,j=s.length()-1;i<s.length()/2 && j>s.length()/2;i++,j--)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                System.out.println("Not an palindrome");
                return;
            }
        }
        System.out.println("is a palindrome");
    }

    public static void distinctCharsinString()
    {
        String s = "sugumaraabbccnntt";
        String res="";
        String dupl="";
        for(char c:s.toCharArray())
        {
            if(res.indexOf(c)==-1)
            {
                res=res+c;
            }
            else
            {
                dupl=dupl+c;
            }
        }
        System.out.println(res);
        System.out.println(dupl);
    }

    public static void reverseNumber()
    {
        int num=2435;
        int reverse =0;
        while(num!=0)
        {
            int rem = num%10;
            reverse = reverse*10 + rem;
            num/=10;
        }
        System.out.println(reverse);
    }

    static boolean isVowel(char c)
    {
        return (  c == 'e' || c == 'i' || c == 'o'  || c == 'u');
    }

    public static void vowel()
    {
        String s1 = "ilovezoho";
        int j = 0;
        char[] s = s1.toCharArray();
        String vowel = "";

        for (int i = 0; i < s.length; i++) {
            if (!isVowel(s[i])) {
                j++;
                vowel = vowel + s[i];
            }
        }
        System.out.println(vowel);
        for (int i = 0; i < s.length; i++) {
            if (!isVowel(s[i])) {
                s[i] = vowel.charAt(--j);
            }
        }
        System.out.println(String.valueOf(s));
    }

    public static void sortNumberOneNegativeOnePositive()
    {
        int[] arr = { -1, 6, 9, -4, -10, -9, 8, 8, 4 };
        int len = arr.length;
        int[] k = new int[len];
        int pos = 0;
        int neg = 1;
        for (int j : arr) {
            if (j > 0) {
                k[pos] = j;
                pos = pos + 2;
            }
            if (j < 0) {
                k[neg] = j;
                neg = neg + 2;
            }
        }
        System.out.println(Arrays.toString(k));
    }

    public static void primeNumber()
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num >0 && num<4 )
        {
            System.out.println(num+" is a prime number");
        }
        if(num%2==0 || num%3==0)
        {
            System.out.println(num+" is not a prime number");
        }
        for(int i = 5; i < (int)Math.log(num); i++)
        {
            if(num%i==0)
            {
                System.out.println(num+" is not a prime number");
                return;
            }
        }
        System.out.println(num+" is a prime number");
    }

    public static void occurenceOfElements()
    {
//        int[] a = { 1, 2, 3, 4, 4, 3, 10, 80, 10, 1, 1, 1, 2, 3, 4, 4, 10, 10 };
        String str = "Being Men is a Sin";
        char[] a = str.toCharArray();
        int[] k = new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            int count =1;
            for(int j=i+1;j<a.length;j++)
            {
                if(a[i]==a[j])
                {
                    count++;
                    k[j]=-1;
                }
            }
            if(k[i]!=-1)
            {
                k[i]=count;
            }
        }
        System.out.println(Arrays.toString(k));
    }

    public static void longestPalindromeSubstring()
    {
//         "abcdadvaaannncccctuuuussssss";
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s.length()==1)
        {
            System.out.println(s+" is the longest panlindrome");
        }
        int max = Integer.MIN_VALUE;
        String maxString="";
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<=s.length();j++)
            {
                if(palindrome(s.substring(i,j)))
                {
                    int length = s.substring(i, j).length();
                    if(length >max)
                    {
                        max = length;
                        maxString = s.substring(i, j);
                    }
                }
            }
        }
        System.out.println("Longest palindrome is "+maxString+" with "+max+" length.");
    }

    public static boolean palindrome(String s)
    {
        for(int i=0,j=s.length()-1;i<s.length()/2 && j>s.length()/2;i++,j--)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }

    public static void longestPalindromeFaster()
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String LPS = "";

        for(int i=1;i<s.length();i++)
        {
            //odd length palindrome
            int low=i;
            int high=i;
            while(s.charAt(low)==s.charAt(high))
            {
                low--;
                high++;
                if(low==-1 || high==s.length())
                {
                    break;
                }
            }
            String palindrome = s.substring(low+1,high);
            if(palindrome.length() > LPS.length())
            {
                LPS=palindrome;
            }
            //even length palindrome
            low=i-1;
            high=i;
            while (s.charAt(low)==s.charAt(high))
            {
                low--;
                high++;
                if(low==-1 || high==s.length())
                {
                    break;
                }
            }
            palindrome = s.substring(low+1,high);
            if(palindrome.length() > LPS.length())
            {
                LPS=palindrome;
            }
        }
        System.out.println(LPS);
    }

    public static void subset()
    {
        char[] nums = {'s', 'i', 'v', 'q'};
        //  int[] nums = {1, 2, 3, 4, 5, 7, 8, 9, 5};
        List<List<Character>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int s = 0;
        for(char n:nums){
            s = result.size();
            for(int i = 0;i<s;i++){
                List<Character> set = new ArrayList<>(result.get(i));
                set.add(n);
                result.add(set);
            }
        }
        System.out.print(result);

    }

    public static void countOfElementslessOrEqualToKey()
    {
        int arr[] = {1, 2, 4, 11, 11, 16};
        int key = 11;

        int left = 0;
        int right = arr.length - 1;

        int count = 0;

        while (left <= right) {
            int mid = (right + left) / 2;

            if (arr[mid] <= key) {
                count = mid + 1;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        System.out.println(count);
    }

    public static void sumOfKcornerElements()
    {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(8, 4, 4, 8, 12, 3, 2, 9));
        int sumValue = 3;

        Integer max = Integer.MIN_VALUE;

        for (int i = 0; i <= sumValue; i++) {
            int sum = 0;
            // sum start
            for (int start = 0; start < i; start++)
            {
                sum = sum + arr.get(start);
            }
            for (int end = 0; end < sumValue - i; end++)
            {
                sum = sum + arr.get(arr.size() - 1 - end);
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    public static void countUnitDigitInGivenRage()
    {
        Map<Integer,Integer> usedMap = new HashMap<>();
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 9, 6, 5, 8, 3, 4));
        int sum = 9;

        for(int i=0;i<input.size()-1;i++)
        {
            if(!usedMap.containsKey(input.get(i)))
            {
                for(int j=i+1;j<input.size();j++)
                {
                    if(sum-input.get(i)==input.get(j))
                    {
                        System.out.println("["+input.get(i)+", "+input.get(j)+"]");
                        usedMap.put(input.get(j),1);
                    }
                }
            }
            usedMap.put(input.get(i),1);
        }
    }

    public static void largestSumContiguous()
    {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        System.out.println(max_so_far);

    }
}
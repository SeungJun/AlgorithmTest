package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 10진수 또는 16진수를, 2진수로 변환 출력 (32비트 정수)
//        System.out.println(Integer.toBinaryString(0)); // 0
//        System.out.println(Integer.toBinaryString(1)); // 1
//        System.out.println(Integer.toBinaryString(255)); // 11111111
//        System.out.println(Integer.toBinaryString(0xFFFF)); // 1111111111111111
//        System.out.println(Integer.toBinaryString(0xFFFFFFFF)); // 11111111111111111111111111111111
//        System.out.println(Integer.toBinaryString(0xFFFFFFFF - 1)); // 11111111111111111111111111111110

        // 이진수 앞의 빈자리는 0으로 채워지는데, 그 0의 숫자입니다.
//    System.out.println(Integer.numberOfLeadingZeros(1)); // 31

//        BinaryGap();
//        CyclicRotation();
//        OddOccurrencesInArray();

//        Frogjmp();
//        PermMissingElem();

//        demoTask();
//        task2();
//        task3();

        //ebaytest
        isPrime();

/*
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        long _n;
        _n = Long.parseLong(in.nextLine().trim());

        res = isPrime(_n);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
*/

    }

    public static void isPrime() {



    }

    public static int PermMissingElem(){

        int[] A = {2,3,1,5};
//        int[] A = {};

        long size = A.length;
        if(size == 0)
            return 1;
        else if(size == 1 && A[0] == 1)
            return 2;

        long total = (size * (size + 1)) / 2;
        int i = 0;
        for(; i < size; i++) {
            if(A[i] <= size)
                total -= ((long) A[i]);
        }
        return (total == 0 ? i + 1 : (int) total);

//        System.out.println("=== sList : " + value);

    }

    public static void Frogjmp() {

        int x = 10 ;
        int y = 85 ;
        int d = 30 ;

        int currentLoc = y-x ;
        int turn = currentLoc/d ;
        int turnLeft = currentLoc%d ;

        int jumpResult = turn;

        if(turnLeft > 0){
            jumpResult += 1;
        }

//        System.out.println("JumpResult : " + jumpResult);


    }

    //BinaryGap
    public static void BinaryGap(){

        //        int value = 1041 ;
//        int value = 1024 ;
//        int value = 512 ;
//        int value = 16 ;
        int value = 51712 ;
        //6, 328 , 16, 1024, 51712, 20

        String valueBinary= Integer.toBinaryString(value);
        System.out.println("=== valueBinary : " + valueBinary);

        Integer temp = null;
        int valueLength =0 ;

        //0값 길이를 담는 리스트 생성
        List<Integer> valueTypeLength = new ArrayList<Integer>();
//        System.out.println("length : " + valueBinary.length() );

        for(int i = 0 ; i < valueBinary.length() ;  i++ ){
            System.out.println(i + "," + (i-1) + " / ");

//            System.out.println("== charAt : " + valueBinary.charAt(i)) ;
            int valueRs = Integer.parseInt(String.valueOf(valueBinary.charAt(i)));
            if(valueRs == 0 ){
                if(temp == valueRs) {
//                    System.out.println("== valueLength : " + valueLength);
                    valueLength++;
                }
                else{
                    valueLength = 1;
                }
            }
            else if(valueRs == 1){
                valueTypeLength.add(valueLength);
            }
            temp = valueRs ;

        }

        Collections.sort(valueTypeLength);
        System.out.println("== ValueTypeLength : " + valueTypeLength);
        int length = valueTypeLength.size();
        System.out.println("return : " + valueTypeLength.get(length-1));

    }

    //CyclicRotation
    public static void CyclicRotation(){

        int[] array1 = {3,8,9,7,6};
//        int[] array1 = {3,4,5,6};
//        int[] array1 = {3,4};
//        int[] array1 = {2,3,4,5,6,7,1};
        int k = 2;
        int[] resultArray = new int[array1.length];
        int length = array1.length;
        int temp = 0 ;

/*        if(k<= length) {

            for (int i = 0; i < length; ++i) {

                if (i + k >= length) {
                    temp = (i + k) - length;
                    resultArray[temp] = array1[i];
                } else {
                    resultArray[i + k] = array1[i];
                }
            }
        }*/

/*        else{
            for (int i = 0; i < length; ++i) {
                temp = k-length;

            }

        }*/

        for (int i = 0; i < length; ++i) {
                temp = (i + k)%length;
                resultArray[temp] = array1[i];

        }

        for(int i =0 ; i <length ; i ++ ){
            System.out.println("=== array1 : " + resultArray[i]);

        }

    }

    //OddOccurrencesInArray
    public static int OddOccurrencesInArray(){

//        int[] array1 = {9,3,9,3,4};
        int[] array1 = {9,3,9,3,9,7,9};
//        int[] array1 = {9,3,9,3,9,7,9,4,5,4,5};

        int length = array1.length;
        Set<Integer> disSet = new HashSet<Integer>();

        Integer result = null;

        Arrays.sort(array1);


        for(int i = 0 ; i<length-1 ; i++ ){
            if(array1[i] == array1[i+1]){
                disSet.add(array1[i]);
            }

        }

        for(int i =0 ; i< length ; i++){
            if(!disSet.contains(array1[i])){
                System.out.println("=== except Set : " + array1[i]);
                result = array1[i];
            }
        }

        System.out.println("=== except array : " + result);

        return result ;


    }

    //skTechX demoTest
    public static void demoTask(){

        int[] array = {-1,3,-4, 5, 1, -6, 2, 1};
//        int[] array = {1082132608, 0, 1082132608};
        int length = array.length;
        int frontSum = 0 ;
        int backSum = 0 ;
        int valueCount =0 ;
//        List<Integer> equilibrium = new ArrayList<Integer>();
        Integer result =null ;

        for(int i = 0 ; i<length ; i++){


            for(int j = 0 ; j<length ; j++){
                if(j>i ){
                    backSum += array[j];
                }
                if(j<i){
                    frontSum += array[j];
                }
            }
            System.out.println("backsum : " + backSum);



            System.out.println("frontsum : " + frontSum);
            if(frontSum == backSum){
                valueCount ++;
                System.out.println(">> result I : " + i + " , valueCount : " + valueCount);
//                equilibrium.add(array[i]);
                result = i;
            }
            frontSum =0 ;
            backSum =0;

            System.out.println("== i: " + i + ", array : " + array[i]);

        }

/*        int[] resultArray = new int[valueCount];
        int size =0;
        for(Integer equili : equilibrium){
            resultArray[size++] = equili;
        }
            System.out.println(" resultArray : " + resultArray);
        */

        if(result != null){
            System.out.println("[result] : " + result);
        }
        else{
            result = -1;
            System.out.println("[result] : " + result);
        }

    }

    public static void task1() {
        int a,b,c,d;


    }

    public static void task2(){

        String startDate = "10:00";
//        String endDate = "13:21";
//        String startDate = "15:12";
        String endDate = "11:42";
//        String endDate = "15:12";

        int shour = Integer.parseInt(startDate.substring(0,startDate.indexOf(":")));
        int ehour = Integer.parseInt(endDate.substring(0,endDate.indexOf(":")));
        int ptime = 0;

        int smin = Integer.parseInt(startDate.substring(startDate.indexOf(":")+1));
        int emin = Integer.parseInt(endDate.substring(endDate.indexOf(":")+1));
        int partialHour = 0;

        //시작시간 분침시간이 더 클때
        if(smin > emin){
            partialHour = 60-smin+ emin ;
            ptime = ehour-shour-1;
        }
        //시작시간 분침시간이 더 작을 떄
        else{
            partialHour = emin - smin ;
            ptime = ehour - shour;
        }

        //결제요금
        int resultFee = 0;

        //case1. 1시간 이상 주차
        if(ptime > 0 ){
            resultFee =+2 +3 + (ptime-1)*4;
            if(partialHour > 0){
                resultFee = resultFee + 4;
            }
        }
        //case2. 1시간 미만 주차
        else if ( ptime ==0 ){
            resultFee = 2;
        }




        System.out.println("resultFee : " + resultFee);

    }

    public static void task3(){
//        int[] array = {1,5,3,3,7};
//        int[] array = {1,3,5,3,4};
        int[] array = {1,3,5};

        int length = array.length;
        List<Integer> list = new ArrayList<>();

        for(Integer value : array){
            list.add(value);
        }

        Collections.sort(list);

        int count=0 ;

        for (int i = 0 ; i<length ; i++){
            if(list.get(i) != array[i]){
                count++;
            }

        }

        System.out.println("count : " + count);
        if(count <= 2 && count >=0 ){
            System.out.println(" True ");

        }
        else{
            System.out.println("False");
        }
    }
}



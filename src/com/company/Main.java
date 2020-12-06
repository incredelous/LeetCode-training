package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LeetCode_81 test = new LeetCode_81();
        Scanner scan = new Scanner(System.in);
        int[] nums = get_array(scan);
        int target = get_digit(scan);
        System.out.println(test.search(nums, target));

    }

    public static int[] get_array(Scanner scan) {
        String[] str_arr = scan.nextLine().split(",");
        int[] arr = new int[str_arr.length];
        for(int i = 0; i < str_arr.length; i++) {
            arr[i] = Integer.parseInt(str_arr[i]);
        }
        return arr;
    }

    public static String[] get_str_array(Scanner scan) {
        /**
         * Input Format:
         * "abc", "def", "xyz"
         */
        String[] str_arr = scan.nextLine().split(",");
        for(int i = 0; i < str_arr.length; i++) {
            str_arr[i] = str_arr[i].replaceAll("\"", "");
            str_arr[i] = str_arr[i].strip();
        }
        return str_arr;
    }

    public static char[][] get_2d_char_matrix(Scanner scan, int m, int n){
        char[][] ret = new char[m][n];
        for(int i = 0; i < m; i++) {
            String str = scan.nextLine();
            str = str.replaceAll("\"", "");
            str = str.replaceAll("\'", "");
            str = str.replaceAll(",", "");
            str = str.replaceAll(" ", "");
            char[] char_arr = str.toCharArray();
            for(int j = 0; j < n; j++) {
                ret[i][j] = char_arr[j];
            }
        }
        return ret;
    }

    public static int get_digit(Scanner scan) {
        return Integer.parseInt(scan.nextLine().strip());
    }

    public static String get_str(Scanner scan) {
        return scan.nextLine();
    }

    public static int[][] get_2D_arrays(Scanner scan, int m, int n){
        int[][] ret = new int[m][n];
        for(int i = 0; i < m; i++) {
            String[] str_arr = scan.nextLine().split(",");
            for(int j = 0; j < n; j++) {
                ret[i][j] = Integer.parseInt(str_arr[j]);
            }
        }
        return ret;
    }

    public static ListNode get_listnode(Scanner scan) {
        String[] str_arr = scan.nextLine().split("->");
        ListNode now = null;
        ListNode head = null;
        for(int i = 0; i < str_arr.length; i++) {
            if(head == null) {
                head = new ListNode(Integer.parseInt(str_arr[i]));
                now = head;
            } else {
                now.next = new ListNode(Integer.parseInt(str_arr[i]));
                now = now.next;
            }
        }
        return head;
    }
}

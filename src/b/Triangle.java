package b;

import java.util.Scanner;

public class Triangle {
	public static int a;
	public static int b;
	public static int c;
	private static Scanner sc1=null;
	public static int WhatTriangle(int a,int b,int c){
		if(a>=0&&a<=200&&b>=0&&b<=200&&c>=0&&c<=200){
			if(a+b>c&&a+c>b&&b+c>a){
				if(a==b&&b==c&&a==c){
					System.out.println("等边三角形！");
					return 1;
				}
				if(a==b||a==c||b==c){
					System.out.println("等腰三角形！");
					return 2;
				}
				if(a*a+b*b==c*c||a*a+c*c==b*b||c*c+b*b==a*a){
					System.out.println("直角三角形！");
					return 3;
				}
				if(a!=b||a!=c||b!=c){
					System.out.println("一般三角形！");
					return 4;
				}
				
			}
			else{
				System.out.println("不能构成三角形！");
				return 5;
			}
		}
		else{
			System.out.println("大小输入错误！");
			return 6;
		}
		return 0;
	}
	public static void main(String[] args) {
		a=WhatTriangle(6,6,3);
	}
}

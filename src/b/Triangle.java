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
					System.out.println("�ȱ������Σ�");
					return 1;
				}
				if(a==b||a==c||b==c){
					System.out.println("���������Σ�");
					return 2;
				}
				if(a*a+b*b==c*c||a*a+c*c==b*b||c*c+b*b==a*a){
					System.out.println("ֱ�������Σ�");
					return 3;
				}
				if(a!=b||a!=c||b!=c){
					System.out.println("һ�������Σ�");
					return 4;
				}
				
			}
			else{
				System.out.println("���ܹ��������Σ�");
				return 5;
			}
		}
		else{
			System.out.println("��С�������");
			return 6;
		}
		return 0;
	}
	public static void main(String[] args) {
		a=WhatTriangle(6,6,3);
	}
}

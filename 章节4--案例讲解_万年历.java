import java.util.Scanner;

public class PrintCalenda {
	public static void main(String[] args) {
		int year;// 保存输入的年
		int month;// 保存输入的月
		boolean isRn;// 闰年保存true,否则为false
		int days = 0;// 保存指定月的天数
		System.out.println("**************使用万年历**************");
		Scanner input = new Scanner(System.in);
		System.out.print("请输入年:");
		year = input.nextInt();
		System.out.print("请输入月:");
		month = input.nextInt();

		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			isRn = true;
		} else {
			isRn = false;
		}
		if (isRn) {
			System.out.println(year + "是闰年");
		} else {
			System.out.println(year + "非闰年");
		}

		/*
		 * if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
		 * days=31; }else if(month==2){ if(isRn){ days=29; }else{ days=28; } }else
		 * if(month==4||month==6||month==9||month==11){ days=30; }else{
		 * System.out.println("输入月份有误"); }
		 */

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 2:
			if (isRn) {
				days = 29;
			} else {
				days = 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			System.out.println("输入月份有误");
		}

		System.out.println(year + "年" + month + "月对应的天数为:" + days);

	}
} 

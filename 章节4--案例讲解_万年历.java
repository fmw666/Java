import java.util.Scanner;

public class PrintCalenda {
	public static void main(String[] args) {
		int year;// �����������
		int month;// �����������
		boolean isRn;// ���걣��true,����Ϊfalse
		int days = 0;// ����ָ���µ�����
		System.out.println("**************ʹ��������**************");
		Scanner input = new Scanner(System.in);
		System.out.print("��������:");
		year = input.nextInt();
		System.out.print("��������:");
		month = input.nextInt();

		if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
			isRn = true;
		} else {
			isRn = false;
		}
		if (isRn) {
			System.out.println(year + "������");
		} else {
			System.out.println(year + "������");
		}

		/*
		 * if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
		 * days=31; }else if(month==2){ if(isRn){ days=29; }else{ days=28; } }else
		 * if(month==4||month==6||month==9||month==11){ days=30; }else{
		 * System.out.println("�����·�����"); }
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
			System.out.println("�����·�����");
		}

		System.out.println(year + "��" + month + "�¶�Ӧ������Ϊ:" + days);

	}
}
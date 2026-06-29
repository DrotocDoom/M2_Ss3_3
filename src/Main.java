import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double salary;
        int total_employee = 0;
        double total_salary = 0;
        double total_bonus = 0;
        double max_salary = Double.MIN_VALUE;
        double min_salary = Double.MAX_VALUE;
        float bonus_rate = 0;
        do {
            System.out.println("*************MENU NHẬP LƯƠNG***************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiện thị thống kế");
            System.out.println("3. Tính tổng số tiền thưởng cho nhân viên");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 ->{
                    do {
                        System.out.print("Nhập lương: ");
                        salary = Double.parseDouble(scanner.nextLine());
                        if(salary < -1 || salary > 500000000) {
                            System.out.println("Lương không hợp lệ. Nhập lại.");
                            System.out.print("Nhập lương: ");
                            salary = Double.parseDouble(scanner.nextLine());
                        }
                        if (salary == -1){
                            break;
                        }
                        // Cập nhật thống kê
                        total_employee++;
                        total_salary += salary;

                        if (salary > max_salary) {
                            max_salary = salary;
                        }

                        if (salary < min_salary) {
                            min_salary = salary;
                        }
                        if (salary < 5000000) {
                            bonus_rate = 0.05f;
                            System.out.println("Phân Loại: Thấp");
                        } else if (salary < 15000000) {
                            bonus_rate = 0.1f;
                            System.out.println("Phân Loại: Trung bình");
                        } else if (salary < 50000000) {
                            bonus_rate = 0.15f;
                            System.out.println("Phân Loại: Khá");
                        } else {
                            System.out.println("Phân Loại: Cao");
                            if (salary >= 100000000) {
                                bonus_rate = 0.25f;
                            } else {
                                bonus_rate = 0.2f;
                            }
                        }
                        total_bonus += salary * bonus_rate;
                    }while(salary != -1);
                }
                case 2 ->{
                    if (total_employee == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        System.out.println("\n===== THỐNG KÊ =====");
                        System.out.println("Số nhân viên: " + total_employee);
                        System.out.printf("Tổng lương: %.1f VND\n", total_salary);
                        System.out.printf("Lương trung bình: %.1f VND\n", total_salary / total_employee);
                        System.out.printf("Lương cao nhất : %.1f VND\n", max_salary);
                        System.out.printf("Lương thấp nhất: %.1f VND\n", min_salary);
                    }
                    break;
                }
                case 3 ->{
                    if (total_employee == 0) {
                        System.out.println("Chưa có dữ liệu.");
                    } else {
                        System.out.printf("Tổng số tiền thưởng cho nhân viên: %.1f VND1\n", total_bonus);
                    }
                }
                case 4 ->{
                    System.out.println("Kết thúc chương trình.");
                    scanner.close();
                    System.exit(0);
                }
                default ->{
                    System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }while (true);
    }
}
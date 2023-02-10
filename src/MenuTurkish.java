import java.util.Scanner;

public class MenuTurkish extends Account{
    Scanner scanner = new Scanner(System.in);
    public MenuTurkish(String customerName) {
        super(customerName);
    }

    public void menuGoster(){
        System.out.println("Hoşgeldiniz " + customerName);
        String options = "1.Para yatır\n"
                +"2.Para çek\n"
                +"3.Faizi göster\n"
                +"4.Bakiyeyi göster\n"
                +"5.Önceki işlemi göster\n"
                +"6.Menüyü tekrar göster\n"
                +"7.Çıkış(e'ye bas)";
        System.out.println(options);
        while (true) {
            System.out.print("İşlem seçiniz :");
            String islem = scanner.nextLine();
            switch (islem) {
                case "1":
                    System.out.print("Yatırmak istediğiniz miktar : ");
                    int miktar = scanner.nextInt();
                    super.deposit(miktar);
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.print("Çekmek istediğiniz miktar : ");
                    int miktar2 = scanner.nextInt();
                    if (miktar2 > balance) {
                        System.out.println("Hesabınızda çekmek istediğiniz miktar bulunmuyor.");
                        break;
                    } else {
                        super.withdraw(miktar2);
                        scanner.nextLine();
                        break;
                    }
                case "3":
                    System.out.print("Kaç yıllık faizi öğrenmek istiyorsunuz ? ");
                    int yil = scanner.nextInt();
                    super.intereset(yil);
                    System.out.println("Yeni bakiye : " + balance);
                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Bakiyeniz : " + balance);
                    break;
                case "5":
                    System.out.println("Önceki işlem : ");
                    getPreviousTransaction();
                case "6":
                    System.out.println(options);
                    break;
                /*case "e":
                    System.out.println("Uygulamadan çıkılıyor");
                    break;*/
                /*default:
                    System.out.println("Geçersiz işlem");
                    break;*/
            }
            if (islem.equals("e") || islem.equals("7") ){
                System.out.println("Uygulamadan çıkılıyor");
                break;
            }
        }
    }
}

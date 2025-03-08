import java.util.Scanner;

public class UserInterface {

    public static void tampilkanMenu() {
        System.out.println();
        System.out.println("+===============+");
        System.out.println("|   Pilih Menu  |");
        System.out.println("+---------------+");
        System.out.println("|  [C] : Create |");
        System.out.println("|  [R] : Read   |");
        System.out.println("|  [U] : Update |");
        System.out.println("|  [D] : Delete |");
        System.out.println("|  [E] : Exit   |");
        System.out.println("+===============+");
    }
    public static void main(String[] args) {
        Database db = new Database();
        System.out.println("APLIKASI SIMPLE CRUD TEXT DATABASE");
        while (true){
            tampilkanMenu();
            Scanner input = new Scanner(System.in);
            System.out.print("Pilih : ");
            String pilihan = input.nextLine();
            pilihan = pilihan.toUpperCase();

            switch (pilihan){
                case "C":
                    System.out.println("INFO: Anda memilih menu Create");
                    System.out.println("---------------------------------------------");
                    System.out.println("INPUT DATA BARU");
                    System.out.print("NIM            : ");
                    String nim = input.nextLine();
                    System.out.print("NAMA MAHASISWA : ");
                    String nama = input.nextLine();
                    System.out.print("ALAMAT         : ");
                    String alamat = input.nextLine();
                    System.out.print("SEMESTER       : ");
                    int semester = input.nextInt();
                    System.out.print("SKS            : ");
                    int sks = input.nextInt();
                    System.out.print("IPK            : ");
                    double ipk = input.nextDouble();
                    input.nextLine();
                    System.out.println("--------------------------------------------");
                    boolean status = db.insert(nim,nama,alamat,semester,sks,ipk);
                    if(status == true){
                        System.out.println("DATA BARU BERHASIL DITAMBAHKAN");
                    }else{
                        System.out.println("NIM " + nim + " sudah ada di database");
                        System.err.println("GAGAL MENAMBAHKAN DATA BARU");
                    }
                    System.out.println("--------------------------------------------");
                break;
                case "R":
                    System.out.println("INFO: Anda memilih menu Read");
                    db.view();
                break;
                case "U":
                    System.out.println("INFO: Anda memilih menu UPDATE");
                    db.view();
                    System.out.print("Input key (NIM Mahasiswa yang akan diupdate): ");
                    String key = input.nextLine();
                    int index = db.search(key);
                    if (index >= 0){
                        System.out.println("Anda akan meng-update data " + db.getData().get(index));

                        System.out.println("---------------------------------------------");
                        System.out.println("INPUT DATA BARU");
                        System.out.print("NIM            : ");
                        nim = input.nextLine();
                        System.out.print("NAMA MAHASISWA : ");
                        nama = input.nextLine();
                        System.out.print("ALAMAT         : ");
                        alamat = input.nextLine();
                        System.out.print("SEMESTER       : ");
                        semester = input.nextInt();
                        System.out.print("SKS            : ");
                        sks = input.nextInt();
                        System.out.print("IPK            : ");
                        ipk = input.nextDouble();
                        input.nextLine();
                        System.out.println("--------------------------------------------");
                        status= db.update(index, nim, nama, alamat, semester, sks, ipk);
                        if (status == true){
                            System.out.println("DATA BERHASIL DIPERBAHARUI");
                        }else{
                            System.err.println("GAGAL MEMPERBAHARUI DATA");
                        }
                        System.out.println("--------------------------------------------");
                    }else{
                        System.err.println("Mahasiswa dengan NIM: " + key + " tidak ada di database");
                    }
                break;
                case "D":
                    System.out.println("INFO: Anda memilih menu delete");
                    db.view();
                    System.out.print("Input key (NIM Mahasiswa yang akan dihapus): ");
                    key = input.nextLine();
                    index = db.search(key);
                    if (index >= 0){
                        System.out.println("APAKAH ANDA YAKIN AKAN MENGHAPUS DATA " + db.getData().get(index));
                        System.out.print("Pilih : ");
                        pilihan = input.nextLine();
                        if (pilihan.equalsIgnoreCase("Y")){
                            status = db.delete(index);
                            if (status == true){
                                System.out.println("DATA BERHASIL DIHAPUS");
                            }else{
                                System.err.println("GAGAL MENGHAPUS DATA");
                            }
                        }
                    }else{
                        System.err.println("Mahasiswa dengan NIM: " + key + " tidak ada di database");
                    }
                    break;
                case "X":
                    System.out.println("INFO: Anda memilih menu EXIT");
                    System.out.println("APAKAH ANDA YAKIN AKAN KELUAR DARI APLIKASI? Y/N");
                    System.out.print("Pilih: ");
                    pilihan = input.nextLine();
                    if (pilihan.equalsIgnoreCase("Y")){
                        System.exit(0);
                    }
                    break;
            }
        }
    }
}

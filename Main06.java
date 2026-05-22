import java.util.Scanner;
public class Main06 {
         public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // membuat object Linked List antrean 
        DLLPembeli06 antrian = new DLLPembeli06();
        // membuat object Linked List pesanan
        DLLPesanan06 pesanan = new DLLPesanan06();

        int menu;
        // nomor antrean otomatis 
        int nomorAntrian = 1;

        do {

            System.out.println("================================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("5. Cetak Antrean Terbalik");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");

            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                // MENU TAMBAH ANTRIAN 
                case 1:

                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();

                    System.out.print("No HP : ");
                    String hp = sc.nextLine();
                    // membuat object pembeli 
                    Pembeli06 p = new Pembeli06(
                            nomorAntrian,
                            nama,
                            hp);
                    // menambah ke Linkes list
                    antrian.addLast(p);

                    System.out.println(
                            "Antrian berhasil ditambahkan dengan nomor : "
                            + nomorAntrian);
                    // nomor antrean bertambah otomatis 
                    nomorAntrian++;

                    break;
                // MENU CETAK ANTRIAN
                case 2:

                    antrian.print();

                    break;
                // MENU HAPUS ANTRIAN + PESANAN 
                case 3:

                    // menghapus antrean
                    Pembeli06 data = antrian.removeFirst();
                    // jika tidak ditemukan
                    if (data == null) {

                        System.out.println("Antrian kosong");

                    } else {
                        // input pesanan makanan
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();

                        System.out.print("Harga : ");
                        int harga = sc.nextInt();
                        // membuat object pesanan
                        Pesanan06 ps = new Pesanan06(
                                kode,
                                namaPesanan,
                                harga,
                                data.namaPembeli);
                        // simpan ke Linked List pesanan
                        pesanan.addLast(ps);

                        System.out.println(
                                data.namaPembeli
                                + " telah memesan "
                                + namaPesanan);
                    }

                    break;
                // MENU LAPORAN PESANAN
                case 4:
                    pesanan.print();
                    break;
                // MENU CETAK TERBALIK
                case 5:
                    antrian.cetakTerbalik();
                    break;
                // MENU KELUAR
                case 0:
                    System.out.println("Program selesai");
                    break;

                default:

                    System.out.println("Menu tidak tersedia");
            }

        } while (menu != 0);
    }
}

public class DLLPesanan06 {

     NodePesanan06 head, tail;
    // mengecek apakah list kosong
    public boolean isEmpty() {
        return head == null;
    }

    // menambahpesanan dibelakang list
    public void addLast(Pesanan06 data) {
        // membuat node baru
        NodePesanan06 newNode = new NodePesanan06(null, data, null);
        // jiks lidt kosong
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            // sambung tail lama ke node baru
            tail.next = newNode;
            // prev node baru menunjuk tail lama
            newNode.prev = tail;
            // pindahkan tail
            tail = newNode;
        }
    }

    // sorting manual bubble sort berdasarkan nama pesanan
    public void sortNamaPesanan() {
        // jika list kosong
        if (head == null) {
            return;
        }

        boolean tukar;

        do {
            tukar = false;
            // traversal dari head
            NodePesanan06 current = head;

            while (current.next != null) {
                // compareTOIgnoreCase
                // membandingkan string alfabet 
                if (current.data.namaPesanan.compareToIgnoreCase(
                        current.next.data.namaPesanan) > 0) {
                    // proses swap data
                    Pesanan06 temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    tukar = true;
                }
                // pindah ke node berikutnya 
                current = current.next;
            }

        } while (tukar);
    }

    // menampilkan laporan pesanan
    public void print() {
        // cek list kosong
        if (isEmpty()) {
            System.out.println("Belum ada pesanan");
            return;
        }
        // sorting sebelum tampil
        sortNamaPesanan();

        NodePesanan06 current = head;
        // menyimpan total pendapatan
        int total = 0;

        System.out.println("======================================");
        System.out.println("LAPORAN PESANAN");
        System.out.println("======================================");

        System.out.printf("%-10s %-15s %-10s %-15s\n",
                "Kode",
                "Pesanan",
                "Harga",
                "Pembeli");
        // traversal seluruh node
        while (current != null) {

            System.out.printf("%-10d %-15s %-10d %-15s\n",
                    current.data.kodePesanan,
                    current.data.namaPesanan,
                    current.data.harga,
                    current.data.namaPembeli);
            // menjumlah total pendapatan
            total += current.data.harga;

            current = current.next;
        }

        System.out.println("======================================");
        System.out.println("Total Pendapatan : " + total);
    }
}
public class DLLPembeli06 {

    // head = node pertama 
    // tail = node terakhir 
     NodePembeli06 head, tail;

    // mengecek apakah linked list kosong 
    public boolean isEmpty() {
        return head == null;
    }

    // menghapus antrean paling depan (FIFO)
    public Pembeli06 removeFirst() {

    // jika linked list kosong
    if (isEmpty()) {
        return null;
    }

    // simpan data head
    Pembeli06 data = head.data;

    // jika hanya ada 1 node
    if (head == tail) {

        // head dan tail dibuat null
        head = tail = null;

    } else {

        // head pindah ke node berikutnya
        head = head.next;

        // prev head dibuat null
        head.prev = null;
    }

    // mengembalikan data pembeli
    return data;
}

    // menambah data dibelakang linked list
    public void addLast(Pembeli06 data) {
        //membuat node baru 
        NodePembeli06 newNode = new NodePembeli06(null, data, null);
        // jika list kosong 
        if (isEmpty()) {
            // head dan tail menunjuk node baru
            head = tail = newNode;
        } else {
            //sambung tail lama ke node baru
            tail.next = newNode;
            //prev node baru menunjuk tail lama
            newNode.prev = tail;
            // pindahkan tail ke node baru
            tail = newNode;
        }
    }

    // menampilkan seluruh antrean
    public void print() {
        //cek apakah list kosong 
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        // current digunakan untuk traversal 
        NodePembeli06 current = head;

        System.out.println("=================================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("=================================");
        System.out.printf("%-10s %-15s %-15s\n",
                "No", "Nama", "No HP");
        // looping sampai node terakhir 
        while (current != null) {
            System.out.printf("%-10d %-15s %-15s\n",
                    current.data.noAntrian,
                    current.data.namaPembeli,
                    current.data.noHp);
            // pindah ke node berikutnya
            current = current.next;
        }
    }
    // Method Cetak terbalik
    // menampilkan antrean dari belakang ke depan
    public void cetakTerbalik() {
    // cek apakah list kosong
    if (isEmpty()) {
        System.out.println("Antrian kosong");
        return;
    }
    // traversal dimulai dari tail
    NodePembeli06 current = tail;

    System.out.println("=================================");
    System.out.println("Daftar Antrian Terbalik");
    System.out.println("=================================");
    System.out.printf("%-10s %-15s %-15s\n",
            "No", "Nama", "No HP");

    // traversal mundur menggunakan prev
    while (current != null) {
        System.out.printf("%-10d %-15s %-15s\n",
                current.data.noAntrian,
                current.data.namaPembeli,
                current.data.noHp);
        // pindah ke node sebelumnya
        current = current.prev;
    }
}

    // menghapus data berdasarkan nomor antrean
    public Pembeli06 remove(int noAntrian) {
        //jika list kosong 
        if (isEmpty()) {
            return null;
        }
        // mulai pencarian dari head
        NodePembeli06 current = head;
        // traversal mencari nomor antrean 
        while (current != null) {
            //jika ditemukan
            if (current.data.noAntrian == noAntrian) {

                // kasus node pertama (head)
                if (current == head) {
                    // head pindah ke node berikutnya 
                    head = head.next;
                    // jika head tidal null
                    if (head != null) {
                        // prev head dibuat null
                        head.prev = null;
                    }
                }

                // kasus node terakhir (tail)
                else if (current == tail) {
                    // tail pindah ke node sebelumnya 
                    tail = tail.prev;
                    // next tail dibuat null
                    tail.next = null;
                }

                // kasus node tengah
                else {
                    // dihubungkan ke next cyrrent
                    current.prev.next = current.next;
                    // node setelah current
                    // dibuhungkan ke prev current
                    current.next.prev = current.prev;
                }
                // mengembalikan data pembeli 
                return current.data;
            }
            // pindah ke node berikutnya
            current = current.next;
        }
        // jika data tidak ditemukan 
        return null;
    }
}

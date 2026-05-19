public class NodePesanan06 {
    Pesanan06 data;

    // pointer prev dan next
    NodePesanan06 prev, next;

    // konstruktor node
    public NodePesanan06(NodePesanan06 prev, Pesanan06 data, NodePesanan06 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
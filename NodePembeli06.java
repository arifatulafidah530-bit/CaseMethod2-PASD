public class NodePembeli06 {
    Pembeli06 data;

    // pointer prev dan next
    NodePembeli06 prev, next;

    // konstruktor node
    public NodePembeli06(NodePembeli06 prev, Pembeli06 data, NodePembeli06 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
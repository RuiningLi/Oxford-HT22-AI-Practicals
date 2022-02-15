package search;

public interface Frontier {
    void add(Node node);
    void clear();
    void isEmpty();
    Node remove();
}

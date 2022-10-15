/**
 * Class representing a doubly linked list
 * A node contains a city name, the distance to reach that city, next and previous pointers to link the nodes
 */
public class DistanceNode {
    char city;
    int distance;
    DistanceNode previous;
    DistanceNode next;

    /**
     * Constructor to create a node
     * @param city city name eg. A, B, C
     * @param distance distance to reach a node e.g. 90, 60, 70
     */
    DistanceNode(char city, int distance) {
        this.city = city;
        this.distance = distance;
        previous = null;
        next = null;
    }
}

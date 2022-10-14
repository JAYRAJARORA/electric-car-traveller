import java.util.ArrayList;

public class DistanceNode {
    char node;
    int distance;
    DistanceNode previous;
    DistanceNode next;

    DistanceNode(char node, int distance) {
        this.node = node;
        this.distance = distance;
        previous = null;
        next = null;
    }

    public static ArrayList<Character> minimizeStops(int carRange, int n, DistanceNode head) {
        DistanceNode curNode = head;
        // will contain the list of minimum stops required
        ArrayList<Character> stops = new ArrayList<>();

        // first stop will always be in the list - recharging the car at distance 0
        stops.add(curNode.node);

        int currentStopDistance = 0;

        while(curNode != null) {
            // calculating the total distance travelled so far on a single range, after every recharge it becomes zero
            int distanceTravelledSoFar = 0;

            // iterating till we get to the last node or total distance covered + currentDistance exceeds the car range
            do {
                curNode = curNode.next;
                currentStopDistance = curNode.distance;
                distanceTravelledSoFar += currentStopDistance;
            } while (curNode.next != null && distanceTravelledSoFar + currentStopDistance < carRange);

            // checking if we need to make a stop at previous station
            if (distanceTravelledSoFar + currentStopDistance > carRange) {
                // go to previous node and add it to the stop where car needs to be fully recharged
                curNode = curNode.previous;
                stops.add(curNode.node);
            }
            // if it's a last node in the list, add it as this is the destination stop
            if(curNode.next == null) {
                stops.add(curNode.node);

                return stops;
            }

        }
        
        return stops;
    }
}

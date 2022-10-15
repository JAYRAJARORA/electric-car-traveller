import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Reads the inputs(number of cities(n), car range(C), and distances between cities) and
 * calls the helper function that minimizes the stops between cities
 */
public class ElectricCarTraveller {
    /**
     * nodes in a graph representing the cities
     * (max 19 nodes represented based on assumption that cities are less than 20)
     */
    static char[] cities = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S'};

    /**
     * Main function that is called when the program is run.
     * It read inputs, prepares a doubly linked list, calls the utility function minimizeStops
     * and prints the ArrayList returned
     *
     * @see DistanceNode
     * @param args string arguments
     */
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Please enter the range of the car: ");
            int C = Integer.parseInt(reader.readLine());

            System.out.print("Please enter the number of cities travelled by electric car: ");
            int n = Integer.parseInt(reader.readLine());

            // n-1 distances taken as n cities will have n-1 distances between them, distances are edges between cities
            int[] distances = new int[n - 1];

            System.out.println("Please enter the list of distances between the cities: ");
            // reading distances between cities from the input stream
            for (int i = 0; i < n - 1; i++) {
                System.out.print("Please enter the distance from " + cities[i] + " -> " + cities[i + 1] + ": ");
                distances[i] = Integer.parseInt(reader.readLine());
            }
            // preparing the linked list, adding the first node (A | 0)
            DistanceNode head = new DistanceNode(cities[0], 0);

            // pointer that points to the current node and links new pointers
            DistanceNode cur = head;

            for (int i = 1; i < n; i++) {
                // adding cities and its weights to generate a weighted graph
                DistanceNode newNode = new DistanceNode(cities[i], distances[i - 1]);

                // linking nodes
                cur.next = newNode;
                newNode.previous = cur;
                // making the new node as current code
                cur = cur.next;
            }

            // returned ArrayList of stops
            ArrayList<Character> stops = minimizeStops(C, head);
            System.out.println("Minimal number of stops is : " + stops);
        } catch (Exception e) {
            System.out.println("Please enter valid inputs. Exception cause: " + e.getMessage());
        }
    }

    /**
     * Iterates over the nodes, calculating the distance travelled so far
     * and checking if we need to make a stop at previous station
     * Appends the current city to the ArrayList if stop is required
     *
     * @param carRange Capacity of the car taken from input
     * @param head Pointer to first node in the weighted graph(linked list)
     *             eg. A | 0 <-> B | 90 <-> C | 60 <-> D | 70 <-> E | 65 <-> F |  83 <-> G | 75 <-> H | 72
     * @return stops List of minimum stops required
     */
    public static ArrayList<Character> minimizeStops(int carRange, DistanceNode head) {
        DistanceNode curNode = head;
        // will contain the list of minimum stops required
        ArrayList<Character> stops = new ArrayList<>();

        // first stop will always be in the list - recharging the car at distance 0
        stops.add(curNode.city);
        // distance to reach the current node
        int currentStopDistance;

        while(curNode.next != null) {
            // calculating the total distance travelled so far on a single range; after every recharge it becomes zero
            int distanceTravelledSoFar = 0;

            // iterating till we get to the last node or total distance covered + currentDistance exceeds the car range
            do {
                curNode = curNode.next;
                // current distance updated
                currentStopDistance = curNode.distance;
                // adding the current distance to total distance travelled so far
                distanceTravelledSoFar += currentStopDistance;
            } while (curNode.next != null && distanceTravelledSoFar + currentStopDistance < carRange);

            // checking if we need to make a stop at previous station
            if (distanceTravelledSoFar + currentStopDistance > carRange) {
                // go to previous node and add it to the stop where car needs to be fully recharged
                curNode = curNode.previous;
                stops.add(curNode.city);
            }
        }
        // add the last node in the list as it is the destination stop
        stops.add(curNode.city);

        return stops;
    }
}

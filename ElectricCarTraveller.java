import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ElectricCarTraveller {
    // nodes representing maximum number of cities(19 as cities are less than 20)
    static char nodes[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S'};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the range of the car: ");
        int C = Integer.parseInt(reader.readLine());

        System.out.print("Please enter the number of cities travelled by electric car: ");
        int n = Integer.parseInt(reader.readLine());

        // n-1 distances taken as n cities will have n-1 distances between them
        int[] distances = new int[n-1];
        System.out.println("Please enter the list of distances between the cities: ");

        for(int i = 0; i < n-1; i++) {
            System.out.print("Please enter the distance from " + nodes[i] + " -> " + nodes[i+1] + ": ");
            distances[i] = Integer.parseInt(reader.readLine());
        }

        DistanceNode head = new DistanceNode(nodes[0], 0);
        DistanceNode cur = head;
        for(int i=1; i<n; i++) {
            // add characters and its weight to generate a weighted graph
            DistanceNode newNode = new DistanceNode(nodes[i], distances[i-1]);

            cur.next = newNode;
            newNode.previous = cur;
            cur = cur.next;
        }

        printWeightedGraph(head);

        ArrayList<Character> stops = DistanceNode.minimizeStops(C, n, head);
        System.out.println("Minimal number of stops is : " + stops.toString());
    }

    public static void printWeightedGraph(DistanceNode head) {
        DistanceNode cur = head;
        System.out.println("Printing weight matrix: ");
        while(cur!=null) {
            System.out.println("Character : " + cur.node + " Distance: " + cur.distance);
            cur = cur.next;
        }
    }
}

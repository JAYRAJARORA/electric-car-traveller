# 535-project-1
Electric Car Traveler

Project Submission by the following group members:

Jayraj Arora  Email: jayraj.arora@csu.fullerton.edu

Manan Hasmukhbhai Patel   Email: mananpatel@csu.fullerton.edu

Sravani Kallempudi   Email: sravanik@csu.fullerton.edu

Problem Defintion: 

Given the range of car C, number of cities n, and distances(edges) between the cities, problem is to find the minimum stops needed to recharge an electric car to reach from the source to the destination; such that if the current city's charger is broken, car can return back to the previous city to recharge there.

Solution:

Algorithm: 
1. Create a doubly linked list of distances and cities. (e.g. A | 0 <-> B | 90 <-> C | 60 <-> D | 70 -> E | 65 -> F |  83 -> G | 75 -> H | 72). 
2. stops would be the result that is no. of minimum stops needed
3. Append the first node to stops list(as it is first node where car starts).
4. let curNode = head // pointer to the head of linked list
5. Let curStopDistance = 0 // this will contain the distance to reach the current city(e.g. 90 to reach city C)
6. Iterate till we traverse the entire linked list.(curNode.next != null)
  a. Let distanceTravelledSoFar = 0 // this will contain the total distance travelled by the car in one charge. Resets to 0 once a stop is made.
  b. Iterate till distanceTravelledSoFar + curStopDistance < C(car range) or we reach the last node
    i.   curNode = curNode.next
    ii.  curStopDistance = curNode.distance
    iii. distanceTravelledSoFar =  distanceTravelledSoFar + currentStopDistance
  c. if distanceTravelledSoFar + currentStopDistance > carRange
    i.  Go to the previous stop (cur = cur.previous). // Here car needed to recharged again.
    ii. Add this stop to the stops list
7. Add the last stop to the stops list
8. return stops



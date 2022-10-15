# 535-project-1
Electric Car Traveler

Project Submission by the following group members:

Jayraj Arora  Email: jayraj.arora@csu.fullerton.edu

Manan Hasmukhbhai Patel   Email: mananpatel@csu.fullerton.edu

Sravani Kallempudi   Email: sravanik@csu.fullerton.edu

Problem Defintion: 

Given the range of car C, number of cities n, and distances(edges) between the cities, problem is to find the minimum stops needed to recharge an electric car to reach from the source to the destination; such that if the current city's charger is broken, car can return back to the previous city to recharge there.

Algorithm: 
- Create a doubly linked list of distances and cities (e.g. A | 0 <-> B | 90 <-> C | 60 <-> D | 70 <-> E | 65 <-> F |  83 <-> G | 75 <-> H | 72). 
- stops would be the result that is no. of minimum stops needed
- Append the first node to stops list(as it is first node where car starts)
- let curNode = head // pointer to the head of linked list
- Let curStopDistance = 0 // this will contain the distance to reach the current city(e.g. 90 to reach city C)
- Iterate till we traverse the entire linked list (curNode.next != null) <p>
  - Let distanceTravelledSoFar = 0 // this will contain the total distance travelled by the car in one charge. Resets to 0 once a stop is made. <p>
  - Iterate till distanceTravelledSoFar + curStopDistance < C(car range) or we reach the last node<p>
    - curNode = curNode.next
    - curStopDistance = curNode.distance
    - distanceTravelledSoFar =  distanceTravelledSoFar + currentStopDistance
  - if distanceTravelledSoFar + currentStopDistance > carRange
    - Go to the previous stop (cur = cur.previous) // Here car needed to recharged again.
    - Add this stop to the stops list 
- Add the last stop to the stops list 
- return stops



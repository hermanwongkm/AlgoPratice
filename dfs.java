//Wong Kai Min Herman
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in); 
        int maxCount = 0;
        int id = 0;
        HashMap<Integer,Integer> mapping = new HashMap();              
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList();
        
        Map<Integer,Set<Integer>> map = new HashMap();
        while (s.hasNextLine()) {
           String line = s.nextLine();
            if(line.equals("Q1")){
            System.out.println(maxCount);
            } 
            else if(line.equals("Q2")){
                int ans = countConnectedGraph(id,adjacencyList);
                System.out.println(ans);
            }
            else{
                String[] numArray = line.split("-");
                int firstNum = Integer.parseInt(numArray[0]);
                int secondNum = Integer.parseInt(numArray[1]);
                
                for(int i = 0; i < numArray.length; i++){
                    if(!mapping.containsKey(Integer.parseInt(numArray[i]))){
                        mapping.put(Integer.parseInt(numArray[i]), id);
                        id++;
                        adjacencyList.add(new ArrayList<Integer>());
                    }
                }
                
                
                if(map.containsKey(firstNum)){ //I have seen this number before
                    if(!map.get(firstNum).contains(secondNum)){ //If i paired them before
                        int index1 = mapping.get(firstNum);
                        int index2 = mapping.get(secondNum);
                        adjacencyList.get(index1).add(index2);
                        adjacencyList.get(index2).add(index1);
                    }
                    
                    map.get(firstNum).add(secondNum);
                    maxCount = Math.max(maxCount,map.get(firstNum).size());
                }else{ //I have not seen this number before
                    Set<Integer> set = new HashSet();
                    set.add(secondNum);
                    map.put(firstNum, set);
                    maxCount = Math.max(maxCount,map.get(firstNum).size());
                                  
                //Add to graph
                    int index1 = mapping.get(firstNum);
                    int index2 = mapping.get(secondNum);
                        adjacencyList.get(index1).add(index2);
                        adjacencyList.get(index2).add(index1);
                    
                }
                
                if(map.containsKey(secondNum)){
                        if(!map.get(firstNum).contains(secondNum)){
                            int index1 = mapping.get(firstNum);
                            int index2 = mapping.get(secondNum);
                            adjacencyList.get(index1).add(index2);
                            adjacencyList.get(index2).add(index1);
                    }
                    
                    map.get(secondNum).add(firstNum);
                    maxCount = Math.max(maxCount,map.get(secondNum).size());
                }else{
                    Set<Integer> set = new HashSet();
                    set.add(firstNum);
                    map.put(secondNum, set);
                    maxCount = Math.max(maxCount,map.get(secondNum).size());
                    
                                    //Add to graph
                    int index1 = mapping.get(firstNum);
                    int index2 = mapping.get(secondNum);
                        adjacencyList.get(index1).add(index2);
                        adjacencyList.get(index2).add(index1);

                }
           } 
    
        
        }
        
    }
    
    public static int countConnectedGraph(int numOfVertices,ArrayList<ArrayList<Integer>> adjacencyList){
        // for(int i = 0; i < adjacencyList.size(); i++){
        //     System.out.println("i:"+i);
        //     for(int j = 0; j < adjacencyList.get(i).size(); j++){
        //         System.out.print(adjacencyList.get(i).get(j));
        //     }
        //     System.out.println("---");
        // }
        boolean[] visited = new boolean[numOfVertices];
        int count = 0;
        int index;
        while((index = checkGraphIsVisited(visited)) != -1){
            dfs(index,adjacencyList,visited);
            count++;
        }
        return count;
    }
    
    public static int checkGraphIsVisited(boolean[] visited){
            for (int i = 0; i <visited.length ; i++) {
                if(!visited[i])
                    return i;
            }
            return -1;
        }
    
    public  static void dfs(int start, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited){
        // System.out.println("Start:" + start);
        visited[start] = true;
        for(int i = 0; i < adjacencyList.get(start).size(); i++){
            int destination = adjacencyList.get(start).get(i);
            // System.out.println("Destination:" + destination);
            if(!visited[destination]){
                dfs(destination,adjacencyList,visited);
            }
        }
    } 

}

/**
A pandemic has broken out and efforts to perform contact tracing is ongoing.
A mobile contact tracing app has been developed, and you are tasked with analyzing the logs.
2 people may meet more than once, but this is still considered as having 1 contact.
As entries are added to the log from top to bottom, there will be 2 types of queries made about the data so far, Q1 and Q2.

    Q1: For the person(s) who contacted the most people, how many people did he/she contact?
    Q2: How many contact clusters are there, at the point of query?

Number of contact clusters refers to the number of disconnected groups of people. (See image)

image

There will be 20 test cases, and the first 10 will only contain Q1 and not Q2.
Q1 is easier to solve, and it is recommended that you solve this first.

Q2 is intentionally much harder than Q1, do not worry if you cannot solve it. :)

Input Format

    Each line of the log indicates when 2 persons (indicated by phone number M) are in contact with each other.
    The 2 phone numbers on a line will not be the same.
    The 2 phone numbers on a line will be separated by a single dash.
    There will be a maximum of N lines in the log.
    If a query appears before any contacts are logged, print 0

Constraints

1 <= M <= 1,000,000
1 <= N <= 500,000

Output Format

An integer every time there is a query.

Sample Input 0

1-2
Q1
2-3
1-4
5-1
1-5
1-5
Q1

Sample Output 0

1
3

Explanation 0

On the first query, both person's 1 and 2 have contacted each other, and both have a contact count of 1. Therefore the highest number of contacts a person has made is 1, and we print 1.

On the second query, person 1 has contacted 3 other people (2, 4, 5), and has the highest contact count. Therefore we print 3.

Sample Input 1

1-2
Q1
2-3
1-4
5-1
Q1
Q2
6-7
Q2

Sample Output 1

1
3
1
2


**/

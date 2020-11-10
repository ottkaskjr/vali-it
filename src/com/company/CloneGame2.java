import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {



    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        //ArrayList<int[]> connections = new ArrayList<>();
        List<List<Integer>> exitConnections = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            //connections.add(new int[]{N1, N2});
            List<Integer> connection = new ArrayList<>();
            //connections.add(N1+"-"+N2);
            connection.add(N1);
            connection.add(N2);
            exitConnections.add(connection);
        }
        List<Integer> exitNodes = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            exitNodes.add(EI);
            //System.err.println("exitNode " + EI);
        }

        // LEAVE ONLY CONNECTIONS WITH EXITNODES & CREATE ANOTHER LIST WITH ALL OTHER PROTECTED CONNECTIONS
        List<List<Integer>> protectedConnections = new ArrayList<>();
        for(int i = exitConnections.size()-1; i >= 0; i--){
            boolean remove = true;
            for(int node: exitConnections.get(i)){
                if(exitNodes.contains(node)){
                    remove = false;

                    break;
                }
            }
            if(remove){
                protectedConnections.add(exitConnections.get(i));
                exitConnections.remove(i);
                // add to other list

            }
            //if(connections.get(i).ge)
        }

        // CREATE A LIST OF CONNECTIONS THAT CONNECT TWO OR MORE EXITS
        // CHOOSE CONNECTION WHICH IS CONNECTED TO THE EXIT WITH MORE CONNECTIONS
        List<List<Integer>> dualExitNodes = new ArrayList<>();
        for(int i = 0; i < exitConnections.size()-1; i++){
            // if this exitNodes contains this nodes then the node to check is the other one, else vice versa
            int nodeToCheck = exitNodes.contains(exitConnections.get(i).get(0)) ? exitConnections.get(i).get(1) : exitConnections.get(i).get(0);

            for(int j = i + 1; j < exitConnections.size(); j++){
                if (exitConnections.get(j).contains(nodeToCheck)){
                    //dualExitNodes.add(exitConnections.get(i));
                    // first let's just test with adding the second match, later we can try with first or selecting the one with more connections
                    dualExitNodes.add(exitConnections.get(j));
                }
            }
        }


        // CREATE A LIST OF EXIT NODES WITH MORE CONNECTIONS THAN 1
        List<List<Integer>> manyDoorsExits = new ArrayList<>();
        List<List<Integer>> exitsWithMoreThan2 = new ArrayList<>();
        int maxCount = 0;
        for(int node: exitNodes){
            int nodeCount = 0;
            for(int i = 0; i < exitConnections.size(); i++){
                if(exitConnections.get(i).contains(node)){
                    nodeCount++;
                }
            }

            if(nodeCount == 2){
                /*
                if(nodeCount >= maxCount) {
                    maxCount = nodeCount;
                    manyDoorsExits.add(exitConnections.get(i));
                }*/

                for(int i = 0; i < exitConnections.size(); i++){
                    if(exitConnections.get(i).contains(node)){
                        manyDoorsExits.add(exitConnections.get(i));
                    }
                }
            }
            if(nodeCount > 2){
                for(int i = 0; i < exitConnections.size(); i++){
                    if(exitConnections.get(i).contains(node)){
                        exitsWithMoreThan2.add(exitConnections.get(i));
                    }
                }
            }
        }

        System.err.println("manyDoorsExits:" + manyDoorsExits.size());
        for(List<Integer> arr: manyDoorsExits){

            System.err.println(arr);
        }
        System.err.println("================");
        System.err.println("exitsWithMoreThan2:" + exitsWithMoreThan2.size());
        for(List<Integer> arr: manyDoorsExits){

            System.err.println(arr);
        }
        System.err.println("================");

        System.err.println("DUALEXITNODES:" + dualExitNodes.size());
        for(List<Integer> arr: dualExitNodes){

            System.err.println(arr);
        }
        System.err.println("================");
        // SORT ALL EXITNODES BY THEIR NUMBER OF CONNECTIONS


        // GET DEFAULT LINK IN CASE ALL POSSIBLE CONNECTIONS ARE BROKEN


        System.err.println("=== EXITNODES ===");
        for(int num: exitNodes){

            System.err.println(num);
        }
        System.err.println("=== ====== ===");
        //int connection = 1;


        System.err.println("EXITCONNECTIONS");
        for(List<Integer> arr: exitConnections){

            System.err.println(arr);
        }
        System.err.println("================");
        /*
        System.err.println("PROTECTEDCONNECTIONS");
        for(List<Integer> arr: protectedConnections){

            System.err.println(arr);
        }
        System.err.println("================");*/

        // game loop
        while (true) {
            System.err.println("========== TURN ==========");
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            int first = 0;
            int second = 1;
            int index = 0;


            // MOST VULNERABLE BLOCK //
            int mostVulnerable = 0;
            int mostConnections = 0;
            for(int node: exitNodes){
                int thisNodeCount = 0;
                mostVulnerable = node;
                int biggestCount = 0;
                for(int i = 0; i < exitConnections.size(); i++){
                    if(exitConnections.get(i).contains(node)){
                        thisNodeCount++;
                    }
                }
                if (thisNodeCount > biggestCount){
                    biggestCount = thisNodeCount;
                    mostConnections = biggestCount;
                    mostVulnerable = node;

                }
            }

            System.err.println("MOST VULNERABLE EXIT: " + mostVulnerable);
            // ===================== //



            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            // LOOP CONNECTIONS

            // 3 LOOPI
            // 1 DIRECT DANGER
            boolean danger = false;
            for(int i = exitConnections.size()-1; i >= 0; i--){


                if (exitConnections.get(i).contains(SI)){
                    System.err.println("FOUND DANGER");
                    System.err.println("exitConnections: " + exitConnections.get(i).toString() + " and angent is at " + SI);
                    first = exitConnections.get(i).get(0);
                    second = exitConnections.get(i).get(1);

                    index = i;
                    danger = true;
                    break;
                }
                index = i;
                if (!danger){
                    System.err.println("!danger");
                    first = exitConnections.get(i).get(0);
                    second = exitConnections.get(i).get(1);
                    index = i;
                }
            }

            if(!danger){
                // exitNodes.size() > 3 tagab, et esimesed 3 missiooni töötavad
                if(dualExitNodes.size() > 0 && exitNodes.size() > 3){ // LISA SIIA ÜHENDUSED/NODED MILLEL ON ÜHENDUS KAHE EXITIGA!!!
                    System.err.println("YAAAAAAP");
                    // let's test with last entry
                    // PEAKS IKKAGI TESTIMA NODEGA, MILLEL ON ROHKEM ÜHENDUSI(JUST JA SEDA PEABKI)
                    //dualExitNodes.get(dualExitNodes.size()-1);


                    // PEAN LISAMA SIIA CHECKI ET KÕIGEPEALT EEMALDADA ENIMA ÜHENDUSEGA NODE CONNECTION (manyDoorsExit)
                    // HETKEL VÕTAB ÜKSKÕIK MILLISE (VIIMASES PEAKS KÕIGE PEALT VÕTMA KOLME ÜHENDUSEGA)

                    boolean manyDoors = false;
                    if(manyDoorsExits.size() > 0){

                        // at first pick just first one
                        int manyDoorsIndex = manyDoorsExits.size() == 1 ? 0 : manyDoorsExits.size() - 1;
                        System.err.println("manyDoorsIndex: " + manyDoorsIndex);
                        first = manyDoorsExits.get(manyDoorsIndex).get(0);
                        second = manyDoorsExits.get(manyDoorsIndex).get(1);
                        System.err.println("1");
                        for(int i = 0; i < exitConnections.size(); i++){
                            if(exitConnections.get(i).equals(manyDoorsExits.get(manyDoorsIndex))){
                                index = i;
                                manyDoorsExits.remove(manyDoorsIndex);
                                System.err.println("2");
                                break;
                            }
                        }

                        manyDoors = true;
                        System.err.println("3");
                    }

                    if(!manyDoors){
                        for(int i = exitConnections.size()-1; i >= 0; i--){

                            if (exitConnections.get(i).equals(dualExitNodes.get(dualExitNodes.size()-1))){
                                System.err.println("FOUND EQUALS");
                                first = exitConnections.get(i).get(0);
                                second = exitConnections.get(i).get(1);
                                //exitConnections.remove(i);
                                index = i;
                                dualExitNodes.remove(dualExitNodes.size()-1);
                                break;
                            }

                        }
                        System.err.println("dualExitNodesLeft:" + dualExitNodes.size());
                    }

                } else {


                    for(int i = exitConnections.size()-1; i >= 0; i--){
                        for(int j = protectedConnections.size() - 1;j >= 0 ; j--){
                            for(int node: protectedConnections.get(j)){
                                if(exitConnections.get(i).contains(node) && protectedConnections.get(j).contains(SI)){
                                    System.err.println("FOUND DANGERSOON");
                                    System.err.println("exitConnections: " + exitConnections.get(i).toString());
                                    System.err.println("protectedConnections: " + protectedConnections.get(j).toString());

                                    first = exitConnections.get(i).get(0);
                                    second = exitConnections.get(i).get(1);
                                    index = i;
                                    danger = true;
                                    break;
                                }

                            }
                            //if(protectedConnections.get(j))
                        }
                    }
                }


            }

            exitConnections.remove(index);


            /*
            for(int i = exitConnections.size()-1; i >= 0; i--){
                boolean danger = false;

                if (exitConnections.get(i).contains(SI)){
                    System.err.println("FOUND DANGER");
                    System.err.println("exitConnections: " + exitConnections.get(i).toString() + " and angent is at " + SI);
                    first = exitConnections.get(i).get(0);
                    second = exitConnections.get(i).get(1);

                    index = i;
                    danger = true;
                    break;
                }
                // IF NO DIRECT DANGER, LOOP AND FIND CONNECTIONS BETWEEN exitConnections AND protectedConnections THAT ALSO CONTAIN SI
                if(!danger){
                    for(int j = protectedConnections.size() - 1;j >= 0 ; j--){
                        for(int node: protectedConnections.get(j)){
                            if(exitConnections.get(i).contains(node) && protectedConnections.get(j).contains(SI)){
                                System.err.println("FOUND DANGERSOON");
                                System.err.println("exitConnections: " + exitConnections.get(i).toString());
                                System.err.println("protectedConnections: " + protectedConnections.get(j).toString());

                                first = exitConnections.get(i).get(0);
                                second = exitConnections.get(i).get(1);
                                index = i;
                                danger = true;
                                break;
                            }

                        }
                        //if(protectedConnections.get(j))
                    }
                }
                if(danger){
                    break;
                }

                // IF NO DANGERSOON, REMOVE THE FIRST CONNECTION(lAST OF THE LOOP)
                if (!danger){
                    System.err.println("!danger");
                    first = exitConnections.get(i).get(0);
                    second = exitConnections.get(i).get(1);
                    index = i;
                }
            }*/



            System.err.println(first + " " + second);

            System.out.println(first + " " + second);
            // Example: 0 1 are the indices of the nodes you wish to sever the link between
            // TEST 1 & 2
            /*System.out.println("0 6");*/
        }
    }
}
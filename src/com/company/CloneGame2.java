package com.company;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class CloneGame2 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // number of additional elevators that you can build
        int nbElevators = in.nextInt(); // number of elevators


        List<int[]> elevators = new ArrayList<>();
        List<int[]> floorsAndElevators = new ArrayList<>();
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            int elevatorPos = in.nextInt(); // position of the elevator on its floor
            elevators.add(new int[]{elevatorFloor, elevatorPos});
            System.err.println(Arrays.toString(elevators.get(elevators.size()-1)));
        }
        // sort elevators, so that it has int[]{floor, left elev, right elev}

        for(int i = 0; i < nbFloors; i++){
            // loo array
            int[] flr = new int[3];
            int floor = i;
            flr[0] = floor;
            flr[1] = -1;
            flr[2] = -1;
            int index = 1;
            // loobi array
            for(int j = 0; j < elevators.size(); j++){
                if(elevators.get(j)[0] == floor){
                    flr[index] = elevators.get(j)[1];
                    index++;
                    if(index > 2){
                        break;
                    }
                }

            }
            //switch elevator positions, if 1st position is larger
            if(flr[1] > flr[2]){
                if(flr[2] != -1){
                    int buff = flr[1];
                    flr[1] = flr[2];
                    flr[2] = buff;
                }

                // if elevator_left = -1 switch
                if(flr[1] == -1){
                    flr[1] = flr[2];
                    flr[2] = -1;
                }


            }

            floorsAndElevators.add(flr);
            System.err.println(Arrays.toString(floorsAndElevators.get(floor)));
        }

        int availableElevators = nbAdditionalElevators;
        int countDown = 2;
        // game loop
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            /*
            int elevatorPos =  -1;
            for(int[] elev: elevators){
                System.err.println("ELEV " + elev);
                if(elev[0] == cloneFloor){
                    elevatorPos = elev[1];
                }
            }*/


            if (countDown > 0){
                System.err.println("countDown " + countDown);
                System.out.println("WAIT");
            } else {
                String[] data = getDirection(width, nbFloors, cloneFloor, clonePos, exitPos, direction, availableElevators, floorsAndElevators);
                availableElevators = Integer.parseInt(data[1]);
                System.out.println(data[0]);
            }
            countDown--;

            // action: WAIT or BLOCK
        }

    }
    public static String[] getDirection(int width, int nbFloors, int cloneFloor, int clonePos, int exitPos, String direction, int availableElevators, List<int[]> floorsAndElevators){
        String action = "WAIT";
        if (!direction.equals("NONE")){
            if(clonePos == 0 || clonePos == width-1) {
                action = "BLOCK";
            }
            // upperfloor
            if (cloneFloor == nbFloors-1){
                // exit position
                if(direction.equals("LEFT")){
                    if(clonePos <= exitPos){
                        action = "BLOCK";
                    }
                } else if(direction.equals("RIGHT")) {
                    if(clonePos >= exitPos){
                        action = "BLOCK";
                    }
                }
            } else {
                // SIIN POOLELI
                // elevatorPos võta parameetritest ära ja kasuta ainult seda listi,
                // kui korrusel lifte pole ehita uus lift ning lisa see antud korruse int arraysse indexisse 1
                if (floorsAndElevators.get(cloneFloor)[1] == -1 && floorsAndElevators.get(cloneFloor)[2] == -1 && availableElevators > 0){
                    action = "ELEVATOR";
                    floorsAndElevators.get(cloneFloor)[1] = clonePos;
                    //floorsAndElevators.set(cloneFloor, int[]{cloneFloor, clonePos});
                    availableElevators--;
                } else {
                    // vastasel juhul:
                    // 1 kontrolli kas korrusel on kaks lifti
                    int elevatorPos = 0;
                    int leftEPos = floorsAndElevators.get(cloneFloor)[1];
                    int rightEPos = floorsAndElevators.get(cloneFloor)[2];
                    // clone - left = pace1
                    // right - clone = pace2
                    // elevatorPos = lühem pace
                    // SIIN POOLELI TESTI SYSTEM.ERR
                    if (leftEPos != -1 && rightEPos != -1){
                        int pace1 = clonePos - leftEPos;
                        int pace2 = rightEPos - clonePos;
                        elevatorPos = pace1 < pace2 ? pace1 : pace2;
                        System.err.println("pace1: " + pace1);
                        System.err.println("pace2: " + pace2);
                        System.err.println("elevatorPos: " + elevatorPos);
                    } else {
                        // vastasel juhul toimi ühe liftiga!
                        elevatorPos = leftEPos;
                    }


                    // elevator position
                    if(direction.equals("LEFT")){
                        if(clonePos < elevatorPos){
                            action = "BLOCK";
                        }
                    } else if(direction.equals("RIGHT")) {
                        //System.err.println("GOT HERE!");
                        //System.err.println("clonePos " + clonePos);
                        //System.err.println("elevatorPos " + elevatorPos);
                        if(clonePos > elevatorPos){
                            System.err.println("CLONE POS > elevatorPos!");
                            action = "BLOCK";
                        }
                    }
                }

            }
        }

        return new String[]{action, Integer.toString(availableElevators)};
    }
}

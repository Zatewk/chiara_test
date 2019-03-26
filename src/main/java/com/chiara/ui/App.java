package com.chiara.ui;

import com.chiara.core.Facade;
import com.chiara.core.PlayList;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc;
        String input, input2;
        Facade core;
        PlayList list;

        core = new Facade();
        sc = new Scanner(System.in);
        do{
            System.out.println("Welcome to Chiara Movies");
            System.out.println("Select an option");
            System.out.println("- Open a Playlist (O)");
            System.out.println("- Create a PlayList (C)");
            System.out.println("- Exit (E)");
            input = sc.nextLine();
            switch (input){
                case "O":
                    System.out.println("Select a playlist: ");
                    for (String playlist: core.getAvailablePlaylists()){
                        System.out.println("- "+playlist);
                    }
                    System.out.println();
                    System.out.println("Return (R)");
                    input = sc.nextLine();

                    if (core.existPlaylist(input)) {
                        list = core.getPlaylist(input);
                        System.out.println(list.getCurrentElement().getInformation());
                        do{
                            System.out.println("Next (N)");
                            System.out.println("Prev (P)");
                            System.out.println("Return (R)");
                            input = sc.nextLine();
                            if (input.equalsIgnoreCase("N")){
                                System.out.println(list.getNextElement().getInformation());
                            }else if (input.equalsIgnoreCase("P")){
                                System.out.println(list.getPreviousElement().getInformation());
                            }
                        }while (!input.equalsIgnoreCase("R"));
                    }
                    break;
                case "C":
                    System.out.println("You can create three possible playlists:");
                    System.out.println("- Ordered by popularity (P)");
                    System.out.println("- All movies with the same actor (A)");
                    System.out.println("- All movies with the same genra (G)");
                    System.out.println();
                    System.out.println("Return (R)");
                    input = sc.nextLine();

                    switch (input){
                        case "P":
                            System.out.println("Type a name for your new list");
                            input = sc.nextLine();
                            core.createPlayListbyPopularity(input);
                            break;
                        case "A":
                            System.out.println("Type a name for your new list");
                            input = sc.nextLine();
                            System.out.println("Type a name of the actor");
                            input2 = sc.nextLine();
                            core.createPlayListbyActor(input, input2);
                            break;
                        case "G":
                            System.out.println("Type a name for your new list");
                            input = sc.nextLine();
                            System.out.println("Type a name of the genre");
                            input2 = sc.nextLine();
                            core.createPlayListbyGenre(input, input2);
                            break;
                    }
                    break;
            }
        }while (!input.equalsIgnoreCase("E"));
    }
}

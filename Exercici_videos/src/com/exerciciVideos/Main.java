package com.exerciciVideos;


import java.util.*;

import static com.exerciciVideos.Video.enterVideo;

public class Main {


    public static void main(String[] args) throws Exception {
        //variable
        boolean moreVideos = true;

        //introduir usuari. Aquesta és la manera de que es mantingui en la memòria i no s'inicialitzi.
        Scanner sc = new Scanner(System.in);
        System.out.println("nom? ");
        String name = sc.nextLine();

        System.out.println("cognom? ");
        String surname = sc.nextLine();

        System.out.println("pw? ");
        String pw = sc.nextLine();

        Date regDate = new Date();

        User user = new User(name, surname, pw, regDate);

        //introducció de n videos
        while (moreVideos == true){
            System.out.println("vols introduir un video? ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("S")){
                user.enterVideoToList(enterVideo());
                moreVideos = true;
            } else if (resp.equalsIgnoreCase("N")){
                moreVideos = false;
            } else {
                System.out.println("has de contestar S o N");
            }
        }
        //mostrar totes les dades
        System.out.println("les dades introduïdes són: " + user.toString());
    }
}

package com.exerciciVideos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Video {

    //declaració de variables
    private String url;
    private String title;
    private List<String> tags;

    //constructors
    public Video(){
        url = "";
        title = "";
    }

    public Video(String url, String title) throws Exception {

        checkInfo(url);
        checkInfo(title);

        this.url = url;
        this.title = title;
    }

    public Video(String url, String title, List tags) throws Exception {

        checkInfo(url);
        checkInfo(title);
        checkTags(tags);

        this.url = url;
        this.title = title;
        this.tags = tags;
    }


    //validació d'omplir tots els camps de tipus String:
    public void checkInfo(String info) throws Exception {
        if (info == null) {
            throw new Exception("S'han d'omplir tots els camps.");
        }
        if (info.equals("")) {
            throw new Exception("S'han d'omplir tots els camps.");
        }
    }

    //validació d'omplir els tags:
    public void checkTags(List<String> tags) throws Exception {
        for(int i=0; i<tags.size(); i++) {
            if (tags.get(i) == null) {
                throw new Exception("Insereix una etiqueta com a mínim");
            }
            if (tags.get(i).equals("")) {
                throw new Exception("Insereix una etiqueta com a mínim");
            }
        }
    }


    public static Video enterVideo() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("url del video: ");
        String url = sc.nextLine();

        System.out.println("títol: ");
        String title = sc.nextLine();

        Video video = new Video(url, title, enterTag());

        System.out.println("el video es: " + video.toString());
        return video;
    }

    public static List<String> enterTag(){
        Scanner sc = new Scanner(System.in);
        boolean moreTags = true;

        List<String> tags = new ArrayList<>();
        while (moreTags == true){
            System.out.println("nom etiqueta pel video? ");
            String tag = sc.nextLine();
            tags.add(tag);
            System.out.println("més etiquetes? ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("s")){
                moreTags = true;
            } else if(resp.equalsIgnoreCase("n")){
                moreTags = false;
            } else {
                System.out.println("has de contestar s o n");
            }
        }
        return tags;
    }

    @Override
    public String toString() {
        return "Video{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", tags=" + tags +
                '}';
    }
}



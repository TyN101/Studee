package com.waxyhexagon.studeea;

import android.util.Log;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * http://www.coderblog.de/sending-data-from-java-to-php-via-a-post-request/
 * http://digitallibraryworld.com/?p=189
 *
 */

public final class Comms {

    public static void echo(){
        URL url;
        try {
            url = new URL("http://studee.waxyhexagon.com/app/test.php");//("http://studee.waxyhexagon.com/app/test.php");
            HttpURLConnection connection;
            connection = (HttpURLConnection)url.openConnection();
            //connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            //String parameters = URLEncoder.encode("parameters=echo this", "UTF-8");
            String parameters = "parameters=echo this";
            connection.setFixedLengthStreamingMode(parameters.getBytes().length);
            //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //What?
            //connection.setRequestProperty("parameters", parameters);
            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(parameters);
            out.close();

            String response = "";
            Scanner inStream = new Scanner(connection.getInputStream());
            while(inStream.hasNextLine()){
                response += (inStream.nextLine());
            }
            Log.i("response",response);
        }catch (MalformedURLException e){
            Log.i("MalformedURLException",e.toString());
        }catch (IOException e){
            Log.i("IOException",e.toString());
        }
    }

    public static boolean login(EditText email, EditText password){
        URL url;
        try{
            url = new URL("http://studee.waxyhexagon.com/app/login.php");
            HttpURLConnection connection;
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            String parameters = "email=" + email.getText().toString() +
                                "&password=" + password.getText().toString();
            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(parameters);
            out.close();
            String response = "";
            Scanner inStream = new Scanner(connection.getInputStream());
            while(inStream.hasNextLine()){
                response += (inStream.nextLine());
            }
            Log.i("response",response);

            return Integer.parseInt(response)==1;
        }catch (MalformedURLException e){
            Log.i("MalformedURLException",e.toString());
        }catch (IOException e){
            Log.i("IOException",e.toString());
        }
        return false;
    }

    public static String[] populateMatches(){
        String response = "";
        URL url;
        try{
            url = new URL("http://studee.waxyhexagon.com/app/students.php");
            HttpURLConnection connection;
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            Scanner inStream = new Scanner(connection.getInputStream());
            while(inStream.hasNextLine()){
                response += (inStream.nextLine());
            }
            Log.i("response",response);
        }catch (MalformedURLException e){
            Log.i("MalformedURLException",e.toString());
        }catch (IOException e){
            Log.i("IOException",e.toString());
        }

        //takes names seperated by commas
        String[] names = new String[6];
        int startIndex = 0;
        int endIndex = response.indexOf(",");
        names[0] = new String(response.substring(startIndex,endIndex));
        startIndex = endIndex+1;
        endIndex = response.indexOf(",",startIndex+1);
        names[1] = new String(response.substring(startIndex,endIndex));
        startIndex = endIndex+1;
        endIndex = response.indexOf(",",startIndex+1);
        names[2] = new String(response.substring(startIndex,endIndex));
        startIndex = endIndex+1;
        endIndex = response.indexOf(",",startIndex+1);
        names[3] = new String(response.substring(startIndex,endIndex));
        startIndex = endIndex+1;
        endIndex = response.indexOf(",",startIndex+1);
        names[4] = new String(response.substring(startIndex,endIndex));
        startIndex = endIndex+1;
        endIndex = response.length() -1;
        names[5] = new String(response.substring(startIndex,endIndex));
        return names;
    }

    public static void updateProfile(EditText first, EditText last, EditText phone, EditText email){
        URL url;
        try{
            url = new URL("http://studee.waxyhexagon.com/app/updateProfile.php");
            HttpURLConnection connection;
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");

            String parameters = "firstname=" + first.getText().toString() +
                    "&lastname=" + last.getText().toString() +
                    "&phonenum=" + phone.getText().toString() +
                    "&emailaddr=" + email.getText().toString();
            /*parameters += "&taken1="; if (taken[0]){ parameters += "1"; }else{ parameters += "0"; }
            parameters += "&taken2="; if (taken[1]){ parameters += "1"; }else{ parameters += "0"; }
            parameters += "&taken3="; if (taken[2]){ parameters += "1"; }else{ parameters += "0"; }
            parameters += "&taken4="; if (taken[3]){ parameters += "1"; }else{ parameters += "0"; }
            parameters += "&taken5="; if (taken[4]){ parameters += "1"; }else{ parameters += "0"; }
            parameters += "&tutor1="; if (tutor[0]){ parameters += "1"; }else{ parameters += "0"; }
            parameters += "&tutor2="; if (tutor[1]){ parameters += "1"; }else{ parameters += "0"; }
            parameters += "&tutor3="; if (tutor[2]){ parameters += "1"; }else{ parameters += "0"; }
            parameters += "&tutor4="; if (tutor[3]){ parameters += "1"; }else{ parameters += "0"; }
            parameters += "&tutor5="; if (tutor[4]){ parameters += "1"; }else{ parameters += "0"; }*/

            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(parameters);
            out.close();
        }catch (MalformedURLException e){
            Log.i("MalformedURLException",e.toString());
        }catch (IOException e){
            Log.i("IOException",e.toString());
        }
    }

    public static void updateProfileString(String first, String last, String phone, String email){
        URL url;
        try{
            url = new URL("http://studee.waxyhexagon.com/app/updateProfile.php");
            HttpURLConnection connection;
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");

            String parameters = "firstname=" + first +
                    "&lastname=" + last +
                    "&phonenum=" + phone +
                    "&emailaddr=" + email;

            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(parameters);
            out.close();
            String response = "";
            Scanner inStream = new Scanner(connection.getInputStream());
            while(inStream.hasNextLine()){
                response += (inStream.nextLine());
            }
            Log.i("response",response);
        }catch (MalformedURLException e){
            Log.i("MalformedURLException",e.toString());
        }catch (IOException e){
            Log.i("IOException",e.toString());
        }
    }

    public static String[] viewProfile(String name){
        String response = "";
        URL url;
        try{
            url = new URL("http://studee.waxyhexagon.com/app/viewProfile.php");
            HttpURLConnection connection;
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            String parameters = "name=" + name;
            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(parameters);
            out.close();
            Scanner inStream = new Scanner(connection.getInputStream());
            while(inStream.hasNextLine()){
                response += (inStream.nextLine());
            }
            Log.i("response",response);
        }catch (MalformedURLException e){
            Log.i("MalformedURLException",e.toString());
        }catch (IOException e){
            Log.i("IOException",e.toString());
        }

        //takes data seperated by commas
        String[] data = new String[13];
        int startIndex = 0;
        int endIndex = response.indexOf(",");
        data[0] = new String(response.substring(startIndex,endIndex)); //First name
        startIndex = endIndex+1;
        endIndex = response.indexOf(",",startIndex +1);
        data[1] = new String(response.substring(startIndex,endIndex)); //phone #
        startIndex = endIndex+1;
        endIndex = response.length() -1;
        data[2] = new String(response.substring(startIndex,endIndex)); //email
        return data;
    }

}

package com;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;

import java.util.Scanner;

public class FrontController {
    public static void main(String[] args) {
        try(Scanner scanner=new Scanner(System.in)){
            while (scanner.hasNext()){
                String nextLine=scanner.nextLine();
                new Thread(){
                    @Override
                    public synchronized void run() {
                        new DispatcherServlet().process(nextLine);
                    }
                }.start();
            }
        }
    }
}
class DispatcherServlet{
    void process(String url){
        switch (url){
            case "home": new HomeController().show();break;
            case "user": new UserController().show();break;
            default:new DefaultController().show();break;
        }
    }
}
class HomeController{
    void show(){
        System.out.println("This is home page");
    }
}
class UserController{void show(){
    System.out.println("This is user  page");
}}
class DefaultController{void show(){
    System.out.println("Error");
}}
























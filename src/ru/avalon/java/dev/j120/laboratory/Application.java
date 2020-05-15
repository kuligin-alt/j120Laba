
package ru.avalon.java.dev.j120.laboratory;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import ru.avalon.java.dev.j120.laboratory.IO.GoodsIO;
import ru.avalon.java.dev.j120.laboratory.IO.OrderIO;
import ru.avalon.java.dev.j120.laboratory.entity.Goods;
import ru.avalon.java.dev.j120.laboratory.entity.Order;
import ru.avalon.java.dev.j120.laboratory.entity.OrderStatus;
import ru.avalon.java.dev.j120.laboratory.entity.Person;


public class Application {
  
    public static void main(String[] args) throws IOException {
        
        showStart();
        
    }
    
    public static void showStart() throws IOException {
        
        GoodsIO listGood = new GoodsIO();
        String text = new String(listGood.goodsIO());
        
        ArrayList<Goods> good = new ArrayList<>();
        
        String [] lines = text.split("\n");
        for(String line : lines) {
            String [] words = line.split(";");
            if (words[2].equals("")) {
                good.add(new Goods(words[0], words[1], "не указан", words[3], words[4]));
            } else {
                good.add(new Goods(words[0], words[1], words[2], words[3], words[4]));
            }
        }
        
        for(int i = 0; i < good.size(); i++) {
            Object elements = good.get(i);
            System.out.println(elements);
        }
        
        System.out.println("");
        
        System.out.println("Выбирете товар и закажите его введя номер: ");
        Scanner sc = new Scanner(System.in);
        Goods g = (Goods) good.get(sc.nextInt());
        System.out.println(g.toString());
        
        System.out.println("");
        
        System.out.println("Введите количество: ");
        Scanner sc2 = new Scanner(System.in);
        int a = sc2.nextInt();
        g.setStockBalance(g.stockBalance - a);
        
        Order.orderGoods(g);
        
        System.out.println("");
        
        
        
        System.out.println("Введите имя: ");
        Scanner scContactPerson = new Scanner(System.in);
        String contactPerson = scContactPerson.nextLine();
        
        System.out.println("Введите адресс доставки: ");
        Scanner scDeliveryAdress = new Scanner(System.in);
        String deliveryAdress = scDeliveryAdress.nextLine();
        
        System.out.println("Введите ваш номер телефона: ");
        Scanner scPhoneNumber = new Scanner(System.in);
        String phoneNumber = scPhoneNumber.nextLine();
        
        System.out.println("Введите процент скидки: ");
        Scanner scDiscount = new Scanner(System.in);
        int discount = scDiscount.nextInt();
        
        Person person = new Person(contactPerson, deliveryAdress, phoneNumber, discount);
        
        OrderStatus orderStatus = OrderStatus.PREPARING;
        orderStatus.getStatus();
        
        Order order = new Order(LocalDate.now(), person, orderStatus.getStatus(), g);
        
        System.out.println(order.toString());
        
       
        OrderIO orderIO = new OrderIO(); // сохранение и загрузка заявки 
        orderIO.saveOrder(order);  
        orderIO.copyOrder();       
    }  
}

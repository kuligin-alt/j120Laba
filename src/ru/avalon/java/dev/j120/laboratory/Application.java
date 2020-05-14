
package ru.avalon.java.dev.j120.laboratory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import ru.avalon.java.dev.j120.laboratory.IO.OrderIO;
import ru.avalon.java.dev.j120.laboratory.entity.Goods;
import ru.avalon.java.dev.j120.laboratory.entity.Order;
import ru.avalon.java.dev.j120.laboratory.entity.OrderStatus;


public class Application {
  
    public static void main(String[] args) {
        
        
        
    }
    
    public static void showStart() {
        
        
        ArrayList<Goods> good = new ArrayList<>();
        
        good.add(new Goods(0, "goods1", "green", 45.40, 10));
        good.add(new Goods(1, "goods2", "green", 95.30, 10));
        good.add(new Goods(2, "goods3", "yellow", 45.90, 10));
        good.add(new Goods(3, "goods4", "green", 156.40, 10));
        good.add(new Goods(4, "goods5", "green", 587.10, 10));
        good.add(new Goods(5, "goods6", "black", 950.00, 10));
        good.add(new Goods(6, "goods7", "blue", 915.00, 10));
        good.add(new Goods(7, "goods8", "green", 13.50, 10));
        good.add(new Goods(8, "goods9", "black", 87.30, 10));
        good.add(new Goods(9, "goods10", "yellow", 152.20, 10));
        
        for(int i = 0; i < good.size(); i++) {
            Object elements = good.get(i);
            System.out.println(elements);
        }
        
        System.out.println("Выбирете товар и закажите его введя номер: ");
        Scanner sc = new Scanner(System.in);
        Goods g = (Goods) good.get(sc.nextInt());
        System.out.println(g.toString());
        
        System.out.println("Введите количество: ");
        Scanner sc2 = new Scanner(System.in);
        int a = sc2.nextInt();
        g.setStockBalance(a);
        
        Order.orderGoods(g);
        
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
        
        OrderStatus orderStatus = OrderStatus.PREPARING;
        orderStatus.getStatus();
        
        Order order = new Order(LocalDate.now(), contactPerson, deliveryAdress, phoneNumber, discount, orderStatus.getStatus(), g);
        
        System.out.println(order.toString());
        
        //OrderIO orderIO = new OrderIO();
        //orderIO.saveOrder(order); 
    }
    
}

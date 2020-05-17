
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
        
        // Коллекция заявок:
        ArrayList<Order> orderList = new ArrayList<>(); 
        
        // Меню управления заявками:
        for(;;) {
            System.out.println("");
            System.out.println("Добро пожаловать в магазин на диване!");
            System.out.println("");
            System.out.println("Сформировать заявку: 1 ");
            System.out.println("Просмотреть все заявки: 2 ");
            System.out.println("");
        
            Scanner sc = new Scanner(System.in);
        
            switch (sc.nextInt()) {
                case 1:  createOrder(); // Создание заявки.
                         OrderIO orderIO2 = new OrderIO(); // Добавление заявки в коллекцию заявок.
                         orderList.add(orderIO2.copyOrder());
                         break;
                case 2:  System.out.println("Просмотр заявок");
                         // Просмотр кллекции заявок.
                         if (orderList != null) System.out.println(orderList.toString());
                         break;
            }
            
        }
         
    }
    
    public static void createOrder() throws IOException { // формирование заявки
        
        // Добавление прочитанных данных из списка товаров в коллекцию:
        System.out.println("Список товаров:");
        System.out.println("");
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
        
        // Вывод в консоль коллекции списка товаров:
        for(int i = 0; i < good.size(); i++) {
            Object elements = good.get(i);
            System.out.println(elements);
        }
        
        System.out.println("");
        
        //Создание заявки и добавление туда выбранных пользователем товаров:
        ArrayList<Goods> orderGood = new ArrayList<>();
        
        int i = 0;
        for(;;) {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Что бы выбрать товар, нажмите y или n что бы завершить выбор");
            String b = sc.nextLine();
            if (b.equals("n")) break;
            System.out.println("Наберите номер товара, номера начинаюся с 0");
            int goodName = sc.nextInt();
            
            
            orderGood.add(good.get(goodName));
            
            System.out.println("");
        
            for(;;) {
                System.out.println("Введите количество: ");
                Scanner sc2 = new Scanner(System.in);
                int a = sc2.nextInt();
                if (orderGood.get(i).setStockBalance(a)) {
                    System.out.println("Недостаточное количество товара на складе");
                } else {
                    break;
                }
            }
            
            i = i + 1;
        }
        
        // Вывод в консоль добавленных товаров:
        System.out.println("Список выбранных товаров: ");
        for(int a = 0; a < orderGood.size(); a++) {
            Object elements = orderGood.get(a);
            System.out.println(elements);
        }
        
        System.out.println("");
        
        // Продолжение формирования заявки, добавление персональных данных:
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
        
        // Добавление статуса заявки:
        OrderStatus orderStatus = OrderStatus.PREPARING;
        String orderstatus = orderStatus.getStatus();
        
        // Создание объекта завка:
        Order order = new Order(LocalDate.now(), person, orderstatus, orderGood);
        
        System.out.println(order.toString());
        
        // Сохранение заявки в файл:
        OrderIO orderIO = new OrderIO();
        orderIO.saveOrder(order);  
        
    }  
    
}


package ru.avalon.java.dev.j120.laboratory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import ru.avalon.java.dev.j120.laboratory.IO.GoodsIO;
import ru.avalon.java.dev.j120.laboratory.IO.*;
import ru.avalon.java.dev.j120.laboratory.UI.NewJFrame;
import ru.avalon.java.dev.j120.laboratory.entity.Product;
import ru.avalon.java.dev.j120.laboratory.entity.Order;
import ru.avalon.java.dev.j120.laboratory.entity.OrderProduct;
import ru.avalon.java.dev.j120.laboratory.entity.OrderStatus;
import ru.avalon.java.dev.j120.laboratory.entity.Person;

public class Application {
  
    public static void main(String[] args) throws IOException {
        
        //NewJFrame frame = new NewJFrame();
        //frame.mainFrame();
        
        System.out.println("Добро пожаловать на место диспетчера \"Магазина на диване\"");
        System.out.println("");
        System.out.println("Обновить список товара на складе? (да - y, нет - n)");
        
        
        Scanner scUpdateGoods = new Scanner(System.in);
        if ("y".equals(scUpdateGoods.nextLine())) {
            createGoodList(); // Создает коллекцию good типа <Product>, добавляет в нее товары из файла и возвращает
            System.out.println("Список товаров обновлен!");
        }
        
        
        ArrayList<Order> orderList = new ArrayList<>(); // Создание коллекции заявок
        
        // Меню управления заявками:
        for(;;) {
            
            System.out.println("");
            System.out.println("Сформировать заявку: 1 ");
            System.out.println("Просмотреть все заявки: 2 ");
            System.out.println("Отгрузить или отменить заявки: 3 ");
            System.out.println("Редактировать заявки: 4 ");
            System.out.println("Удалить какую-либо заявку: 5 ");
            System.out.println("");
        
            Scanner sc = new Scanner(System.in);
        
            switch (sc.nextInt()) {
                // Формирование новой заявки:
                case 1:  // Загрузка коллекции сохраненных заявок из файла:
                         OrderListIO orderListIO1 = new OrderListIO();
                         ArrayList<Order> copyOrderList1 = orderListIO1.copyOrderList();
                         
                         createOrder(); // Создание новой заявки.
                         
                         // Добавление заявки в коллекцию заявок:
                         OrderIO orderIO2 = new OrderIO(); 
                         copyOrderList1.add(orderIO2.copyOrder());
                         
                         // Сохранение новой коллекции заявок в файл:
                         OrderListIO orderListIO = new OrderListIO();
                         orderListIO.saveOrderList(copyOrderList1);  
                          
                         break;
                // Просмотр коллекции заявок:         
                case 2:  // Загрузка коллекции сохраненных заявок из файла:
                         OrderListIO orderListIO2 = new OrderListIO();
                         ArrayList<Order> copyOrderList2 = orderListIO2.copyOrderList();
                         
                         // Проверка наличия заявок в коллекции и вывод ее в консоль:
                         if ("[]".equals(copyOrderList2.toString())) {
                             System.out.println("Заявок нет");
                             
                         } else {
                             System.out.println(copyOrderList2.toString()); // Вывод в консоль коллекции заявок.
                            
                             
                         }
                         break;
                // Отгрузить или отменить заявки:         
                case 3:  // Загрузка коллекции сохраненных заявок из файла:
                         OrderListIO orderListIO5 = new OrderListIO();
                         ArrayList<Order> copyOrderList4 = orderListIO5.copyOrderList();
                         
                         // Проверка наличия заявок в коллекции и вывод ее в консоль:
                         if ("[]".equals(copyOrderList4.toString())) {
                             System.out.println("Заявок нет");  
                         } else {
                             System.out.println(copyOrderList4.toString()); // Вывод в консоль коллекции заявок.
                             System.out.println("");
                             System.out.println("Введите номер заявки, статус которой хотите изменить:");
                             Scanner indexRedactor = new Scanner(System.in);
                             int ir = indexRedactor.nextInt();
                             System.out.println(copyOrderList4.get(ir).toString());
                            
                             System.out.println("");
                             System.out.println("Отгрузить заявку 1");
                             System.out.println("Отменить заявку 2");
                             
                             Scanner scStatusOrder = new Scanner(System.in);
                             
                             switch (scStatusOrder.nextInt()) {
                                 // Изменение статуса заявки:
                                 case 1:
                                     OrderStatus orderStatusRed = OrderStatus.SHIPPED;
                                     String orderstatus = orderStatusRed.getStatus();
                                     copyOrderList4.get(ir).setOrderStatus(orderstatus);
                                     break;
                                 case 2:
                                     OrderStatus orderStatusRed2 = OrderStatus.CANCELED;
                                     String orderstatus1 = orderStatusRed2.getStatus();
                                     copyOrderList4.get(ir).setOrderStatus(orderstatus1);
                                     break;
                             }
                            
                             System.out.println(copyOrderList4.toString()); 
                             
                            // Сохранение новой коллекции заявок в файл:
                            OrderListIO orderListIO6 = new OrderListIO();
                            orderListIO6.saveOrderList(copyOrderList4);  
                         }       
                         
                         
                         break;
                
                         
                // Редактирование заявок:         
                case 4:  // Загрузка коллекции сохраненных заявок из файла:
                         OrderListIO orderListIO6 = new OrderListIO();
                         ArrayList<Order> copyOrderList5 = orderListIO6.copyOrderList();
                         
                         // Проверка наличия заявок в коллекции и вывод ее в консоль:
                         if ("[]".equals(copyOrderList5.toString())) {
                             System.out.println("Заявок нет");  
                         } else {
                             System.out.println(copyOrderList5.toString()); // Вывод в консоль коллекции заявок.
                             System.out.println("");
                             System.out.println("Введите номер заявки, которую хотите отредактировать:");
                             Scanner indexRedactor = new Scanner(System.in);
                             int ir = indexRedactor.nextInt();
                             System.out.println(copyOrderList5.get(ir).toString());
                            
                             System.out.println("");
                             System.out.println("Добавить товар 1");
                             System.out.println("Удалить товар 2");
                             System.out.println("Изменить количество товара 3");
                             
                             
                             Scanner scStatusOrder = new Scanner(System.in);
                             
                             switch (scStatusOrder.nextInt()) {
                                 // Изменение статуса заявки:
                                 case 1:
                                     System.out.println("В разработке");
                                     //OrderStatus orderStatusRed = OrderStatus.SHIPPED;
                                     //String orderstatus = orderStatusRed.getStatus();
                                     //copyOrderList5.get(ir).setOrderStatus(orderstatus);
                                     break;
                                 case 2:
                                     System.out.println("В разработке");
                                     //OrderStatus orderStatusRed2 = OrderStatus.CANCELED;
                                     //String orderstatus1 = orderStatusRed2.getStatus();
                                     //copyOrderList5.get(ir).setOrderStatus(orderstatus1);
                                     break;
                                     
                                 case 3:
                                     System.out.println("В разработке");
                                     break;
                             }
                            
                            //System.out.println(copyOrderList5.toString()); 
                             
                            // Сохранение новой коллекции заявок в файл:
                            //OrderListIO orderListIO7 = new OrderListIO();
                            //orderListIO6.saveOrderList(copyOrderList5);  
                         }       
                                  
                         
                         break;
                         
                // Удаление заявок:         
                case 5:  // Загрузка коллекции сохраненных заявок из файла:
                         OrderListIO orderListIO3 = new OrderListIO();
                         ArrayList<Order> copyOrderList3 = orderListIO3.copyOrderList();
                         
                         // Проверка наличия заявок в коллекции и вывод ее в консоль:
                         if ("[]".equals(copyOrderList3.toString())) {
                             System.out.println("Заявок нет");  
                         } else {
                            System.out.println(copyOrderList3.toString()); // Вывод в консоль коллекции заявок.
                            System.out.println("");
                            System.out.println("Введите номер заявки, которую хотите удалить:");
                            Scanner indexRemove = new Scanner(System.in);
                            copyOrderList3.remove(indexRemove.nextInt()); // Удаление выбранной заявки из коллекции.
                            System.out.println("Выбранная заявка удалена");
                            System.out.println("");
                            System.out.println(copyOrderList3.toString()); // Вывод в консоль коллекции заявок с учетом удаленной.
                            
                            // Сохранение новой коллекции заявок в файл:
                            OrderListIO orderListIO4 = new OrderListIO();
                            orderListIO4.saveOrderList(copyOrderList3);  
                         }
                         break;         
            }    
        }     
    }
    
    // Создает коллекцию good типа <Product> и добавляет в нее товары из файла:
    public static void createGoodList() throws IOException {
        
        GoodsIO listGood = new GoodsIO();
        String text = new String(listGood.goodsIO());
        
        ArrayList<Product> good = new ArrayList<>();
        
        String [] lines = text.split("\n");
        for(String line : lines) {
            String [] words = line.split(";");
            if (words[2].equals("")) {
                good.add(new Product(words[0], words[1], "не указан", words[3], words[4]));
            } else {
                good.add(new Product(words[0], words[1], words[2], words[3], words[4]));
            }
        }
        
        
        // Сохранение коллекции товаров:
        GoodListIO goodlistIO1 = new GoodListIO();
        goodlistIO1.saveGoodList(good);
        
        
    }   
    
    // Формирование заявки:    
    public static void createOrder() throws IOException { 
        
        //Создание заявки и добавление туда выбранных пользователем товаров:
        ArrayList<OrderProduct> orderProduct = new ArrayList<>();
        
        // Загрузка коллекции товаров:
        GoodListIO goodlistIO3 = new GoodListIO();
        ArrayList<Product> goodList3 = goodlistIO3.copyGood();
        for(int i = 0; i < goodList3.size(); i++) {
            Object elements = goodList3.get(i);
            System.out.println(elements);
        }
        
        for(;;) {
            
            Scanner sc = new Scanner(System.in);
            System.out.println("");
            System.out.println("Что бы выбрать товар, нажмите y или n что бы завершить выбор");
            String b = sc.nextLine();
            if (b.equals("n")) break;
            System.out.println("Наберите номер товара, номера начинаюся с 0");
            int goodName = sc.nextInt();
            
            System.out.println("");
            
            int a;
            for(;;) {
                System.out.println("Введите количество: ");
                Scanner sc2 = new Scanner(System.in);
                a = sc2.nextInt();
                if (goodList3.get(goodName).setStockBalance(a)) {
                    System.out.println("Недостаточное количество товара на складе");
                } else {
                    
                    break;
                }
            }
            
            // Добавление в строку заказа данных о товаре:
            
            if (orderProduct.contains(new OrderProduct(goodList3.get(goodName).getArticleNumber(),
            goodList3.get(goodName).getName(), goodList3.get(goodName).getColor(), a,
            goodList3.get(goodName).getPrice()))) {
                System.out.println("Такой товар уже есть в заявке, выберете другой товар");
            } else {
            
                orderProduct.add(new OrderProduct(goodList3.get(goodName).getArticleNumber(),
                goodList3.get(goodName).getName(), goodList3.get(goodName).getColor(), a,
                goodList3.get(goodName).getPrice()));
            
            }
            
            //for(int i = 0; i < goodList3.size(); i++) {
            //    Object elements = goodList3.get(i);
            //    System.out.println(elements);
            //}
            
            GoodListIO goodlistIO4 = new GoodListIO();
            goodlistIO4.saveGoodList(goodList3);
            
        }
        
        // Вывод в консоль добавленных товаров:
        System.out.println("");
        System.out.println("Список выбранных товаров: ");
        for(int a = 0; a < orderProduct.size(); a++) {
            Object elements = orderProduct.get(a);
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
        
        Person person = new Person(contactPerson, deliveryAdress, phoneNumber);
        
        // Добавление статуса заявки:
        OrderStatus orderStatus = OrderStatus.PREPARING;
        String orderstatus = orderStatus.getStatus();
        
        
        
        // Создание объекта завка:
        Order order = new Order(LocalDate.now(), person, orderstatus, orderProduct, discount);
        
        System.out.println(order.toString());
        
        
        
        
        
        // Сохранение заявки в файл:
        OrderIO orderIO = new OrderIO();
        orderIO.saveOrder(order);  
        
    }  
    
}

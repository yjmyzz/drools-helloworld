package com.cnblogs.yjmyzz.drools.demo;

import java.util.List;

import com.cnblogs.yjmyzz.drools.demo.model.CartItem;
import com.cnblogs.yjmyzz.drools.demo.model.Customer;
import com.cnblogs.yjmyzz.drools.demo.model.Product;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolSampleApp {


    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            Product macBook = new Product("Mac笔记本", 15000);
            Product knife = new Product("大砍刀", 5000);
            knife.setRequiresRegistration(true);
            Product book = new Product("java从入门到放弃-电子书", 2000);
            Product tv = new Product("小米电视(缺货)", 2000);
            tv.setAvailableQty(0);
            Product iPhoneX = new Product("iPhoneX(供应紧张)", 10000);
            iPhoneX.setAvailableQty(2);

            Customer customer = Customer.newCustomer("张三");
            customer.addItem(macBook, 1);
            customer.addItem(knife, 2);
            customer.addItem(book, 5);
            customer.setCoupon("DISC01");

            List<CartItem> cartItems = customer.getCart().getCartItems();
            for (CartItem cartItem : cartItems) {
                kSession.insert(cartItem);
            }
            System.out.println("************* (张三)执行规则 **************");
            kSession.fireAllRules();
            System.out.println("************************************\n");
            System.out.println(customer + "\n");

//            Customer newCustomer = Customer.newCustomer("李四");
//            newCustomer.setNew(false);
//            newCustomer.addItem(macBook, 1);
//            newCustomer.addItem(knife, 2);
//            newCustomer.addItem(tv, 1);
//            newCustomer.addItem(iPhoneX, 10);
//
//            cartItems = newCustomer.getCart().getCartItems();
//            for (CartItem cartItem : cartItems) {
//                kSession.insert(cartItem);
//            }
//            kSession.insert(newCustomer.getCart());
//            kSession.setGlobal("outOfStockProducts", new ArrayList<Product>());
//            System.out.println("\n************* (李四)执行规则 **************");
//            kSession.fireAllRules();
//            System.out.println("************************************\n");
//            System.out.println(newCustomer + "\n");

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}

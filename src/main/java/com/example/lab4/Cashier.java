package com.example.lab4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Cashier {
    private List<change> coin;
//    private int num;

    public Cashier() {

        coin = new ArrayList<>();

    }
    private int b1000 ;
    private int b500 ;
    private int b100 ;
    private int b20;
    private int b10;
    private int b5;
    private int b1;
    @RequestMapping(value = "/getChange/{num}", method = RequestMethod.GET)
    public change getChange(@PathVariable("num") int num){
            b1000 =0;
            b500 =0;
            b100=0;
            b20 =0;
            b10 = 0;
            b5 = 0;
            b1 = 0;

        if (num >= 1000) {

                b1000 = num / 1000;
                num = num % 1000;
            }
            if (num >= 500) {
                b500 = num / 500;
                num = num % 500;
            }
            if (num >= 100) {
                b100 = num / 100;
                num = num % 100;
            }
            if (num >= 20) {
                b20 = num / 20;
                num = num % 20;
            }
            if (num >= 10) {
                b10 = num / 10;
                num = num % 10;
            }
            if (num >= 5) {
                b5 = num / 5;
                num = num % 5;
            }
            if (num >= 1) {
                b1 = num / 1;
            }
            coin.add(new change(b1000,b500,b100,b20,b10,b5,b1));

            return coin.get(coin.size()-1);
    }

}

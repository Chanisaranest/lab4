package com.example.lab4;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.websocket.server.PathParam;

@RestController
public class MathAPI {
    @RequestMapping(value = "/plus/{n1}/{n2}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("n1") double n1,
                         @PathVariable("n2") double n2){
            return n1+n2;
    }
    @RequestMapping(value = "/minus/{n1}/{n2}" , method = RequestMethod.GET)
    public double myMinus(@PathVariable("n1") double n1,
                          @PathVariable("n2") double n2){
        return n1-n2;
    }
    @RequestMapping(value = "/divide/{n1}/{n2}" , method = RequestMethod.GET)
    public double myDivide(@PathVariable("n1") double n1,
                          @PathVariable("n2") double n2){
        return n1/n2;
    }
    @RequestMapping(value = "/multi/{n1}/{n2}" , method = RequestMethod.GET)
    public double myMulti(@PathVariable("n1") double n1,
                          @PathVariable("n2") double n2){
        return n1*n2;
    }
    @RequestMapping(value = "/mod/{n1}/{n2}" , method = RequestMethod.GET)
    public double myMod(@PathVariable("n1") double n1,
                        @PathVariable("n2") double n2){
        return n1 % n2 ;
    }
    @RequestMapping(value = "/max" , method = RequestMethod.POST)
    public double myMax(@PathParam("n1") double n1,
                          @PathParam("n2") double n2){
        var num_max = Math.max(n1,n2);
        return num_max;
    }
}

package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Route( value = "index1")
public class MathView extends FormLayout {
    private TextField n1,n2,n3;
    private Button btnPlus,btnMinus,btndivide,btnMulti,btnMod,btnMax;
    private Label text;
    public MathView(){
        n1 = new TextField("Number1");
        n2 = new TextField("Number2");
        n3 = new TextField("Answer");
        btnPlus = new Button("+");
        btnMinus = new Button("-");
        btnMulti = new Button("x");
        btndivide = new Button("/");
        btnMod = new Button("Mod");
        btnMax = new Button("Max");
        text = new Label("Operator");
        HorizontalLayout h1 = new HorizontalLayout();

        VerticalLayout v1 = new VerticalLayout();
        h1.add(btnPlus,btnMinus,btnMulti,btndivide,btnMod,btnMax);
        v1.add(n1,n2,text,h1,n3);
        this.add(v1);

        btnPlus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/plus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });
        btnMinus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });
        btnMinus.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/minus/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });
        btnMulti.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/multi/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });

        btndivide.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/divide/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });
        btnMod.addClickListener(event ->{
            double num1 = Double.parseDouble(n1.getValue());
            double num2 = Double.parseDouble(n2.getValue());

            String out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/mod/"+num1+"/"+num2)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            n3.setValue(out);
        });

         btnMax.addClickListener(event ->{
             MultiValueMap<String,String> formData = new LinkedMultiValueMap<>();
             formData.add("n1", n1.getValue());
             formData.add("n2",n2.getValue());

             String out = WebClient.create()
                    .post()
                     .uri("http://localhost:8080/max")
                     .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                     .body(BodyInserters.fromFormData(formData))
                     .retrieve()
                     .bodyToMono(String.class)
                     .block();
             n3.setValue(out);
         });


    }
}

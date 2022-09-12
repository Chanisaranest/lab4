package com.example.lab4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

@Route( value = "index2")
public class CashierView extends VerticalLayout {
    private TextField n1,n2,n3,n4,n5,n6,n7,n8;
    private Button btn;

    public CashierView(){
        n1 = new TextField();
        n1.setPrefixComponent(new Span("$"));
        n2 = new TextField();
        n2.setPrefixComponent(new Span("$1000:"));
        n3 = new TextField();
        n3.setPrefixComponent(new Span("$500:"));
        n4 = new TextField();
        n4.setPrefixComponent(new Span("$100:"));
        n5 = new TextField();
        n5.setPrefixComponent(new Span("$20:"));
        n6 = new TextField();
        n6.setPrefixComponent(new Span("$10:"));
        n7 = new TextField();
        n7.setPrefixComponent(new Span("$5:"));
        n8 = new TextField();
        n8.setPrefixComponent(new Span("$1:"));
        btn = new Button("คำนวณเงินทอน");
        VerticalLayout v1 = new VerticalLayout();
        v1.add(n1,btn,n2,n3,n4,n5,n6,n7,n8);
        this.add(v1);

        btn.addClickListener(event ->{
            int num = Integer.parseInt(n1.getValue());
            change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+num)
                    .retrieve()
                    .bodyToMono(change.class)
                    .block();

            n2.setValue( String.valueOf(out.getB1000()));
            n3.setValue(String.valueOf(out.getB500()));
            n4.setValue(String.valueOf(out.getB100()));
            n5.setValue( String.valueOf(out.getB20()));
            n6.setValue( String.valueOf(out.getB10()));
            n7.setValue( String.valueOf(out.getB5()));
            n8.setValue(String.valueOf(out.getB1()));
        });
    }
}

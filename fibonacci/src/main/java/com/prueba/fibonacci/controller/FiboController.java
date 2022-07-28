package com.prueba.fibonacci.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Fibo")
public class FiboController {

    @GetMapping
    public String getFibSecService(){
        Date currentDate =new Date();
        SimpleDateFormat formatter =new SimpleDateFormat("mm");
        String line = formatter.format(currentDate)+"";

        List<Integer> ints = Arrays.stream(line.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int series=6;
        int num1=ints.get(0);
        int num2=ints.get(1);
        int suma=0;
        String result="";

        List<Integer> sums=new ArrayList<Integer>();

        for (int i = 1; i < series; i++) {
            sums.add(suma);
            suma = num1 + num2;
            num1 = num2;
            num2 = suma;

        }
        Collections.sort(sums, Collections.reverseOrder());

        for (int num : sums)
        {
            result+=num+",";
        }

        //result=result.substring(2,result.length());
        StringBuffer sb= new StringBuffer(result);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);

        return sb+"";
    }





}

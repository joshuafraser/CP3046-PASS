package pojo;

import javax.faces.bean.ManagedBean;

/**
 * Created by Stuart on 28/03/2015.
 */

@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {

    public HelloWorld(){
        System.out.println("HelloWorld started!");
    }

    public String getMessage(){
        return "Hello World!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    }


}

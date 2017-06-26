import beanDefinitionReader.*;
import config.BeanDefinitionRegistry;

/**
 * Created by siren on 2017/6/25.
 */
public class TestBeanDefinitionReader {

    public static void main(String[] args) throws Exception {
        BeanDefinitionReader reader = new XMLBeanDefinitionReader();

        BeanDefinitionRegistry registry = reader.read("xmlConfig.xml");



        p(registry.getBeanDefinitionById("dao").toString());


    }

    public static void p(String test) {
        System.out.println(test);
    }

}

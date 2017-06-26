package container;

import beanDefinitionReader.BeanDefinitionReader;
import config.BeanDefinitionRegistry;

import java.util.List;
import java.util.Map;

/**
 * Created by siren on 2017/6/25.
 */
public class BeanFactory {
    private BeanDefinitionRegistry registry;
    private Map<String, Object> beans;

    public BeanFactory(BeanDefinitionReader reader, String path) {
        factoryInit(reader, path);
        beanInstantiation();
        beanInitialization();
        beanPropertyInjection();
    }

    public Object getBean(String beanId) {

        return null;
    }

    private void factoryInit(BeanDefinitionReader reader, String path) {
        try {
            this.registry = reader.read(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void beanInstantiation() {

    }

    private void beanInitialization() {

    }

    private void beanPropertyInjection() {

    }

    private void beanDestroy() {

    }


}

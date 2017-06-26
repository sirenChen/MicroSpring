package config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by siren on 2017/6/25.
 */
public class BeanDefinitionRegistry implements Iterator {
    private Map<String, BeanDefinition> beanDefinitions;

    public BeanDefinitionRegistry(Map<String, BeanDefinition> beanDefinitions) {
        this.beanDefinitions = beanDefinitions;
    }

    public BeanDefinition getBeanDefinitionById(String beanId) {
        return beanDefinitions.get(beanId);
    }

    public String getClassNameById(String beanId) {
        return beanDefinitions.get(beanId).getClassName();
    }

    public List<PropertyDefinition> getPropertyDefinitions(String beanId) {
        Map<String, PropertyDefinition> pMap = beanDefinitions.get(beanId).getPropertyDefinitions();
        return new ArrayList<PropertyDefinition>(pMap.values());
    }

    public List<BeanDefinition> getBeanDefinitions() {
        return new ArrayList<BeanDefinition>(beanDefinitions.values());
    }

    public boolean hasNext() {
        return beanDefinitions.values().iterator().hasNext();
    }

    public Object next() {
        return beanDefinitions.values().iterator().next();
    }

    public void remove() {
        beanDefinitions.values().iterator().remove();
    }
}

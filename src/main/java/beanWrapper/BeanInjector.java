package beanWrapper;

import config.BeanDefinition;
import config.BeanDefinitionRegistry;
import config.PropertyDefinition;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by siren on 2017/6/25.
 */
public class BeanInjector {

    private BeanDefinitionRegistry registry;
    private Map<String, Object> beans;

    BeanWrapper beanWrapper;

    public void setAllProperty() {

        while (registry.hasNext()) {
            BeanDefinition beanDefinition = (BeanDefinition) registry.next();
            setProperty(beanDefinition.getId());
        }

    }

    public void setProperty(String beanId) {

        List<PropertyDefinition> pDefs = registry.getPropertyDefinitions(beanId);

        for (PropertyDefinition pDef : pDefs) {
            String pName = pDef.getName();
            String pValue = pDef.getValue();
            String pRef = pDef.getValue();

            if (pName != null) {
                //beanWrapper.setPro(beans.get(beanId), pName, pValue);
            }

            if (pRef != null) {
                //beanWrapper.setPro(beans.get(beanId), pName, pValue);
            }

        }

    }

}

package container;

import org.apache.commons.beanutils.BeanUtils;
import config.BeanDefinition;
import config.PropertyDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siren Chen
 * maintain an Ioc container and do the injection
 */
@Deprecated
public class BeanFactoryOld {

    private Map<String, BeanDefinition> beanDefinitionMap;
    private Map<String, Object> container = new HashMap<String, Object>();

    /**
     * get the bean implementation
     * @param beanId bean id
     * @return implementation class
     */
    public Object getBean(String beanId) {
        return container.get(beanId);
    }

    /**
     * initial all the beans and do the injection
     * @param beanDefinitionMap
     */
    public BeanFactoryOld(Map<String, BeanDefinition> beanDefinitionMap) {
        this.beanDefinitionMap = beanDefinitionMap;

        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanId = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();

            container.put(beanId, createObject(beanDefinition));
        }

        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            setPro(entry.getValue());
        }
    }

    /**
     * According to the xml bean tag, create the bean object
     * @param beanDefinition from xml configuration file
     * @return bean object
     */
    private Object createObject(BeanDefinition beanDefinition) {
        String className = beanDefinition.getClassName();
        Class clazz = null;
        Object bean = null;

        // find class and new instance
        try {
            clazz = Class.forName(className);
            bean = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

    /**
     * for each Bean, set the property
     * @param beanDefinition
     */
    private void setPro(BeanDefinition beanDefinition) {

//        if (beanDefinition.getProperties() != null) {
//
//            for (PropertyDefinition propertyDefinition : beanDefinition.getProperties()) {
//                String pName = propertyDefinition.getName();
//                String value = propertyDefinition.getValue();
//                String ref  = propertyDefinition.getRef();
//
//                try {
//                    if (value != null) {
//                        BeanUtils.setProperty(container.get(beanDefinition.getId()), pName, value);
//                    }
//
//                    if (ref != null) {
//                        BeanUtils.setProperty(container.get(beanDefinition.getId()), pName, container.get(ref));
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
    }


}

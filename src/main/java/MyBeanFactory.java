import xmlConfig.BeanTag;
import xmlConfig.PropertyTag;
import xmlConfig.XmlConfigManager;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean factory,
 */
public class MyBeanFactory {
    private Map<String, BeanTag> xmlBeanMap;
    public Map<String, Object> container = new HashMap<String, Object>();


    /**
     * load the configuration file, init the container
     * @param path
     */
    public MyBeanFactory(String path) {
        xmlBeanMap = XmlConfigManager.getBeanConfig(path);

        for (Map.Entry<String, BeanTag> entry : xmlBeanMap.entrySet()) {
            String beanId = entry.getKey();
            BeanTag beanTag = entry.getValue();

            if (container.get(beanId) == null) {
                Object bean = createObject(beanTag);
                container.put(beanId, bean);
            }

        }
    }

    /**
     * According to the xml bean tag, create the bean object
     * @param beanTag from xml configuration file
     * @return bean object
     */
    private Object createObject(BeanTag beanTag) {
        String className = beanTag.getClassName();
        Class clazz = null;
        Object bean = null;

        // find class and new instance
        try {
            clazz = Class.forName(className);
            bean = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // user setter method to do the injection
        if (beanTag.getProperties() != null) {

            for (PropertyTag propertyTag : beanTag.getProperties()) {
                String pName = propertyTag.getName();
                String value = propertyTag.getValue();
                String ref  = propertyTag.getRef();

                Method setter = getSetter(bean, pName);
                Object prop = null;

                if (ref != null) {
                    Object existBean = container.get(propertyTag.getRef());

                    if (existBean == null) {
                        existBean = createObject(xmlBeanMap.get(propertyTag.getRef()));
                        container.put(propertyTag.getRef(), existBean);
                    }

                    prop = existBean;
                }

                try {
                    setter.invoke(bean, prop);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

        return bean;
    }

    /**
     *
     * @param bean bean object
     * @param filedName user to find the setter method
     * @return setter method
     */
    private Method getSetter(Object bean, String filedName) {
        Method setter = null;

        try {
            BeanInfo info = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();

            if (propertyDescriptors != null) {

                for (PropertyDescriptor pd : propertyDescriptors) {

                    String pName = pd.getName();

                    if (pName.equals(filedName)) {
                        setter = pd.getWriteMethod();
                    }

                }

            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        return setter;
    }

}

package beanDefinitionReader;

import config.BeanDefinition;
import config.BeanDefinitionRegistry;
import config.PropertyDefinition;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.*;

public class XMLBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> beanDefinitions = new HashMap<String, BeanDefinition>();

    public BeanDefinitionRegistry read(String path) throws DocumentException {
        Element root = this.getRootElement(path);
        this.readBeanDefinition(root);

        return new BeanDefinitionRegistry(this.beanDefinitions);
    }

    private Element getRootElement(String path) throws DocumentException {
        String classpath = this.getClass().getResource("/").toString();

        SAXReader reader = new SAXReader();
        Document document = reader.read(classpath + path);
        Element root = document.getRootElement();

        return root;
    }

    private void readBeanDefinition(Element root) {
        List beanElements = root.elements("bean");

        Iterator it = beanElements.iterator();
        while (it.hasNext()) {
            Element beanElement = (Element) it.next();

            String id = beanElement.attributeValue("id");
            String clazz = beanElement.attributeValue("class");
            Map<String, PropertyDefinition> propertyDefinitions = this.readBeanProperty(beanElement);

            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(clazz);
            beanDefinition.setPropertyDefinitions(propertyDefinitions);

            this.beanDefinitions.put(id, beanDefinition);
        }

    }

    private Map<String, PropertyDefinition> readBeanProperty(Element beanElement) {
        Map<String, PropertyDefinition> propertyDefinitions = new HashMap<String, PropertyDefinition>();
        List propertyElements = beanElement.elements("property");

        Iterator it = propertyElements.iterator();
        while (it.hasNext()) {
            Element propertyElement = (Element) it.next();

            String pName = propertyElement.attributeValue("name");
            String pValue = propertyElement.attributeValue("value");
            String pRef = propertyElement.attributeValue("ref");

            PropertyDefinition propertyDefinition = new PropertyDefinition();
            propertyDefinition.setName(pName);
            propertyDefinition.setValue(pValue);
            propertyDefinition.setRef(pRef);

            propertyDefinitions.put(pName, propertyDefinition);
        }

        return propertyDefinitions;
    }



    public static void p(String test) {
        System.out.println(test);
    }

}

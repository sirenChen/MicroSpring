package config;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Siren Chen.
 * get the bean configuration from the xml config file
 */
public class XmlConfigManager {

    /**
     * get the bean config information
     * @param path xml configuration file path
     * @return Map<String BeanDefinition>
     */
    public static Map<String, BeanDefinition> getBeanConfig(String path) {
        Map<String, BeanDefinition> beanTags = new HashMap<String, BeanDefinition>();

        // init the SAXReader
        SAXReader reader = new SAXReader();
        InputStream inputStream = XmlConfigManager.class.getClassLoader().getResourceAsStream(path);

        // read
        Document document = null;
        try {
            document = reader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException("check your xml file.....");
        }

        Element root = document.getRootElement();
        List<Element> xmlBeans = root.elements("bean");

        // Beans encapsulation
        for (Element xmlBean : xmlBeans) {
            //Tag init
            BeanDefinition beanDefinition = new BeanDefinition();
            List<PropertyDefinition> propertyDefinitions = new ArrayList<PropertyDefinition>();

            // properties encapsulation
            List<Element> xmlProperties = xmlBean.elements("property");
            for (Element xmlProperty : xmlProperties) {
                PropertyDefinition propertyDefinition = new PropertyDefinition();

                propertyDefinition.setName(xmlProperty.attributeValue("name"));
                propertyDefinition.setRef(xmlProperty.attributeValue("ref"));
                propertyDefinition.setValue(xmlProperty.attributeValue("value"));

                propertyDefinitions.add(propertyDefinition);
            }

            beanDefinition.setId(xmlBean.attributeValue("id"));
            beanDefinition.setClassName(xmlBean.attributeValue("class"));
            beanDefinition.setProperties(propertyDefinitions);

            beanTags.put(xmlBean.attributeValue("id"), beanDefinition);
        }

        return beanTags;
    }

}

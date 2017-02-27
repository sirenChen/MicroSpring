package xmlConfig;

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
 * get the bean configuration from the xmlConfig file
 */
public class XmlConfigManager {

    /**
     * get the bean config information
     * @param path xml configuration file path
     * @return Map<String, BeanTag>
     */
    public static Map<String, BeanTag> getBeanConfig(String path) {
        Map<String, BeanTag> beanTags = new HashMap<String, BeanTag>();

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
            BeanTag beanTag = new BeanTag();
            List<PropertyTag> propertyTags = new ArrayList<PropertyTag>();

            // properties encapsulation
            List<Element> xmlProperties = xmlBean.elements("property");
            for (Element xmlProperty : xmlProperties) {
                PropertyTag propertyTag = new PropertyTag();

                propertyTag.setName(xmlProperty.attributeValue("name"));
                propertyTag.setRef(xmlProperty.attributeValue("ref"));
                propertyTag.setValue(xmlProperty.attributeValue("value"));

                propertyTags.add(propertyTag);
            }

            beanTag.setId(xmlBean.attributeValue("id"));
            beanTag.setClassName(xmlBean.attributeValue("class"));
            beanTag.setProperties(propertyTags);

            beanTags.put(xmlBean.attributeValue("id"), beanTag);
        }

        return beanTags;
    }

}

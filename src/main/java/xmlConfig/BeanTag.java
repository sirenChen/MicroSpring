package xmlConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siren Chen.
 * Encapsulate the Bean Tag information in XmlConfig file
 */
public class BeanTag {
    private String id;
    private String className;

    private List<PropertyTag> properties = new ArrayList<PropertyTag>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<PropertyTag> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyTag> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "xmlConfig.BeanTag{" +
                "id='" + id + '\'' +
                ", className='" + className + '\'' +
                ", properties=" + properties +
                '}';
    }
}

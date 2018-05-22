package com.infor.connect;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
JAXB based xml parser to store the xml from object
 */
@XmlRootElement(name = "TaskList")
public class DatabaseQueryWrapper {

    private Map<String, DatabaseQuery> queries = new HashMap<>();

    @XmlElement(name = "Task")
    public Map<String,DatabaseQuery> getQueries() {
        return queries;
    }

    public void setQueries(final Map<String,DatabaseQuery> queries) {
        this.queries = queries;
    }
}

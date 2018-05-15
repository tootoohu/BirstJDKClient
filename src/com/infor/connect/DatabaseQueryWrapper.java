package com.infor.connect;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "TaskList")
public class DatabaseQueryWrapper {

    private List<DatabaseQuery> queries = new ArrayList<>();

    @XmlElement(name = "Task")
    public List<DatabaseQuery> getQueries() {
        return queries;
    }

    public void setQueries(final List<DatabaseQuery> queries) {
        this.queries = queries;
    }
}

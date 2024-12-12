package com.demo.basics.designpatterns._05_prototype;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrototypePatternTest {

    @Test
    public void test() throws CloneNotSupportedException {

        Employees empList = new Employees(new ArrayList<>());
        empList.seedData();
        Employees dataSet1 = (Employees) empList.clone();
        Employees dataSet2 = (Employees) empList.clone();
        Assertions.assertEquals(dataSet1.getEmpList().size(), dataSet2.getEmpList().size());

        dataSet2.getEmpList().add("john");
        Assertions.assertNotEquals(dataSet1.getEmpList().size(), dataSet2.getEmpList().size());
    }

}

@AllArgsConstructor
@Data
class Employees implements Cloneable {

    private List<String> empList;

    public void seedData() {
        //Invoke a remote call and fetch data and load it to list. The fetch is costly operation.
        for (int i = 0; i < 100; i++) {
            empList.add("employee_" + i);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        for (String s : this.empList) {
            temp.add(s);
        }
        return new Employees(temp);
    }
}
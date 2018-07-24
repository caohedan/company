package com.oocl.company.model;

import org.springframework.stereotype.Component;
@Component
public class Employee {
        private Integer id;
        private String name;
        private Integer age;
        private String gender;
        private Integer salary;
        private Integer companyId;
        public Employee() {
        }

        public Employee(  Integer companyId,Integer id,String name, Integer age, String gender, Integer salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.salary = salary;
            this.companyId = companyId;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Employee setName(String name) {
            this.name = name;
            return this;
        }

        public Integer getAge() {
            return age;
        }


        public String getGender() {
            return gender;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }



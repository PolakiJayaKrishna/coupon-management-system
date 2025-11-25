    package com.example.couponmanagement.model;

    import java.util.List;

    public class UserContext {

        private String userId;
        private int totalOrders;
        private int age;
        private String location;
        private List<String> pastCategories;

        public UserContext() { }

        public UserContext(String userId, int totalOrders, int age, String location, List<String> pastCategories) {
            this.userId = userId;
            this.totalOrders = totalOrders;
            this.age = age;
            this.location = location;
            this.pastCategories = pastCategories;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getTotalOrders() {
            return totalOrders;
        }

        public void setTotalOrders(int totalOrders) {
            this.totalOrders = totalOrders;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public List<String> getPastCategories() {
            return pastCategories;
        }

        public void setPastCategories(List<String> pastCategories) {
            this.pastCategories = pastCategories;
        }
    }

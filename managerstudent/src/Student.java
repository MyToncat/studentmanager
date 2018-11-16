public class Student {
        private String name;
        private int age;
        private double grade;
        public Student(String name1,int age1,double grade1){
            this.name=name1;
            this.age=age1;
            this.grade=grade1;
        }

        //置换
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }
}

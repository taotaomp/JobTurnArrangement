package cn.PApudding.People;

public class SingleClass {
    private String className;

    public String getClassName() {
        return className;
    }

    private SinglePerson[] persons = new SinglePerson[2];

    public SinglePerson[] getPersons() {
        return persons;
    }

    public SinglePerson getSinglePerson(int i){
        return persons[i];
    }

    /**
     * 构造函数
     * @param personName1 人1
     * @param personName2 人2
     * @param className 班名
     */
    public SingleClass(String personName1, String personName2, String className) {
        this.persons[0] = new SinglePerson();
        this.persons[1] = new SinglePerson();
        this.persons[0].setName(personName1);
        this.persons[1].setName(personName2);
        this.className = className;
    }

    /**
     * 该班中是否包含特定的人
     * @param personName 待查人
     * @return 是否包含
     */
    public boolean isContainPerson(String personName) {
        for (int i = 0; i < persons.length; i++) {
            if(personName.equals(persons[i].getName())){
                return true;
            }
        }
        return false;
    }
}

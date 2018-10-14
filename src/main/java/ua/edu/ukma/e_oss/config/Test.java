package ua.edu.ukma.e_oss.config;

class Test {
    public String name;
    public int i;

    public Test()
    {

    }

    public Test(String n,int ig)
    {
        name = n;
        i = ig;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", i=" + i +
                '}';
    }
}
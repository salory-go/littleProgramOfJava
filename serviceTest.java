public class serviceTest {
    public static void main(String[] args) {
        //先测试添加用户和存储数据单元
        service test = new service();

        //测试添加用户功能
        //添加一个学生类、成人类、老年人类,添加的时候如果名字出错则会重写添加
//        test.addCustomer();
//        test.addCustomer();
//        test.addCustomer();

        //测试载入数据
        test.loadData();

        //测试打印积分高于50
        test.print();

        //测试编辑功能
//        test.editCustomer();
//        test.print();

        //测试购买
//        test.AttainPoints(test.customers.get(0));
//        test.AttainPoints(test.customers.get(1));
//        test.AttainPoints(test.customers.get(2));
//        test.print();

        //测试兑换
//        test.PointsExchaneg(test.customers.get(0));
//        test.PointsExchaneg(test.customers.get(1));
//        test.PointsExchaneg(test.customers.get(2));

        //测试存储功能
        test.saveData();
    }
}

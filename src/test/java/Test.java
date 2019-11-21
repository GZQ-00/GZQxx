import com.gzq.po.Stu;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test {
    @org.junit.Test
    public void te() {
        //1.获取sessionFactory 会话工厂
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //2.生产会话 通过opensession 获取session对象
        Session session = sessionFactory.openSession();
        //3.开启事务
        Transaction transaction = session.beginTransaction();
        //4.2执行查询
//        Stu stu1 = session.load(Stu.class, 2);
//        System.out.println("stu1" + stu1);
//        提交事务
    //   transaction.commit();
//        //关闭session
//        session.close();
//        session = sessionFactory.openSession();
//        transaction = session.beginTransaction();
//        //4.执行查询 get(要查询的类型,参数)
//        Stu stu = session.load(Stu.class, 2);
//        System.out.println("stu:" + stu);
//        String s = "from Stu where id=:gzq";
//        //4.3执行查询
//        Query query = session.createQuery(s);
//        //占位符从0开始
//        query.setParameter("gzq", 2);
//        Object o = query.uniqueResult();
//        System.out.println("o:" + o);


//        //5查询全部
//        Query query1 = session.createQuery("from Stu");
//        List<Stu> list = query1.list();
//        for (Stu stu2 : list) {
//            System.out.println("stu2 = " + stu2);
//        }

//        SQLQuery sqlQuery = session.createSQLQuery("select * from stu");
//        sqlQuery.addEntity(Stu.class);
//        List list1 = sqlQuery.list();
//        for (Stu stu3:list1){
//            System.out.println("stu2 = " + stu3);
//        }
            //新增
            Stu stu=new Stu();
            stu.setName("小明");
            session.save(stu);
            //删除
        Stu stu1 = session.get(Stu.class, 2);
        if (stu1!=null){
            session.delete(stu1);
        }
            //修改
        Stu stu2=new Stu();
        stu2.setId(2);
        stu2.setName("小强");
        session.update(stu2);

        //修改新增
        Stu stu3=new Stu();
        stu3.setId(2);
        stu3.setName("小蓝");
        session.saveOrUpdate(stu3);
        System.out.println("sdsdsd");
    }

}

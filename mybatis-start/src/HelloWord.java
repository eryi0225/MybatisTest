import com.yibai.mybatis.models.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.Reader;

public class HelloWord {
    private static SqlSessionFactory sessionFactory;

    private static Reader reader;

    static {

        try {
            reader = Resources.getResourceAsReader("config/configure.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void main(String[] args) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            User user = (User)sqlSession.selectOne("com.yibai.mybatis.models.UserMapper",1);
            if(user!=null){
                String userInfo = "名字："+user.getName()+", 所属部门："+user.getDept()+", 主页："+user.getWebsite();
                System.out.println(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }



}

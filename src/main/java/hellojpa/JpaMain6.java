package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain6 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            // 영속
            Member2 member2 = new Member2(202L, "member200");
            em.persist(member2);

            //em.flush();

            System.out.println("===================================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace(); //이 부분을 추가하면 예외를 확인할 수 있습니다.
        } finally {
            em.close();
        }

        emf.close();
    }
}

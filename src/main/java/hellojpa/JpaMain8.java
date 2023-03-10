package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain8 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member3 member = new Member3();
            member.setId(1L);
            member.setUsername("A");
            member.setRoleType(RoleType.ADMIN);

            em.persist(member);

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

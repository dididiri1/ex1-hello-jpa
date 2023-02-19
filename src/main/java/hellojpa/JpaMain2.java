package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            // 비영속
            Member2 member2 = new Member2();
            member2.setId(101L);
            member2.setName("HelloJPA");

            // 영속
            System.out.println("=== BEFORE ===");
            em.persist(member2);
            System.out.println("=== AFTER ===");

            Member2 findMember2 = em.find(Member2.class, 101L);

            System.out.println("findMember.getId() = " + findMember2.getId());
            System.out.println("findMember.getName() = " + findMember2.getName());
            
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

package br.com.project1.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

public class PhaseListenerProject1 implements PhaseListener {

    @Override
    public void beforePhase(PhaseEvent phase) {
        System.out.println("Antes da Fase: " + phase.getPhaseId().toString());
        if (phase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Criando uma session.");
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
        
    }
    
    @Override
    public void afterPhase(PhaseEvent phase) {
        System.out.println("Depois da Fase: " + phase.getPhaseId().toString());
        if (phase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    System.out.println("Fazendo o RollBack.");
                    session.getTransaction().rollback();
                }
            } finally {
                session.close();
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}

package service;

import dao.PropositionsDAO;
import entities.Propositions;

public class PropositionService {
    private PropositionsDAO dao = new PropositionsDAO();

    public Propositions createProposition(Propositions propositions) { return this.dao.save(propositions); }
}

package service;

import dao.SondageDAO;
import entities.Sondage;

public class SondageService {
    private SondageDAO dao = new SondageDAO();

    public Sondage createSondage(Sondage sondage) { return this.dao.save(sondage); }
}

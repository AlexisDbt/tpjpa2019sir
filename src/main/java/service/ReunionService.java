package service;

import dao.ReunionDAO;
import entities.Reunion;

public class ReunionService {
    private ReunionDAO dao = new ReunionDAO();

    public Reunion createReunion(Reunion reunion) { return this.dao.save(reunion); }

}

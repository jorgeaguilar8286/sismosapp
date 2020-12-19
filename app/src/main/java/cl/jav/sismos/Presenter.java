package cl.jav.sismos;

import java.util.List;

public class Presenter implements PresenterRepositorio {
    PresenterView view;
    Repositorio repositorio;

    public Presenter(PresenterView view, Repositorio repositorio) {
        this.view = view;
        this.repositorio = repositorio;
        repositorio.setPresenterRepositorio(this);
        repositorio.loadInfo();
    }

    @Override
    public void showInfo(List<SismosLista> listasismos) {
        view.showInfo(listasismos);
    }
}

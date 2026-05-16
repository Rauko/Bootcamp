package hometask.storage;

import hometask.exceptions.FigureNotFoundException;
import hometask.figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class FigureStorage<T extends Figure> {
    private final List<T> figures = new ArrayList<>();

    public void add(T figure) {
        figures.add(figure);
    }

    public T getById(int id) {
        if (id < 0 || id >= figures.size()) {
            throw new FigureNotFoundException("Figure " + id + " not found.");
        }
        return figures.get(id);
    }

    public int size() {
        return figures.size();
    }
}

package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Observer;

import java.util.ArrayList;

public class LapizLevantado implements Lapiz, Observable{
    private ArrayList<Observer> observers;
    private Trazo trazo;
    public LapizLevantado(){
        observers = new ArrayList<>();
    }

    public void pintar(Trazo trazo, Pizarra pizarra) {
        this.trazo = trazo;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }
}
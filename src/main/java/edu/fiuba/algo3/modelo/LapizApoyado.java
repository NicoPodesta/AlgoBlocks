package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.vista.Observer;

import java.util.ArrayList;

public class LapizApoyado implements Lapiz , Observable{
    private ArrayList<Observer> observers;

    public LapizApoyado(){
        observers = new ArrayList<>();
    }
    public void pintar(Trazo trazo, Pizarra pizarra) {
        pizarra.pintarTrazo(trazo);
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
package com.example.marveldatabase.utils

class ObservableTemp<T>(observable: T? = null) {
    interface ObserverTemp<T> {
        fun onChanged(newValue: T?)
    }

    var observers: ArrayList<ObserverTemp<T>> = ArrayList()

    fun subscribe(observer: ObserverTemp<T>) {
        observers.add(observer)
        observer.onChanged(observableValue)
    }

    fun unsubscribe(observer: ObserverTemp<T>) {
        observers.remove(observer)
    }

    private var observableValue = observable
    fun setValue(value: T?) {
        for (o in observers) {
            observableValue = value
            o.onChanged(observableValue)
        }
    }
}
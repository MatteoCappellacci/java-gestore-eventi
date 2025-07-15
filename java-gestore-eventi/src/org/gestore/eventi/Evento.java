package org.gestore.eventi;

import java.time.LocalDate;

public class Evento {

    private String titolo;

    private LocalDate data;

    private int postiTotali;

    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali) {
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;



}

    public String getTitolo() {
    return this.titolo;
}

    public void setTitolo(String titolo) {

    this.titolo = titolo;
}

    public LocalDate getData() {
    return this.data;
}

    public void setData(LocalDate data) {
    this.data = data;
}

    public int getPostiTotali() {
    return this.postiTotali;
}

   public int getPostiPrenotati() {
    return this.postiPrenotati;
}


// metodo prenotazione

public void prenota() {
    if (LocalDate.now().isAfter(data)) {
        throw new IllegalStateException("L'evento è già passato, non è possibile prenotare.");
    } else if (postiPrenotati >= postiTotali) {
        throw new IllegalStateException("Posti esauriti.");
    } else {
        postiPrenotati++;
        System.out.println("<[La prenotazione è stata effettuata con successo]>");
    }
}


// metodo disdetta 

public void disdici() {
    if (LocalDate.now().isAfter(data)) {
        throw new IllegalStateException("L'evento è già passato, non è possibile disdire.");
    } else if (postiPrenotati <= 0) {
        throw new IllegalStateException("Nessuna prenotazione da disdire.");
    } else {
        postiPrenotati--;
        System.out.println("<[La prenotazione è stata disdetta con successo]>");

    }
}
@Override
public String toString() {
    return "Evento: " + getTitolo() + " - Data: " + getData() + " - PostiPrenotati: [" +
            getPostiPrenotati() + "/" + getPostiTotali() + "]";
}




}
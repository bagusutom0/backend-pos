public class Makanan extends Product{
    private String rasa;

    public String getRasa() {
        return this.rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    @Override
    void display() {
        System.out.println("Makanan " + getNama() + " dengan harga " + getHarga());
    }
}

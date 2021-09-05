package favfilms;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FilmData {
    private static final FilmData instance = new FilmData();
    private DateTimeFormatter format;
    private ObservableList<Films> filmList;

    private FilmData() {
        format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public static FilmData getInstance() {
        return instance;
    }

    //onAppInitialize
    public void readFilms() {
        //split Title, Desc, ReleaseDate with "\t"
        filmList = FXCollections.observableArrayList();

        try (BufferedReader rd = new BufferedReader(new FileReader("films.txt"))) {
            String filmLine;
            while((filmLine = rd.readLine()) != null){
                String[] splitted = filmLine.split("\t");
                String title = splitted[0];
                String desc = splitted[1];
                String releaseDate = splitted[2];
                LocalDate rDate = LocalDate.parse(releaseDate);

                Films readFilm = new Films(title,desc,rDate);
                filmList.add(readFilm);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //onAppDestroy
    public void writeFilms(){
        try(BufferedWriter wr = new BufferedWriter(new FileWriter("films.txt"))) {
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

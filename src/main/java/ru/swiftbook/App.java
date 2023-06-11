package ru.swiftbook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.swiftbook.model.Movie;
import ru.swiftbook.model.Director;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Director director = session.get(Director.class, 1);
//            System.out.println(director);
//            List<Movie> movies = director.getMovies();
//            System.out.println(movies);

//            Movie movie = session.get(Movie.class, 1);
//            System.out.println(movie);
//            Director director = movie.getDirector();
//            System.out.println(director);

//            Director director = session.get(Director.class, 5);
//            System.out.println(director.getMovies());
//            Movie newMovie = new Movie("test movie", 2020, director);
//            director.getMovies().add(newMovie);
//            session.save(newMovie);
//            System.out.println(director.getMovies());

//            Director newDirector = new Director("test director", 20);
//            Movie newMovie = new Movie("test hibernate", 2020, newDirector);
//            newDirector.setMovies(List.of(newMovie));
//            session.save(newDirector);
//            session.save(newMovie);
//            System.out.println(newDirector);

//            Movie movie = session.get(Movie.class, 12);
//            Director director = session.get(Director.class, 7);
//            movie.getDirector().getMovies().remove(movie);
//            movie.setDirector(director);
//            director.getMovies().add(movie);
//            System.out.println(movie.getDirector());
//            System.out.println(director.getMovies());

            Director director = session.get(Director.class, 7);
            System.out.println(director.getMovies());
            Movie movie = session.get(Movie.class, 13);
            session.remove(movie);
            director.getMovies().remove(movie);
            System.out.println(director.getMovies());

            session.getTransaction().commit();
        } finally {


            sessionFactory.close();
        }
    }
}

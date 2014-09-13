package cinema.adoro.com.adorocinema.util;

import java.util.ArrayList;
import java.util.List;

import cinema.adoro.com.adorocinema.domain.Movie;

/**
 * Created by clertonleal on 13/09/14.
 * Adoro Cinema
 */
public class FactorMovies {

    public static List<Movie> getMovies(){
        final List<Movie> movies = new ArrayList<Movie>();
        Movie movie = new Movie();
        movie.setTitle("Homem aranha");
        movie.setSynopsis("Lorem ipsum dolor sit amet, ex quaeque laoreet quo, sea tale purto gubergren at. Epicuri facilisi rationibus et his, no est facer noster. Nemore audiam tibique est id, essent facilis offendit pri in. Pro vidit brute accumsan ex, eum vivendo officiis invidunt at, eum ad noster delectus.\n" +
                "\n" +
                "Te mea vidit disputando, simul deleniti eum id. Mei id dolor impedit imperdiet, vis ex tation virtute, sed blandit forensibus ne. Has nostro accommodare ei, vis at sint laudem blandit. Eu fuisset urbanitas vim, vel mollis viderer at. Eum ut dicta vocibus insolens, at eam possit inermis.\n" +
                "\n" +
                "Nobis dolorem id eam, ei mollis periculis vim, vocibus voluptatum in vel. Usu id tota possit erroribus, ex democritum interpretaris quo, ut qui sale quaeque. Te erat alterum nec, et duo augue quaeque perfecto, vitae affert ad eam. Ea mea esse utamur. Choro legendos eam eu, ius an odio incorrupte instructior, sit cu vero vidisse sapientem.\n" +
                "\n" +
                "Quot adolescens appellantur ei pri. Cu novum tritani facilisi vix. Mea an veri lorem torquatos, no sed vide possim vivendo, sea no verterem persequeris. Viderer maluisset pri in, illum prompta singulis no has. Nam movet oratio nusquam ne.\n" +
                "\n" +
                "Eirmod reprehendunt cu duo, atqui munere referrentur sit ad. Has veniam labore appellantur no, eum soluta signiferumque at. Elit vivendum et eum. Modo inermis epicurei et ius, sea idque commodo ut, an his albucius convenire sadipscing. Et nec nobis deleniti persequeris.");
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("Capitão america");
        movie.setSynopsis("Lorem ipsum dolor sit amet, ex quaeque laoreet quo, sea tale purto gubergren at. Epicuri facilisi rationibus et his, no est facer noster. Nemore audiam tibique est id, essent facilis offendit pri in. Pro vidit brute accumsan ex, eum vivendo officiis invidunt at, eum ad noster delectus.\n" +
                "\n" +
                "Te mea vidit disputando, simul deleniti eum id. Mei id dolor impedit imperdiet, vis ex tation virtute, sed blandit forensibus ne. Has nostro accommodare ei, vis at sint laudem blandit. Eu fuisset urbanitas vim, vel mollis viderer at. Eum ut dicta vocibus insolens, at eam possit inermis.\n" +
                "\n" +
                "Nobis dolorem id eam, ei mollis periculis vim, vocibus voluptatum in vel. Usu id tota possit erroribus, ex democritum interpretaris quo, ut qui sale quaeque. Te erat alterum nec, et duo augue quaeque perfecto, vitae affert ad eam. Ea mea esse utamur. Choro legendos eam eu, ius an odio incorrupte instructior, sit cu vero vidisse sapientem.\n" +
                "\n" +
                "Quot adolescens appellantur ei pri. Cu novum tritani facilisi vix. Mea an veri lorem torquatos, no sed vide possim vivendo, sea no verterem persequeris. Viderer maluisset pri in, illum prompta singulis no has. Nam movet oratio nusquam ne.\n" +
                "\n" +
                "Eirmod reprehendunt cu duo, atqui munere referrentur sit ad. Has veniam labore appellantur no, eum soluta signiferumque at. Elit vivendum et eum. Modo inermis epicurei et ius, sea idque commodo ut, an his albucius convenire sadipscing. Et nec nobis deleniti persequeris.");

        movies.add(movie);
        return movies;
    }

}

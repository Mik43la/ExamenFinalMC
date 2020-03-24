package spotify;
//import spotify.Conector;
import java.sql.SQLException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Testing");
		Conector instancia = Conector.getInstancia();
		try {
			
			ArrayList<String> listNamesArtists = instancia.getNamesE1();
			ArrayList<String> listAlbumsTitles = instancia.getTitlesE2();
			ArrayList<String> listNameArtistSongs = instancia.getArtistNameMorePlayedSongsE3();
			
			System.out.println( "Artists: Name ");
			System.out.println("----------------");
			
			for(String name: listNamesArtists) {
				System.out.println(name);
			}
			
			System.out.println("----------------");
			System.out.println();
			
			System.out.println( "Albums: Titles ");
			System.out.println("----------------");
			
			for(String title: listAlbumsTitles) {
				System.out.println(title);
			}
			
			System.out.println("----------------");
			System.out.println();
			System.out.println( "Artist: Name  (Popular)");
			System.out.println("----------------");
			
			for(String popular: listNameArtistSongs) {
				System.out.println(popular);
			}
			
			System.out.println("----------------");
			System.out.println();
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
	}

}

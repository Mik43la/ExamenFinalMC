package spotify;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Conector {

	
	private static Connection con;

	private static Conector INSTANCE = null;

	// constructor
	private Conector() {

	}

	// Crear instancia
	private synchronized static void crearInstancia() {

		if (INSTANCE == null) {
			INSTANCE = new Conector();
			crearConexion();
		}
	}

	// Obtener instancia
	public static Conector getInstancia() {

		if (INSTANCE == null) {
			crearInstancia();
		}
		return INSTANCE;
	}

	// crear conexion
	private static void crearConexion() {

		String host = "127.0.0.1"; // ( local host)
		String user = "root"; 
		String password = ""; // Mi MySQL no tiene contraseña
		String dataBase = "spotify";

		try {
			// Importando la libreria de conexion de mysql
			Class.forName("com.mysql.jdbc.Driver");
			String urlConexion = "jdbc:mysql://" + host + "/" 
			+ dataBase + "?" + "user=" + user + "&password="
			+ password; 
			con = DriverManager.getConnection(urlConexion);
			System.out.println("Succesful!!!");

		} catch (Exception e) {
			System.out.println("Error al conectar a la base de datos");
			System.out.println(e);
		}
	}
	
	

	
	public ArrayList<String> getNamesE1() throws SQLException {
		ArrayList<String> listNames = new ArrayList<String>();
			PreparedStatement ps = con.prepareStatement(
					"Select artists.name from artists inner join songs on artists.id=songs.artist inner join genres on songs.genre=genres.id && genres.name='rock'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listNames.add(rs.getString("artists.name"));
				
			}
			rs.close();
		return listNames;
	}
	
	public ArrayList<String> getTitlesE2() throws SQLException {
		ArrayList<String> listTitles = new ArrayList<String>();
			PreparedStatement ps = con.prepareStatement(
					"select albums.title from albums inner join songs on albums.id=songs.album && songs.duration>'5:00'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listTitles.add(rs.getString("albums.title"));
				
			}
			rs.close();
		return listTitles;
	}
	
	public ArrayList<String> getArtistNameMorePlayedSongsE3() throws SQLException {
		ArrayList<String> listNameSongs = new ArrayList<String>();
			PreparedStatement ps = con.prepareStatement(
					"Select artists.name from artists inner join songs on artists.id=songs.artist where songs.plays =(select max(plays) from songs)");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listNameSongs.add(rs.getString("artists.name"));
				
			}
			rs.close();
		return listNameSongs;
	}
}


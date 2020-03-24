-- Ejercicio 1
-- Mostrar en nombre de artista que canta canciones del genero rock.
-- 


use spotify;

Select artists.name from artists 
 inner join songs on artists.id=songs.artist 
  inner join genres on songs.genre=genres.id && genres.name='rock';

